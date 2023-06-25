package Models;

import InterfacesAndEnums.Homotaxy;

public class Salamander extends Amphibian  {
    public Salamander(String nickname){
        super(65.0,10,  nickname);
    }

    public String move() {
        return super.move(crawl(),swim(),run());
//        crawl();
//        swim();
//        run();
    }

//    @Override
//    public void feed() {
//        System.out.println("Eats insects!");
//    }
}
