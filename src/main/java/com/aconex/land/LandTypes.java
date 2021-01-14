package com.aconex.land;


import com.aconex.land.types.Plain;
import com.aconex.land.types.ProtectedTree;
import com.aconex.land.types.Rock;
import com.aconex.land.types.Tree;

public class LandTypes {
    public LandBlock createLand(char landType) {
        LandBlock land;
        int fuel = 1;
        switch (landType) {
            case 'o':
                land = new Plain(fuel, fuel);
                break;
            case 'r':
                land = new Rock(fuel * 2, fuel);
                break;
            case 't':
                land = new Tree(fuel * 2, fuel);
                break;
            case 'T':
                land = new ProtectedTree();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Invalid Input : There exists an invalid type in the file %s ", landType));
        }
        return land;
    }

}
