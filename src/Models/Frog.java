package Models;

import InterfacesAndEnums.Homotaxy;

public class Frog extends Amphibian{

    public Frog(String nickname){
        super(0.043,8,  nickname);
    }


    public String move() {
        return super.move(jump(),swim(),walk());
//        jump();
//        swim();
//        walk();
    }



}
