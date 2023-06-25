package Models;

import InterfacesAndEnums.Homotaxy;

public class Salamander extends Amphibian  {
    public Salamander(String nickname){
        super(65.0,10, Homotaxy.Amphibians, nickname);
    }
    @Override
    public void move() {
        crawl();
        swim();
        run();
    }

//    @Override
//    public void feed() {
//        System.out.println("Eats insects!");
//    }
}
