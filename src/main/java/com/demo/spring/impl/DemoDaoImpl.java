package com.demo.spring.impl;

import com.demo.spring.api.DemoDao;

/**
 * @author haishen
 * @date 2019/3/21
 */
public class DemoDaoImpl implements DemoDao {

    @Override
    public void select() {
        System.out.println("db 查询！");
    }

    @Override
    public void insert() {
        System.out.println("db 写入！");
    }
}
