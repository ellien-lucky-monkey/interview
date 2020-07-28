package com.interview.experience.actual.std;

import java.util.List;

public class BizOrderConfig {

    private Long id;
    private String key;
    private String config;

    private List<BizOrderConfigRange> skuRangeList;
    private List<BizOrderConfigRange> categoryRangeList;


    private static final Integer inboundAction = 1;
    private static final Integer transferAction = 2;


    private static final Integer order_type = 1;




}
