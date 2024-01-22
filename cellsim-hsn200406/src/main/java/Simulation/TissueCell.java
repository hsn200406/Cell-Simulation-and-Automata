package Simulation;


import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 * its red
 */

public class TissueCell extends Cell{
    public TissueCell(int xInput, int yInput){
        super(0, xInput, yInput,1);
    }

    public TissueCell(Pair coord){
        super(0, coord.getX(), coord.getY(), 1);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){
        ArrayList<Integer> cells = collectNeighbors();

        for (int x : cells) {
            if (x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 0) {
                if (Math.random() < 0.7) {
                    Pair coordinates = Calculator.coordFromIndex(x);
                    neighbors.set(x, new TissueCell(coordinates));
                    break;
                }
            }
        }


    }
}
