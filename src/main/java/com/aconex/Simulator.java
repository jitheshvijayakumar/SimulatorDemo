package com.aconex;

import com.aconex.bullDozer.BullDozer;
import com.aconex.command.*;
import com.aconex.display.PrintData;
import com.aconex.display.PrintReport;
import com.aconex.land.LandTypes;
import com.aconex.land.Plot;
import com.aconex.plot.PlotProvider;
import com.aconex.plot.PlotProviderfromFile;
import com.aconex.utils.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulator {

    private static final Scanner scanner = new Scanner(System.in);
    private static PrintReport printReport = new PrintData();
    private static List<Operation> operations = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Provide the full Location to input file ");
        String fileName = scanner.next();
        //String fileName = "dataFile.txt";
        LandTypes landTypes = new LandTypes();
        PlotProvider plotP = new PlotProviderfromFile(fileName, landTypes);
        Plot plot = null;
        BullDozer bulldozer = null;
        boolean flag = true;
        try {
            plot = plotP.createPlot();
            bulldozer = new BullDozer(-1, 0, 1);
            printReport.printPlot(plot, bulldozer);
            Report.initializeReport(plot.getUnclearBlocks());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Unable to Process the File");
            flag = false;
        }


        while (flag) {
            System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit: ");
            String command = scanner.next();
            Operation operation = null;
            switch (command.charAt(0)) {
                case 'a':
                    int iteration = scanner.nextInt();
                    operation = new Advance(iteration);
                    break;
                case 'l':
                    operation = new Left();
                    break;
                case 'r':
                    operation = new Right();
                    break;
                case 'q':
                    operation = new Quit();
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid com.aconex.command");
                    break;
            }

            if (operation != null) {
                flag = operation.execute(bulldozer, plot);
                operations.add(operation);
            }
        }

        printReport.printCommands(operations);
        printReport.printFinalReport();


    }


}
