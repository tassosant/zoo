package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Mammal extends Animal{
    //private String homotaxy;

    public Mammal(double avgWeight, int avgMaxAge, String nickname) {
        super(avgWeight, avgMaxAge, nickname);
        //this.homotaxy = getClass().getSuperclass().getSimpleName();
    }




    public abstract String move();
}
