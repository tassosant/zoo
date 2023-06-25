package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Mammal extends Animal{

    public Mammal(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        super(avgWeight, avgMaxAge, homotaxy, nickname);
    }
}
