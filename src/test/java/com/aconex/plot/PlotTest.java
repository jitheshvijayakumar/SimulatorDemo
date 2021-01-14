package com.aconex.plot;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.LandBlock;
import com.aconex.land.LandTypes;
import com.aconex.land.types.Plain;
import com.aconex.land.types.ProtectedTree;
import com.aconex.land.types.Rock;
import com.aconex.land.types.Tree;
import com.aconex.utils.Item;
import com.aconex.utils.Report;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlotTest {
    BullDozer bullDozer;

    @Test
    public void visitPlainTest() {
        Report.initializeReport(100);
        LandBlock plainLand = new Plain(1,1);
        plainLand.clear(false);
        assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(99, Report.getReportMap().get(Item.UNCLRTREE).intValue());
    }


    @Test
    public void visitRockTest() {
        Report.initializeReport(100);
        LandBlock rock = new Rock(2,1);
        rock.clear(false);
        assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
    }


    @Test
    public void visitTreeTest() {
        Report.initializeReport(100);
        LandBlock tree = new Tree(2,1);
        tree.clear(false);
        assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());

    }


    @Test
    public void visitProtectedTreeTest() {
        Report.initializeReport(100);
        LandBlock protectedTree = new ProtectedTree();
        protectedTree.clear(false);
        assertEquals(1, Report.getReportMap().get(Item.PROTECTEDTREE).intValue());

    }

    @Test
    public void visitTwiceTest() {
        Report.initializeReport(100);
        LandBlock plainLand = new Plain(1,1);
        plainLand.clear(false);
        assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(99, Report.getReportMap().get(Item.UNCLRTREE).intValue());
        plainLand.clear(false);
        assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
        assertEquals(99, Report.getReportMap().get(Item.UNCLRTREE).intValue());

    }




}