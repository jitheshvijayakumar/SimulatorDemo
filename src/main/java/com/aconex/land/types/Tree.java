package com.aconex.land.types;

import com.aconex.land.LandBlock;
import com.aconex.utils.Item;
import com.aconex.utils.Report;

public class Tree extends LandBlock {
    public Tree(int fuelCosttoClear, int fuelCostofClearedLand) {
        super(fuelCosttoClear, fuelCostofClearedLand);
    }

    @Override
    public void clear(boolean stop) {
        if (!visited) {
            visited = true;
            Report.updateReport(Item.UNCLRTREE, 1);
            Report.updateReport(Item.FUEL, fuelCosttoClear);
            if (!stop) {
                Report.updateReport(Item.PAINT, 1);
            }
        } else {
            Report.updateReport(Item.FUEL, fuelCostofClearedLand);
        }
    }

    @Override
    public String toString() {
        return "t";
    }
}
