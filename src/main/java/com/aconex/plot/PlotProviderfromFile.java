package com.aconex.plot;

import com.aconex.land.LandBlock;
import com.aconex.land.LandTypes;
import com.aconex.land.Plot;
import com.aconex.land.types.ProtectedTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PlotProviderfromFile extends PlotProvider {

    private String fileName;
    private int unclearFields;

    public PlotProviderfromFile(String fileName, LandTypes landTypes) {
        super(landTypes);
        this.fileName = fileName;
    }


    public Plot createPlot() {
        List<String> fieldDetails = new ArrayList<>();
        Plot plot = new Plot();
        try (BufferedReader fileContent = Files.newBufferedReader(Paths.get(fileName))) {
            fieldDetails = fileContent.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Failed to open file");
            //e.printStackTrace();
        }

        if (!fieldDetails.isEmpty()) {
            LandBlock[][] lands = processFieldDetails(fieldDetails);
            plot.setFieldTiles(lands);
            plot.setUnclearBlocks(unclearFields);
            return plot;
        }
        System.out.println("Failed to create Field");
        return plot;
    }


    private LandBlock[][] processFieldDetails(List<String> fieldDetails) {
        LandBlock[][] fieldTiles = new LandBlock[fieldDetails.size()][fieldDetails.get(0).length()];
        for (int i = 0; i < fieldDetails.size(); i++) {
            for (int j = 0; j < fieldDetails.get(i).length(); j++) {
                char typeLand = fieldDetails.get(i).charAt(j);
                LandBlock land = landTypes.createLand(typeLand);
                ;
                if (!(land instanceof ProtectedTree)) {
                    ++unclearFields; // To avoid counting Protected trees against uncleared block.
                }
                fieldTiles[i][j] = land;
            }
        }
        return fieldTiles;
    }

}
