package Models;

import InterfacesAndEnums.Homotaxy;

public class Sparrow extends Bird{

    public Sparrow(String nickname){
        super(0.03,3, Homotaxy.Birds, nickname);
    }

    @Override
    public void move() {
        fly();
        walk();
    }



//    @Override
//    public void feed() {
//        System.out.println("Eats berries, insects!");
//    }
}
