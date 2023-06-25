package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Fish extends Animal{
    public Fish(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        super(avgWeight, avgMaxAge, homotaxy, nickname);
    }
}
