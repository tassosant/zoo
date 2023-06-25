package Models;

import InterfacesAndEnums.Homotaxy;

public class Lion extends Mammal {

    public Lion(String nickname){
        super(200.0,12,  nickname);
    }

    public String move() {
        return super.move(walk(),run(),jump());
//        walk();
//        run();
//        jump();
    }



//    @Override
//    public void feed() {
//        System.out.println("Eats other animals!");
//    }
}
