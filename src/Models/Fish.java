package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Fish extends Animal{
    public Fish(double avgWeight, int avgMaxAge,  String nickname) {
        super(avgWeight, avgMaxAge,  nickname);
    }

    public abstract String move();
}
