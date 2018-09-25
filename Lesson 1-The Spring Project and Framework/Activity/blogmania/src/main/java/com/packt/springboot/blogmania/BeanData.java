package com.packt.springboot.blogmania;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BeanData {
    private final String bean;
    private final String beanClass;
}
