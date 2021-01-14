package com.aconex.command;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.Plot;
import com.aconex.utils.Item;
import com.aconex.utils.Report;


public class Left implements Operation {

    @Override
    public boolean execute(BullDozer bulldozer, Plot plot) {
        int fieldSizeX = plot.getFieldBlocks()[0].length;
        int fieldSizeY = plot.getFieldBlocks().length;
        int currentOrientation = bulldozer.getBullFace();
        currentOrientation = (currentOrientation + 3) % 4;
        bulldozer.setbullFace(currentOrientation);
        Report.updateReport(Item.COM, 1);

        if (!check(bulldozer.getBullLocationX(),bulldozer.getBullLocationY(), fieldSizeX,fieldSizeY)) {
            return false;
        }

        return true;
    }

    private boolean check(int x, int y, int fieldWidth, int fieldDepth) {

        return (x >= 0 && x < fieldWidth && y >= 0 && y < fieldDepth);
    }


    @Override
    public String toString() {
        return "turn left";
    }

}
