package Models;

public class Monkey extends Animal {
    public Monkey(String nickname){
        super(6.5,30,Homotaxy.Mammals, nickname);
    }
    @Override
    public void move() {
        walk();
        run();
        jump();
    }

    @Override
    public void feed() {
        System.out.println("Bananas");
    }
}
