package com.aconex.land.types;

import com.aconex.land.LandBlock;
import com.aconex.utils.Item;
import com.aconex.utils.Report;

public class ProtectedTree extends LandBlock {


    public ProtectedTree() {
    }

    @Override
    public void clear(boolean stop) {
        Report.updateReport(Item.PROTECTEDTREE, 1);
    }

    @Override
    public String toString() {
        return "T";
    }


}
