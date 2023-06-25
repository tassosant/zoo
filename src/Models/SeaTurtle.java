package Models;

import InterfacesAndEnums.Homotaxy;

public class SeaTurtle extends Reptile{
    public SeaTurtle(String nickname){
        super(450.0, 20,  nickname);
    }
//    @Override
//    public void feed() {
//        System.out.println("Eats grass!");
//    }

    @Override
    public String move() {
        return super.move(walk(),swim());
//        walk();
//        swim();
    }
}
