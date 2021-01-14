package com.aconex.land.types;

import com.aconex.land.LandBlock;

public class Plain extends LandBlock {

    public Plain(int fuelCosttoClear, int fuelCostofClearedLand) {
        super(fuelCosttoClear, fuelCostofClearedLand);
    }

    @Override
    public String toString() {
        return "o";
    }
}
