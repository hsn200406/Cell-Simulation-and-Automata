package Simulation;

import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 * it is white
 */

public class ImmuneCell extends Cell{


    public ImmuneCell(int xInput, int yInput){
        super(3, xInput, yInput, 4);
    }

    public ImmuneCell(Pair coord){
        super(3, coord.getX(), coord.getY(), 4);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){
        int count = 0;
        double rand = 0;
        ArrayList<Integer> cells = collectNeighbors();
        int i = 0;
        int min = 0;

        for(int x: cells) {
            if (x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 3) {
                count++;
            }
        }

        int max = count;
        int[] arr = new int[count];

        if(count > 0) {
                for (int x : cells) {
                    if (x >= 0 && x < neighbors.size() && neighbors.get(x).getId() == 3) {
                        arr[i] = x;
                        i++;
                    }
                }
                int random_int = (int)Math.floor(Math.random() * (max - min) + min);
                Pair coordinates = Calculator.coordFromIndex(arr[random_int]);
                neighbors.set(arr[random_int], new DeadCell(coordinates));
            }
        }
    }
