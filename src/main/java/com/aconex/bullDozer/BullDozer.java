package com.aconex.bullDozer;

public class BullDozer {

    private int bullLocationX;
    private int bullLocationY;
    private int bullFace; // N=0, E=1 , S=2, W=3

    /*
     * BullDozer object constructor
     */
    public BullDozer(int positionX, int positionY, int face) {
        this.bullLocationX = positionX;
        this.bullLocationY = positionY;
        this.bullFace = face;
    }

    public int getBullFace() {
        return bullFace;
    }

    public void setbullFace(int face) {
        this.bullFace = face;
    }

    public int getBullLocationX() {
        return bullLocationX;
    }

    public void setBullLocationX(int x) {
        this.bullLocationX = x;
    }

    public int getBullLocationY() {
        return bullLocationY;
    }

    public void setBullLocationY(int y) {
        this.bullLocationY = y;
    }
}






