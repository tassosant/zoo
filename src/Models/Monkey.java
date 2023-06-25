package Models;

import InterfacesAndEnums.Homotaxy;

public class Monkey extends Mammal {
    public Monkey(String nickname){
        super(6.5,30,  nickname);
    }

    public String move() {
        return super.move(walk(),run(),jump());
//        walk();
//        run();
//        jump();
    }

//    @Override
//    public void feed() {
//        System.out.println("Bananas");
//    }
}
