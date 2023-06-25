package Models;

import InterfacesAndEnums.Homotaxy;

public class Lion extends Mammal {

    public Lion(String nickname){
        super(200.0,12, Homotaxy.Mammals, nickname);
    }
    @Override
    public void move() {
        walk();
        run();
        jump();
    }



//    @Override
//    public void feed() {
//        System.out.println("Eats other animals!");
//    }
}
