package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Amphibian extends Animal{
    public Amphibian(double avgWeight, int avgMaxAge, String nickname) {
        super(avgWeight, avgMaxAge , nickname);
    }

    public abstract String move();
}
