package Models;

import InterfacesAndEnums.Homotaxy;

public class Ape extends Mammal {

    public Ape(String nickname) {
        super(200,40, nickname);
    }



    @Override
    public String move() {
        return super.move(walk(),run(),jump());
        //walk();
        //run();
        //jump();
    }


}
