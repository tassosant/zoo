package Models;

import InterfacesAndEnums.Homotaxy;

public class Ape extends Mammal {

    public Ape(String nickname) {
        super(200,40, Homotaxy.Mammals, nickname);
    }



    @Override
    public void move() {
        walk();
        run();
        jump();
    }


}
