package Models;

import Interfaces.IJump;
import Interfaces.ISwim;

public class Frog extends Animal{

    public Frog(String nickname){
        super(0.043,8, Homotaxy.Amphibians, nickname);
    }

    @Override
    public void move() {
        jump();
        swim();
        walk();
    }



    @Override
    public void feed() {
        System.out.println("Eats insects!");
    }
}
