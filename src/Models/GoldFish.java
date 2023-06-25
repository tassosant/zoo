package Models;

import InterfacesAndEnums.Homotaxy;

public class GoldFish extends Fish {


    public GoldFish(String nickname){
        super(1.0,25,  nickname);
    }


    public String move() {
        return super.move(swim());
        //swim();
    }


//    @Override
//    public void feed() {
//        System.out.println("Eats brine shrimp!");
//    }
}
