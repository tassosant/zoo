package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Bird extends Animal{
    public Bird(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        super(avgWeight, avgMaxAge, homotaxy, nickname);
    }
}
