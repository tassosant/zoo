package Controllers;

import Models.Animal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassesController {
//    private static ArrayList<Animal> animals = new ArrayList<>();


    private static ArrayList<String> animals = new ArrayList<String>();
    private static ArrayList<String> homotaxies = new ArrayList<String>();
    //key = animal category
    //value = arraylist string animals
    private HashMap<String, ArrayList<String>> animalCategories = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAnimalCategories() {
        return animalCategories;
    }

    //for each animal get the type, add the type to the hashmap and update the value
    public ClassesController() throws IOException {
        findAllModels();
        addAllKeysToHashMap();
        addAllValuesToHashMap();
        //printHashMap();
    }

    //initialize hashmap
    private void addAllKeysToHashMap(){
        for(String homotaxy : homotaxies){
            this.animalCategories.put(homotaxy,new ArrayList<>());
        }
    }

    private void addAllValuesToHashMap(){
        for(String animal : animals){
            Animal tempAnimal = instantiateClassFromString(animal,"fake");
            String homotaxy = tempAnimal.getClass().getSuperclass().getSimpleName();
            //update the value
            animalCategories.get(homotaxy).add(animal);
        }

    }

    //use reflection
    public Animal instantiateClassFromString(String className, String nickname){
        try {
            Class<?> clazz = Class.forName("Models."+className);
            Animal instance = (Animal) instantiateObject(clazz,nickname);

            //System.out.println("Object instantiated: " + instance);
            return instance;

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Failed to instantiate object: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    private static Object instantiateObject(Class<?> clazz, String nickname) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InvocationTargetException {
        //get the declared constructor of the class
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        return (Animal) constructor.newInstance(nickname);
    }

    private static void findAllModels() throws IOException {
        String directoryPath = "src/Models";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            findAllFiles(directory);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    public static void findAllFiles(File directory) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //System.out.println("Directory: " + file.getAbsolutePath());
                    findAllFiles(file); // Recursive call to find subdirectories and files
                } else {
                    //System.out.println("File: " + file.getName());


                    //search for abstract class
                    String className = getClassFromFile(file);
                    if(isAbstractClass(file.getPath(), "abstract class")){
                        if(!className.contains("Animal") && !className.contains("Homotaxy")) {
                            homotaxies.add(className);
                        }
                    }else{
                            animals.add(className);
                    }
                }
            }
        }
    }

    public static String getClassFromFile(File filename){
        String filenameWithExtension = filename.getName();
        return filenameWithExtension.substring(0,filenameWithExtension.indexOf(".java"));
    }

    public static boolean isAbstractClass(String filePath, String searchContent) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchContent)) {
                    return true;
                }
            }

            return false;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private  void printHashMap(){
        System.out.println(this.animalCategories);
    }

}
