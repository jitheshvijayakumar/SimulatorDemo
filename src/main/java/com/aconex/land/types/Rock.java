package com.aconex.land.types;

import com.aconex.land.LandBlock;

public class Rock extends LandBlock {
    public Rock(int fuelCosttoClear, int fuelCostofClearedLand) {
        super(fuelCosttoClear, fuelCostofClearedLand);
    }

    @Override
    public String toString() {
        return "r";
    }
}
