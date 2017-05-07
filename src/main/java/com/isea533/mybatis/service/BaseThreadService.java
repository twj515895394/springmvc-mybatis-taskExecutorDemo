package com.isea533.mybatis.service;

import com.isea533.mybatis.vo.PartitionVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface BaseThreadService {
    /**
     * 获取分段集合
     * @return
     */
    List<PartitionVo> getPartitionList();
}
