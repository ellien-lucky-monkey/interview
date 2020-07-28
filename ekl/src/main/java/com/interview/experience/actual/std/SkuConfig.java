package com.interview.experience.actual.std;


import java.util.List;

public class SkuConfig {



    public static class InboundSkuConfig {
        private Long skuId;
        private Integer validPeriod;
        private PositionTypeEnum defaultInboundStockType;
        private List<PositionTypeEnum> allowInboundStockTypes;
    }



    public static class OutboundSkuConfig {
        private Long skuId;
        private Integer validPeriod;
        private PositionTypeEnum outboundStockType;
    }

    public static class AdjustConfig {
        private Integer validPeriod;
    }

    public static class MigrateConfig {
        private Long skuId;
        private Integer validPeriod;
        private PositionTypeEnum transferIntoStockType;
        private PositionTypeEnum transferOutStockType;
    }
}
