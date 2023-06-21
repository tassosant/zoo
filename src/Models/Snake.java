package Models;

public class Snake extends Animal{

    public  Snake(String nickname){
        super(2.0,15,Homotaxy.Reptiles, nickname);
    }

    @Override
    public void feed() {
        System.out.println("Eats smaller animals!");
    }

    @Override
    public void move() {
        crawl();
    }
}
