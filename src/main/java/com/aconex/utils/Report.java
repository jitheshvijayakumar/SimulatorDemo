package com.aconex.utils;

import java.util.HashMap;
import java.util.Map;

public class Report {

    private static Map<Item, Integer> reportMap;

    public static void updateReport(Item item, int amount) {
        Integer total = reportMap.get(item);
        switch (item) {
            case UNCLRTREE:
                reportMap.put(item, total - amount);
                break;
            case FUEL:
            case COM:
            case PROTECTEDTREE:
            case PAINT:
                reportMap.put(item, total == null ? amount : total + amount);
                break;
        }
    }

    public static void initializeReport(int size) {
        reportMap = new HashMap<>();
        reportMap.put(Item.COM, 0);
        reportMap.put(Item.FUEL, 0);
        //System.out.print(size);
        reportMap.put(Item.UNCLRTREE, size);
        reportMap.put(Item.PROTECTEDTREE, 0);
        reportMap.put(Item.PAINT, 0);
    }

    public static Map<Item, Integer> getReportMap() {
        return reportMap;
    }

}


