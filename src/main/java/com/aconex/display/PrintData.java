package com.aconex.display;

import com.aconex.bullDozer.BullDozer;
import com.aconex.command.Operation;
import com.aconex.land.LandBlock;
import com.aconex.land.Plot;
import com.aconex.utils.Item;
import com.aconex.utils.Report;

import java.util.List;


public class PrintData implements PrintReport {

    private static String alignLeft = " %-50s %-15s %-10s";

    @Override
    public void printPlot(Plot plot, BullDozer bulldozer) {
        System.out.println("Welcome to the Aconex site clearing simulator. This is a map of the site:");
        LandBlock[][] land = plot.getFieldBlocks();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                System.out.print(land[i][j].toString());
            }
            System.out.println();
        }
        System.out.println("\nThe bulldozer is currently located at the Northern edge of the site, immediately to the West of the site, and facing East.");
    }


    @Override
    public void printCommands(List<Operation> operations) {
        System.out.println("The simulation has ended at your request. These are the commands you issued: ");
        System.out.print(operations.remove(0).toString());
        for (Operation a : operations) {
            System.out.print(", " + a.toString());
        }
    }


    @Override
    public void printFinalReport() {
        int total = 0;
        System.out.println("\n\nThe cost of this com.aconex.land clearing operation were: ");
        System.out.format(alignLeft, "Item", "Quantity", "Cost");
        System.out.println();
        total += itemizedPrint(Item.COM);
        total += itemizedPrint(Item.FUEL);
        total += itemizedPrint(Item.UNCLRTREE);
        total += itemizedPrint(Item.PROTECTEDTREE);
        total += itemizedPrint(Item.PAINT);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.format(alignLeft, "Total", " ", total);

        System.out.println("\n\nThank you for using the Aconex site clearing simulator.");
    }

    private int itemizedPrint(Item item) {

        int count = Report.getReportMap().get(item);
        int charge = count * item.getCost();
        System.out.format(alignLeft, item.toString(), count, charge);
        System.out.println();
        return charge;
    }


}
