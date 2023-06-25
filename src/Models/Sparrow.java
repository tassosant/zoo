package Models;

import InterfacesAndEnums.Homotaxy;

public class Sparrow extends Bird{

    public Sparrow(String nickname){
        super(0.03,3,  nickname);
    }

    @Override
    public String move() {
        return super.move(fly(),walk());
//        fly();
//        walk();
    }



//    @Override
//    public void feed() {
//        System.out.println("Eats berries, insects!");
//    }
}
