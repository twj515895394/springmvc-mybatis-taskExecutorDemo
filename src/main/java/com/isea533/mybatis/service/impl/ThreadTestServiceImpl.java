package com.isea533.mybatis.service.impl;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.service.BaseThreadService;
import com.isea533.mybatis.service.ThreadtestService;
import com.isea533.mybatis.service.concurrent.ConsumerServiceImpl;
import com.isea533.mybatis.vo.PartitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class ThreadTestServiceImpl implements ThreadtestService {
    @Autowired
    private CountryMapper countryMapper;

    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    @Override
    public List<PartitionVo> getPartitionList() {
        List<PartitionVo> partitionVos = new ArrayList<PartitionVo>();
        for (int i=0;i<100000;i++){
            PartitionVo partitionVo = new PartitionVo(i);
            partitionVos.add(partitionVo);
        }
        return partitionVos;
    }

    @Override
    public void mainMethod() {

        BlockingQueue<PartitionVo> queue = new LinkedBlockingQueue<PartitionVo>();
        //获取分段数据放入队列 1.用生产者线程获取  2.此处生产者只有一个线程 故无需用多线程处理生产者
        List<PartitionVo> partitionVos = getPartitionList();
        for (PartitionVo partitionVo:partitionVos){
            queue.offer(partitionVo);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(partitionVos.size());

        for (int i=0;i<20;i++){
            ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
            consumerService.setCountDownLatch(countDownLatch);
            consumerService.setQueue(queue);
            consumerService.setCountryMapper(countryMapper);
            taskExecutor.execute(consumerService);
        }

        try {
            countDownLatch.await();
            System.out.println("=========================================已全部执行完毕==============================================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
