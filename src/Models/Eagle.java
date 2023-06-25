package Models;

import InterfacesAndEnums.Homotaxy;

public class Eagle extends Bird {


    public Eagle(String nickname) {
        super(5.0, 25,  nickname);
    }


    public String move() {
        return super.move(walk(),fly());
//        walk();
//        fly();
    }


}
