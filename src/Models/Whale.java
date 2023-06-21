package Models;

import Interfaces.ISwim;

public class Whale extends Animal{


    public Whale(String nickname){
        super(10000.0,80,Homotaxy.Mammals, nickname);
    }

    @Override
    public void move() {
        swim();
        dive();
    }



    @Override
    public void feed() {
        System.out.println("Small fish!");
    }
}
