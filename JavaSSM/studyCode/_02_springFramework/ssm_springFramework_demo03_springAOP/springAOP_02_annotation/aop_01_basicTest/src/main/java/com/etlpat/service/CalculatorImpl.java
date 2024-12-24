package com.etlpat.service;

import org.springframework.stereotype.Service;

@Service
// 目标类 -- 计算器，用于实现加减乘除
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
