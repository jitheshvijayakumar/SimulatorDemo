package com.aconex.command;

import com.aconex.bullDozer.BullDozer;
import com.aconex.land.Plot;

public interface Operation {

    public boolean execute(BullDozer bulldozer, Plot plot);
}
