package Models;

import InterfacesAndEnums.Homotaxy;

public class Snake extends Reptile{

    public Snake(String nickname){
        super(2.0,15,  nickname);
    }

//    @Override
//    public void feed() {
//        System.out.println("Eats smaller animals!");
//    }


    public String move() {
        return super.move(crawl());
//        crawl();
    }
}
