package Views;

import Models.Animal;

import java.util.ArrayList;

//we want to create an animal view
public class AnimalView {
    private ArrayList<Animal> animals;

    public AnimalView(ArrayList<Animal> animals){
        this.animals=animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void printColumns(){

        System.out.printf("------------------------------%n");
                        //nickname,homotaxy,age,weight,abilities
        System.out.printf("| '%15s' | '%8s' | '%10s' | '10s%' | '%10s' | %n", "Nickname", "Homotaxy", "Age(years)", "Weight(kg)", "Abilities");

        System.out.printf("------------------------------\n");
    }

    public void PrintRow(Animal animal){
        //
    }
}
