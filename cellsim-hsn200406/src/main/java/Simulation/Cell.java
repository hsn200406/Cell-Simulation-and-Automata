//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Simulation;

import Util.Calculator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cell {
    private int strength;
    private int id;
    protected int x;
    protected int y;
    private HashMap<String, Double> concentrations;
    private HashSet<String> signalMolecules;

    public ArrayList<Integer> collectNeighbors() {
        ArrayList<Integer> cells = new ArrayList();

        for(int x = -1; x <= 1; ++x) {
            for(int y = -1; y <= 1; ++y) {
                cells.add(Calculator.indexFromCoord(this.getX() + x, this.getY() + y));
            }
        }

        return cells;
    }

    public Cell() {
        this.strength = 0;
        this.x = 0;
        this.y = 0;
        this.id = 0;
        this.concentrations = new HashMap();
        this.signalMolecules = new HashSet();
    }

    public Cell(int strength, int x, int y, int id) {
        this.setStrength(strength);
        this.setX(x);
        this.setY(y);
        this.setId(id);
    }

    public void addConcentration(String chemical, Double concentration) {
        this.concentrations.put(chemical, concentration);
    }

    public void addSignalMolecule(String signal) {
        this.signalMolecules.add(signal);
    }

    public void setStrength(int strength) {
        if (strength > 0) {
            this.strength = strength;
        } else {
            this.strength = 0;
        }
    }

    public int getStrength() {
        return this.strength;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        } else {
            this.x = 0;
        }

    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        } else {
            this.y = 0;
        }

    }

    public int getY() {
        return this.y;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            this.id = 0;
        }

    }

    public int getId() {
        return this.id;
    }

    public void interactNeighbors(ArrayList<Cell> neighbors) {
    }
}
