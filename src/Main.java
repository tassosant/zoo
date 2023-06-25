// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//view all animals
//local arraylist and arraylist form file simultaneously
//searchByID, searchByName, searchByNickName
//mammals, birds, reptiles, amphibians, fish, invertebrates (insects, arachnids, mollusks(μαλάκια), crustaceans(οστρακοειδή), worms, jellyfish)
//invertebrates abstract?


import Controllers.ClassesController;
import Controllers.ZooController;
import Models.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) throws IOException {

        ZooController zooController = new ZooController();
        zooController.handleMenu();








    }


//        Animal whale = new Whale();
//        //whale.move();
//        Animal monkey = new Monkey();
//        Animal lion = new Lion();
//        Animal goldfish = new GoldFish();
//        goldfish.move();
//        ArrayList<Animal> animals = new ArrayList<>();
//        animals.add(whale);
//        animals.add(monkey);
//        animals.add(monkey);
//        animals.add(lion);
//        saveAnimalsToFile(animals);
//        ArrayList<Animal> animalsFromFile = readAnimalsFromFile();
//        printAnimalList(animalsFromFile);


//    public static void saveAnimalsToFile(ArrayList<Animal> animals){
//        try (FileOutputStream fos = new FileOutputStream("animalsData");
//             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
//
//            oos.writeObject(animals);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found : "+ e);
//            throw new RuntimeException(e);
//        } catch (IOException ioe) {
//
//            System.out.println("Error while writing data : "+ ioe);
//
//            ioe.printStackTrace();
//        }
//
//    }
//    public static ArrayList<Animal> readAnimalsFromFile(){
//        ArrayList<Animal> animals =new ArrayList<Animal>();
//        try (FileInputStream fis = new FileInputStream("animalsData");
//             ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//            animals = (ArrayList) ois.readObject();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Class not found");
//            c.printStackTrace();
//        }
//
//        return animals;
//    }

    public static void printAnimalList(ArrayList<Animal> animals){
        //foreach loop to read animal
        for (Animal animal:animals) {
            printAnimal(animal);
        }
    }
    public static void printAnimal(Animal animal){
        System.out.println("Printing animal "+animal.getClass().getSimpleName());

    }




//    public static boolean isAbstractClass(String filePath) throws IOException {
//        return searchFile(filePath, "abstract class");
//    }





}

