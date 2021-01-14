package com.aconex.utils;

public enum Item {
    COM(1) {
        public String toString() {
            return "Communication overhead";
        }
    },
    FUEL(1) {
        public String toString() {
            return "Fuel usage";
        }
    },
    UNCLRTREE(3) {
        public String toString() {
            return "Unclear squares";
        }
    },
    PROTECTEDTREE(10) {
        public String toString() {
            return "Destruction of protected tree";
        }
    },
    PAINT(2) {
        public String toString() {
            return "Paint damage to bulldozer";
        }
    };

    private final int cost;

    private Item(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}