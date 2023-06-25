package Controllers;

import Models.Animal;
import Views.AnimalView;
import Views.MenuView;

import java.io.*;
import java.util.*;

public class ZooController {
    private static String filename = "animalsData";
    public static int lastId=0;

    private Set<String> categories = new HashSet<String>();
//    private ArrayList<String> categories;

    //all the animals, please add or delete per choice, not set them after search
    private ArrayList<Animal> animals;
    private ArrayList<String> allAnimalNames;
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
        //sort the list
        if(this.animals.size()!=0){
            Collections.sort(this.animals, Comparator.comparingInt(Animal::getId));
            lastId = this.animals.get(this.animals.size()-1).getId();
        }
        this.animalView = new AnimalView(this.animals, classesController.getMaxLengthOfMovementsString());
        this.allAnimalNames = getAllAnimalNamesFromClassesControlller();
    }

    public void handleMenu(){

        //MenuView menuView = new MenuView();
        System.out.println("Welcome to the zoo control");
        String menu[]=MenuView.getMenu();
        int choice = MenuView.renderMenu();
        while (choice!=menu.length){
            if(choice == 1){
                //handleViewAllAnimals
                handleViewAllAnimals();
            } else if (choice==2) {
                //add animal
                handleAddAnimal();
                //instantiate specific animal

                //save the array list to file

                //search by animalName
            }else if (choice==3) {
                handleSearchAnimalByAnimalName();
                //handleSearchByCategory
            }else if (choice==4) {
                //search by id
                handleSearchAnimalById();
                //handleSearchById
            }else if (choice==5) {
                //delete an animal from the list by id
                handleDeleteById();
                //handleDeleteById
            }else if (choice==6) {
                //feed all animals
                //handelFeedAllAnimals
                handleFeedAllAnimals();
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
        animalView.printAnimals();
    }

    private void handleAddAnimal(){

        //scan categories choice
        ArrayList<String> animalsPerCategory = handleCategoriesChoice();
        //scan animals which belong to specific chosen category
        String animalString = handleAnimalsPerCategoryChoice(animalsPerCategory);
        //scan animal nickname
        String animalNickname = getAnimalNickname();
        Animal animal = this.classesController.instantiateClassFromString(animalString,animalNickname);

        this.animals.add(animal);
        saveAnimalsToFile(animals);
        animalView.setAnimals(this.animals);
    }

    private ArrayList<String> handleCategoriesChoice(){
        int choice = intCategoryChosen();
        //convert it to array list
        ArrayList<String> categories = new ArrayList<>(this.categories);
        //return an array list of animals per category
        return this.animalsPerCategory.get(categories.get(choice-1));
    }
    private int intCategoryChosen(){
        int choice = 0;
        MenuView.renderAnimalCategoriesMenu(this.categories);
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        while(choice<1 || choice>this.categories.size()){
            System.out.println("Please choose the correct choice!!");
            MenuView.renderAnimalCategoriesMenu(this.categories);
            choice = scanner.nextInt();
        }
        //this is index
        return choice;
    }

    private int intAnimalChosen(ArrayList<String> animals){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        while(choice<1 || choice>animals.size()){
            System.out.println("Please choose the correct choice!!");
            MenuView.renderAnimalsMenu(animals);
            choice = scanner.nextInt();
        }
        return choice;
    }

    private String handleAnimalsPerCategoryChoice(ArrayList<String> animalsPerCategory){
        MenuView.renderAnimalsMenu(animalsPerCategory);
        int choice = intAnimalChosen(animalsPerCategory);

        return (animalsPerCategory.get(choice-1));
    }
    private void handleFeedAllAnimals(){
        for(Animal animal:this.animals){
            animal.feed();
        }
    }

    private String getAnimalNickname(){
        System.out.println("Please write the animal's nickname");
        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        return scanner.nextLine();
    }

    private ArrayList<String> getAllAnimalNamesFromClassesControlller(){
        ArrayList<Animal> animalsBySpecificName;
        ArrayList<String> animalCategories = new ArrayList<>(this.categories);
        ArrayList<String> allAnimalNames =  new ArrayList<>();
        HashMap<String, ArrayList<String>> animalCategoriesHashMap =  this.classesController.getAnimalCategories();
        for(String key : animalCategoriesHashMap.keySet()){
            ArrayList<String> animalsPerCategory = animalCategoriesHashMap.get(key);
            for(String animal: animalsPerCategory){
                allAnimalNames.add(animal);
            }
        }
        return allAnimalNames;


        //this.classesController.getAnimalCategories().values());
        //add to the list the animals by Name


        //if the animal not exists print the proper message
    }


    private void handleSearchAnimalByAnimalName(){
        MenuView.renderAnimalsMenu(allAnimalNames);
        //index
        int choice = intAnimalChosen(allAnimalNames);
        //search the animals
        String animalName = allAnimalNames.get(choice-1);
        ArrayList<Animal> animalsFounded = searchByName(animalName);
        if(animalsFounded!=null){
            animalView.setAnimals(animalsFounded);
            animalView.printAnimals();
        }
    }

    private ArrayList<Animal> searchByName(String animalName){
        ArrayList<Animal> animalsFound = new ArrayList<>();
        boolean founded = false;
        for(Animal animal : this.animals){
            if(animal.getAnimalName().equals(animalName)){
                animalsFound.add(animal);
                founded = true;
            }

        }
        if(!founded){
            return null;
        }

        return (ArrayList<Animal>) animalsFound.clone();
    }

    private void handleSearchAnimalById(){

        Animal animal = searchAnimalById(idChosen("search"));
        if(animal!=null){
            System.out.println("Animal found");
            this.animalView.printColumns();
            this.animalView.printAnimal(animal);
        }
    }

    private int idChosen(String action){
        System.out.println("Please write the id to"+ action+"!");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    private Animal searchAnimalById(int id){
        for(Animal animal : this.animals){
            if(animal.getId()==id){
                return animal;
            }
        }
        return null;
    }

    private int deleteById(int id){
        for(Animal animal : this.animals){
            if(animal.getId()==id){
                this.animals.remove(animal);
                return 1;
            }
        }
        return 0;
    }

    private void handleDeleteById(){
        int id = idChosen("delete");
        int result = deleteById(id);
        if(result==1){
            this.animalView.setAnimals(this.animals);
            saveAnimalsToFile(this.animals);
        }

    }


}
