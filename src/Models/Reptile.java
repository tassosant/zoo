package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Reptile extends Animal{
    public Reptile(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        super(avgWeight, avgMaxAge, homotaxy, nickname);
    }
}
