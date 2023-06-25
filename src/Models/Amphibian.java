package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Amphibian extends Animal{
    public Amphibian(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        super(avgWeight, avgMaxAge, homotaxy, nickname);
    }
}
