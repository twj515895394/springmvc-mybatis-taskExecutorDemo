package com.isea533.mybatis.service;

import com.isea533.mybatis.model.Country;

import java.util.List;

/**
 * Created by Administrator on 2017/4/16.
 */
public interface DemoService {
    public List<Country> selectAll();
    public void testRunTaskExecutor();
}
