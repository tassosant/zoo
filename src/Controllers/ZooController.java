package Controllers;

import Models.Animal;
import Views.AnimalView;
import Views.MenuView;

import java.io.*;
import java.util.*;

public class ZooController {
    private static String filename = "animalsData";
    public static ArrayList<Integer> Ids = new ArrayList<>();

    private Set<String> categories = new HashSet<String>();

    private ArrayList<Animal> animals;

    private HashMap<String, ArrayList<String>> animalsPerCategory = new HashMap<>();

    ClassesController classesController;

    AnimalView animalView;

        //when the app opens, read the data from file, find the last id, then start the arraylist IDs incrementing from the last id+1

        //add animal (Ids.add(incr))

        //feed all animals

        //view animals

        //search by category

        //search by id

        //delete an animal from the list by id

        //exit
    public ZooController() throws IOException {
        this.classesController = new ClassesController();
        this.animalsPerCategory =  classesController.getAnimalCategories();
        this.categories = MenuView.getAnimalCategories(this.animalsPerCategory);
        //read all data
        this.animals = readAnimalsFromFile();
        this.animalView = new AnimalView(this.animals);
    }

    public void handleMenu(){

        //MenuView menuView = new MenuView();
        System.out.println("Welcome to the zoo control");
        String menu[]=MenuView.getMenu();
        int choice = MenuView.renderMenu();
        while (choice!=menu.length-1){
            if(choice == 1){
                //handleViewAllAnimals
                handleViewAllAnimals();
            } else if (choice==2) {
                //add animal
                handleAddAnimal();
                //instantiate specific animal

                //save the array list to file

            }else if (choice==3) {
                //feed all animals

            }else if (choice==4) {
                //search by category
                //handleSearchByCategory
            }else if (choice==5) {
                //search by id
                //handleSearchById
            }else if (choice==6) {
                //delete an animal from the list by id
                //handleDeleteById
            }
            //if choice not validated
            if(!MenuView.validatedInput(choice)){
                System.out.println("Your choice is invalid. Please select a valid choice between 1 and "+(menu.length-1)+"!");
            }
            choice = MenuView.renderMenu();
        }
    }

    private void saveAnimalsToFile(ArrayList<Animal> animals){
        try (FileOutputStream fos = new FileOutputStream("animalsData");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             ) {

            oos.writeObject(animals);

        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+ e);
            throw new RuntimeException(e);
        } catch (IOException ioe) {

            System.out.println("Error while writing data : "+ ioe);

            ioe.printStackTrace();
        }

    }
    private ArrayList<Animal> readAnimalsFromFile(){
        ArrayList<Animal> animals =new ArrayList<Animal>();
        try (FileInputStream fis = new FileInputStream("animalsData");
             ObjectInputStream ois = new ObjectInputStream(fis);
             ) {

            animals = (ArrayList) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }

        return animals;
    }

    public void handleViewAllAnimals(){
        animalView.printColumns();
    }

    private void handleAddAnimal(){

        //scan categories choice
        ArrayList<String> animalsPerCategory = handleCategoriesChoice();
        String animalString = handleAnimalsPerCategoryChoice(animalsPerCategory);
        String animalNickname = getAnimalNickname();
        Animal animal = this.classesController.instantiateClassFromString(animalString,animalNickname);

        this.animals.add(animal);
        saveAnimalsToFile(animals);
        animalView.setAnimals(this.animals);
    }

    private ArrayList<String> handleCategoriesChoice(){
        int choice = 0;
        MenuView.renderAnimalCategoriesMenu(this.categories);
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        while(choice<1 || choice>this.categories.size()){
            System.out.println("Please choose the correct choice!!");
            MenuView.renderAnimalCategoriesMenu(this.categories);
            choice = scanner.nextInt();
        }
        //convert it to array list
        ArrayList<String> categories = new ArrayList<>(this.categories);
        //return an array list of animals per category
        return this.animalsPerCategory.get(categories.get(choice-1));
    }

    private String handleAnimalsPerCategoryChoice(ArrayList<String> animalsPerCategory){
        MenuView.renderAnimalsByCategoryMenu(animalsPerCategory);
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        while(choice<1 || choice>animalsPerCategory.size()){
            System.out.println("Please choose the correct choice!!");
            MenuView.renderAnimalsByCategoryMenu(animalsPerCategory);
            choice = scanner.nextInt();
        }

        return (animalsPerCategory.get(choice-1));
    }
    private void handleFeedAllAnimals(){

    }

    private String getAnimalNickname(){
        System.out.println("Please write the animal's nickname");
        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        return scanner.nextLine();
    }


}
