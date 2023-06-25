package Models;

import InterfacesAndEnums.Homotaxy;

public class Snake extends Reptile{

    public Snake(String nickname){
        super(2.0,15, Homotaxy.Reptiles, nickname);
    }
    public Snake(){
        super(2.0,15,Homotaxy.Reptiles, "tasos");
    }
//    @Override
//    public void feed() {
//        System.out.println("Eats smaller animals!");
//    }

    @Override
    public void move() {
        crawl();
    }
}
