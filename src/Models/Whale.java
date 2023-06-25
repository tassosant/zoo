package Models;

import InterfacesAndEnums.Homotaxy;

public class Whale extends Mammal{


    public Whale(String nickname){
        super(10000.0,80,  nickname);
    }

    @Override
    public String move() {
        return super.move(swim(),dive());
//        swim();
//        dive();
    }



//    @Override
//    public void feed() {
//        System.out.println("Small fish!");
//    }
}
