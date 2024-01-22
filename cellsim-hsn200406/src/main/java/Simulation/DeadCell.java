package Simulation;


import Util.Pair;

/**
 * This cell is dead and does nothing
 * its black
 */
public class DeadCell extends Cell{
    public DeadCell(int xInput, int yInput){
        super(0, xInput, yInput, 0);
    }

    public DeadCell(Pair coord){
        super(0, coord.getX(), coord.getY(), 0);
    }


}
