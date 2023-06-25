package Models;

import InterfacesAndEnums.Homotaxy;

public class SeaTurtle extends Reptile{
    public SeaTurtle(String nickname){
        super(450.0, 20, Homotaxy.Amphibians, nickname);
    }
//    @Override
//    public void feed() {
//        System.out.println("Eats grass!");
//    }

    @Override
    public void move() {
        walk();
        swim();
    }
}
