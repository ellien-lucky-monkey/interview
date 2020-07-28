package com.interview.experience.actual.std;


import java.util.List;

public class BizOrderConfigDTO {



    private List<OutboundConfig> outboundConfigs;
    private List<AdjustConfig> adjustConfigs;
    private List<MigrateConfig> migrateConfigs;


    public static class InboundConfigs {
        private String key;
        private List<InboundConfig> inboundConfigs;

    }

    public static class InboundConfig {

        private List<Long> skuIds;
        private List<Long> categoryIds;
        private Integer validPeriod;
        private PositionTypeEnum defaultInboundStockType;
        private List<PositionTypeEnum> allowInboundStockTypes;
    }

    public static class OutboundConfig {
        private List<Long> skuIds;
        private List<Long> categoryIds;
        private Integer validPeriod;
        private PositionTypeEnum outboundStockType;
    }

    public static class AdjustConfig {
        private Integer validPeriod;
    }

    public static class MigrateConfig {
        private List<Long> skuIds;
        private List<Long> categoryIds;
        private Integer validPeriod;
        private PositionTypeEnum transferIntoStockType;
        private PositionTypeEnum transferOutStockType;
    }
}
