/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.isea533.mybatis.service.impl;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.CountryExample;
import com.isea533.mybatis.service.DemoService;
import com.isea533.mybatis.service.ThreadtestService;
import com.isea533.mybatis.threadPool.TestThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzh
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private ThreadtestService threadtestService;


    @Override
    public List<Country> selectAll() {
        batchInsertTest();
//        batchUpdate();

        CountryExample example = new CountryExample();
        example.createCriteria().andCountrycodeIsNotNull();
        return countryMapper.selectByExample(example);
    }

    private int batchInsertTest(){
        List<Country> insertList = new ArrayList<Country>();
        for (int i=1;i<10;i++){
            Country country = new Country();
            country.setCountryname("A00"+i);
            country.setCountrycode("A00"+i);
            insertList.add(country);
        }
        return countryMapper.batchInsert(insertList);
    }


    private int batchUpdate(){
        CountryExample example = new CountryExample();
        example.createCriteria().andIdLessThanOrEqualTo(10);
        List<Country> queryList = countryMapper.selectByExample(example);
        List<Country> updateList= new ArrayList<Country>();
        for (Country country:queryList){
            country.setCountryname(country.getCountryname()+"-GET");
            updateList.add(country);
        }
        return countryMapper.batchUpdate(updateList);
    }

    @Override
    public void testRunTaskExecutor() {
        threadtestService.mainMethod();
    }
}
