package Models;

import Interfaces.IFly;

public class Sparrow extends Animal{

    public Sparrow(String nickname){
        super(0.03,3,Homotaxy.Birds, nickname);
    }

    @Override
    public void move() {
        fly();
        walk();
    }



    @Override
    public void feed() {
        System.out.println("Eats berries, insects!");
    }
}
