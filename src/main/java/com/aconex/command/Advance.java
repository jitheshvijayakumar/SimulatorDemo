package com.aconex.command;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.LandBlock;
import com.aconex.land.Plot;
import com.aconex.utils.Item;
import com.aconex.utils.Report;

public class Advance implements Operation {

    private int iteration;

    public Advance(int iterations) {
        this.iteration = iterations;
    }

    @Override
    public boolean execute(BullDozer bulldozer, Plot plot) {

        int fieldSizeX = plot.getFieldBlocks()[0].length;
        int fieldSizeY = plot.getFieldBlocks().length;

        Report.updateReport(Item.COM, 1);


        if (!validateMove(bulldozer, fieldSizeX, fieldSizeY)) {
            return false;
        }

        return visitPlot(bulldozer, plot);


    }

    /**
     * Validates if the bulldozer does not go outside the field
     */
    private boolean validateMove(BullDozer bulldozer, int fieldSizeX, int plotWidth) {

        switch (bulldozer.getBullFace()) {

            case 0:

                return check(bulldozer.getBullLocationX(), bulldozer.getBullLocationY() - iteration, fieldSizeX, plotWidth);
            case 1:

                return check(bulldozer.getBullLocationX() + iteration, bulldozer.getBullLocationY(), fieldSizeX, plotWidth);
            case 2:

                return check(bulldozer.getBullLocationX(), bulldozer.getBullLocationY() + iteration, fieldSizeX, plotWidth);
            case 3:

                return check(bulldozer.getBullLocationX() - iteration, bulldozer.getBullLocationY(), fieldSizeX, plotWidth);
        }
        return false;

    }

    private boolean check(int x, int y, int fieldWidth, int fieldDepth) {
        return (x >= 0 && x < fieldWidth && y >= 0 && y < fieldDepth);
    }

    private boolean visitPlot(BullDozer bulldozer, Plot plot) {
        int x = bulldozer.getBullLocationX();
        int y = bulldozer.getBullLocationY();
        for (int i = 1; i <= iteration; i++) {
            LandBlock land = null;
            switch (bulldozer.getBullFace()) {

                case 0:
                    y -= 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y += 1;
                    break;
                case 3:
                    x -= 1;
                    break;

            }
            //System.out.println("X :" + x + " Y :" + y);
            land = plot.getFieldBlocks()[y][x];
            land.clear(i == iteration);
            boolean destroy = Report.getReportMap().get(Item.PROTECTEDTREE) == 1;
            if (destroy) {
                return false;
            }
        }
        bulldozer.setBullLocationX(x);
        bulldozer.setBullLocationY(y);


        return true;
    }


    @Override
    public String toString() {
        return "advance " + iteration;
    }

}
