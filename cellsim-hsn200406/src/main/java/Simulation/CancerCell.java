package Simulation;


import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 * Growing means turning a dead cell into a CancerCell.
 * It is green
 */

public class CancerCell extends Cell{

    public CancerCell(int xInput, int yInput){
        super(1, xInput, yInput, 3);
    }

    public CancerCell(Pair coord){
        super(1, coord.getX(), coord.getY(), 3);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){
        ArrayList<Integer> cells = collectNeighbors();
        int DeadNeighbor = 0;
        int TissueNeighbor = 0;
        int ImmuneNeighbor = 0;
        int i = 0;
        int min = 0;

        for(int x: cells){
            if(x >= 0 && x < neighbors.size()) {
                if (neighbors.get(x).getId() == 0) {
                    DeadNeighbor++;
                } else if (neighbors.get(x).getId() == 1) {
                    TissueNeighbor++;
                } else if (neighbors.get(x).getId() == 4) {
                    ImmuneNeighbor++;
                }
            }
        }
        int[] arr1 = new int[TissueNeighbor];
        for(int x: cells) {
            if (x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 1) {
                arr1[i] = x;
                i++;
            }
        }
        int max = TissueNeighbor;

        int[] arr2 = new int[ImmuneNeighbor];
        i = 0;
        for(int x: cells) {
            if (x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 4) {
                arr2[i] = x;
                i++;
            }
        }
        int max2 = ImmuneNeighbor;

        if(DeadNeighbor > 0){
            for(int x: cells){
                if(x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 0){
                    Pair coordinates = Calculator.coordFromIndex(x);
                    neighbors.set(x, new CancerCell(coordinates));
                    break;
                }
            }
        }

        else if(TissueNeighbor > ImmuneNeighbor && TissueNeighbor >= 1){
            int random_int = (int)Math.floor(Math.random() * (max - min) + min);
            Pair coordinates = Calculator.coordFromIndex(arr1[random_int]);
            neighbors.set(arr1[random_int], new DeadCell(coordinates));
        }

        else if(ImmuneNeighbor > 0){
            int random_int = (int)Math.floor(Math.random() * (max2 - min) + min);
            int newStrength = neighbors.get(arr2[random_int]).getStrength() - 1;
            neighbors.get(arr2[random_int]).setStrength(newStrength);
            Pair coordinates = Calculator.coordFromIndex(arr2[random_int]);
            neighbors.set(arr2[random_int], new DeadCell(coordinates));
        }

    }

}
