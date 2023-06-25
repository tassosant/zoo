package Models;

import InterfacesAndEnums.Homotaxy;

public abstract class Bird extends Animal{
    public Bird(double avgWeight, int avgMaxAge, String nickname) {
        super(avgWeight, avgMaxAge,  nickname);
    }

    public abstract String move();
}
