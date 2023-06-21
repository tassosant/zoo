package Models;

import Interfaces.IFly;
import Interfaces.IWalk;

public class Eagle extends Animal {


    public Eagle(String nickname) {
        super(5.0, 25, Homotaxy.Birds, nickname);
    }

    @Override
    public void move() {
        walk();
        fly();
    }

    @Override
    public void feed() {
        System.out.println("Eats small animals!");
    }
}
