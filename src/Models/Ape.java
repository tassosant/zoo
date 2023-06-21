package Models;

import Interfaces.IJump;
import Interfaces.IRun;
import Interfaces.IWalk;

public class Ape extends Animal {

    public Ape(String nickname) {
        super(200,40,Homotaxy.Mammals, nickname);

    }

    @Override
    public void move() {
        walk();
        run();
        jump();
    }

    @Override
    public void feed() {
        System.out.println("Eats fruits!");
    }
}
