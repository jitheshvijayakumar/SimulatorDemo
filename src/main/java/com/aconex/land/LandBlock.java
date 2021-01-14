package com.aconex.land;

import com.aconex.utils.Item;
import com.aconex.utils.Report;

public abstract class LandBlock {

    protected boolean visited;
    protected int fuelCosttoClear;
    protected int fuelCostofClearedLand;

    public LandBlock(int fuelCosttoClear, int fuelCostofClearedLand) {
        this.fuelCosttoClear = fuelCosttoClear;
        this.fuelCostofClearedLand = fuelCostofClearedLand;
    }

    public LandBlock() {
    }

    public void clear(boolean stop) {
        if (!visited) {
            visited = true;
            Report.updateReport(Item.UNCLRTREE, 1);
            Report.updateReport(Item.FUEL, fuelCosttoClear);
        } else {
            Report.updateReport(Item.FUEL, fuelCostofClearedLand);
        }
    }

    public int getFuelCosttoClear() {

        return fuelCosttoClear;
    }

    public void setFuelCosttoClear(int fuelCosttoClear) {
        this.fuelCosttoClear = fuelCosttoClear;
    }

    public int getFuelCostofClearedLand() {

        return fuelCostofClearedLand;
    }

    public void setFuelCostofClearedLand(int fuelCostofClearedLand) {
        this.fuelCostofClearedLand = fuelCostofClearedLand;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


}
