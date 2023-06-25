package Models;

import InterfacesAndEnums.Homotaxy;

public class Eagle extends Bird {


    public Eagle(String nickname) {
        super(5.0, 25, Homotaxy.Birds, nickname);
    }

    @Override
    public void move() {
        walk();
        fly();
    }


}
