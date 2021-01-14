package com.aconex.command;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.LandTypes;
import com.aconex.land.Plot;
import com.aconex.plot.PlotProvider;
import com.aconex.plot.PlotProviderfromFile;
import com.aconex.utils.Report;
import com.aconex.utils.Item;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperationsTest {

    BullDozer bullDozer;

    @Test
    public void executeLeft() {
        bullDozer = new BullDozer(1,1,1);
        Operation operation = new Left();
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(0,bullDozer.getBullFace());
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
    }

    @Test
    public void executeRight() {
        bullDozer = new BullDozer(5,5,1);
        Operation operation = new Right();
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(2,bullDozer.getBullFace());
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
    }

    @Test
    public void executeAdvance() {
        bullDozer = new BullDozer(1,1,1);
        Operation operation = new Advance(10);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(1,bullDozer.getBullFace());
        assertEquals(1,bullDozer.getBullLocationY());
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
    }

    @Test
    public void executeAdvanceOut() {
        bullDozer = new BullDozer(1,1,1);
        Operation operation = new Advance(25);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        boolean outcome = operation.execute(bullDozer, plot);
        assertFalse(outcome);
    }


    @Test
    public void executeInitialLeft() {
        bullDozer = new BullDozer(-1,-1,1);
        Operation operation = new Left();
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        boolean outcome = operation.execute(bullDozer, plot);
        assertFalse(outcome);
    }

    @Test
    public void executeInitialRight() {
        bullDozer = new BullDozer(-1,-1,1);
        Operation operation = new Right();
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        boolean outcome = operation.execute(bullDozer, plot);
        assertFalse(outcome);
    }

    @Test
    public void executeAdvancetoPlain() {
        bullDozer = new BullDozer(1,1,1);
        Operation operation = new Advance(1);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
        assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(0, Report.getReportMap().get(Item.PROTECTEDTREE).intValue());
    }

    @Test
    public void executeAdvancetoRock() {
        bullDozer = new BullDozer(1,3,1);
        Operation operation = new Advance(1);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
        assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(0, Report.getReportMap().get(Item.PROTECTEDTREE).intValue());
    }

    @Test
    public void executeAdvancetoTree() {
        bullDozer = new BullDozer(4,0,1);
        Operation operation = new Advance(1);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
        assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(47, Report.getReportMap().get(Item.UNCLRTREE).intValue());
    }

    public void executeAdvancetoProtectedtree() {
        bullDozer = new BullDozer(6,2,1);
        Operation operation = new Advance(1);
        String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = plotP.createPlot();
        Report.initializeReport(plot.getUnclearBlocks());
        operation.execute(bullDozer, plot);
        assertEquals(1, Report.getReportMap().get(Item.COM).intValue());
        assertEquals(1, Report.getReportMap().get(Item.PROTECTEDTREE).intValue());
    }

}