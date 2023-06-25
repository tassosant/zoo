package Models;

import InterfacesAndEnums.Homotaxy;

public class Frog extends Amphibian{

    public Frog(String nickname){
        super(0.043,8, Homotaxy.Amphibians, nickname);
    }

    @Override
    public void move() {
        jump();
        swim();
        walk();
    }



}
