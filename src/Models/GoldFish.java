package Models;

import Interfaces.IDive;
import Interfaces.ISwim;

public class GoldFish extends Animal{


    public GoldFish(String nickname){
        super(1.0,25,Homotaxy.Fish, nickname);
    }

    @Override
    public void move() {
        swim();
    }


    @Override
    public void feed() {
        System.out.println("Eats brine shrimp!");
    }
}
