package com.isea533.mybatis.service.concurrent;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.vo.PartitionVo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/5/7.
 */
public class ConsumerServiceImpl extends AbstractConsumerServiceImpl {
    private CountDownLatch countDownLatch;

    private BlockingQueue<PartitionVo> queue;

    private CountryMapper countryMapper;


    @Override
    public void run() {
        while (!queue.isEmpty()) {
            PartitionVo partitionVo = queue.poll();
            consumerMethod(countDownLatch,partitionVo);
        }
    }

    void consumerMethod(CountDownLatch countDownLatch,PartitionVo partitionVo){
        try {
            System.out.println(Thread.currentThread().getName()+"=================取出startId:"+partitionVo.getStartId()+"===========================");
//            countryMapper.selectByPrimaryKey(8);
//            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            System.out.println("==================countDownLatch 目前的值为:" + countDownLatch.getCount());//getCount会阻塞
            countDownLatch.countDown();
        }
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public BlockingQueue<PartitionVo> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<PartitionVo> queue) {
        this.queue = queue;
    }

    public CountryMapper getCountryMapper() {
        return countryMapper;
    }

    public void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }
}
