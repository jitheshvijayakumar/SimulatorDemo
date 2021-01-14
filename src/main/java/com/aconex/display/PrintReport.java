package com.aconex.display;

import com.aconex.bullDozer.BullDozer;
import com.aconex.command.Operation;
import com.aconex.land.Plot;

import java.util.List;

public interface PrintReport {

    public void printPlot(Plot plot, BullDozer bulldozer);

    public void printCommands(List<Operation> operations);

    public void printFinalReport();

}
