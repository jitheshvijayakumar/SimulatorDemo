package com.aconex.command;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.Plot;
import com.aconex.utils.Item;
import com.aconex.utils.Report;


public class Quit implements Operation {

    @Override
    public boolean execute(BullDozer bulldozer, Plot plot) {
        Report.updateReport(Item.COM, 1);
        return false;
    }

    @Override
    public String toString() {
        return "quit";
    }

}
