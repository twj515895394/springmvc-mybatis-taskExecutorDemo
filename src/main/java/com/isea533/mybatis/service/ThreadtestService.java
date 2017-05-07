package com.isea533.mybatis.service;

import com.isea533.mybatis.vo.PartitionVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface ThreadtestService extends BaseThreadService {
    @Override
    List<PartitionVo> getPartitionList();

    void mainMethod();
}
