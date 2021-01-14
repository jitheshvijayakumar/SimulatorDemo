package com.aconex.land;

public class Plot {

    private LandBlock[][] plotBlocks;
    private int unclearBlocks;

    public int getUnclearBlocks() {
        return unclearBlocks;
    }

    public void setUnclearBlocks(int clearFields) {
        this.unclearBlocks = clearFields;
    }

    public LandBlock[][] getFieldBlocks() {
        return plotBlocks;
    }

    public void setFieldTiles(LandBlock[][] fieldBlocks) {
        this.plotBlocks = fieldBlocks;
    }


}
