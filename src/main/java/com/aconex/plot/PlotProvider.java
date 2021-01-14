package com.aconex.plot;


import com.aconex.land.LandTypes;
import com.aconex.land.Plot;

public abstract class PlotProvider {
    protected LandTypes landTypes;

    public PlotProvider(LandTypes landTypes) {
        this.landTypes = landTypes;
    }
    public abstract Plot createPlot();

}
