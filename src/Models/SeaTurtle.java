package Models;

public class SeaTurtle extends Animal{
    public SeaTurtle(String nickname){
        super(450.0, 20, Homotaxy.Amphibians, nickname);
    }
    @Override
    public void feed() {
        System.out.println("Eats grass!");
    }

    @Override
    public void move() {
        walk();
        swim();
    }
}
