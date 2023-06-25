package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Reptile extends Animal{
    public Reptile(double avgWeight, int avgMaxAge,  String nickname) {
        super(avgWeight, avgMaxAge, nickname);
    }

    public abstract String move();
}
