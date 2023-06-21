package Views;

import Models.Animal;

import java.util.ArrayList;

//we want to create an animal view
public class AnimalView {
    private ArrayList<Animal> animals;

    public AnimalView(ArrayList<Animal> animals){
        this.animals=animals;
    }

    static void printColumns(){
        //nickname
        //category (name of class)
        //age
        //weight
        //feed
        //abilities
    }

    static void PrintRow(Animal animal){
        //
    }
}
