package Controllers;

import Views.MenuView;

import java.util.ArrayList;

public class ZooController {
    private static String filename = "animalsData";
    public static ArrayList<Integer> Ids = new ArrayList<>();
        //when the app opens, read the data from file, find the last id, then start the arraylist IDs incrementing from the last id+1

        //add animal (Ids.add(incr))

        //feed all animals

        //view animals

        //search by category

        //search by id

        //delete an animal from the list by id

        //exit
    public ZooController(){
        //read all data
        //create local arraylist

    }

    public void handleMenu(){

        MenuView menuView = new MenuView();
        System.out.println("Welcome to the zoo control");
        String menu[]=menuView.getMenu();
        int choice = menuView.renderMenu();
        while (choice!=menu.length-1){
            if(choice == 1){
                //handleViewAllAnimals
            } else if (choice==2) {
                //add animal
            }else if (choice==3) {
                //feed all animals
            }else if (choice==4) {
                //search by category
            }else if (choice==5) {
                //search by id
            }else if (choice==6) {
                //delete an animal from the list by id
            }
            //if choice not validated
            if(!menuView.validatedInput(choice)){
                System.out.println("Your choice is invalid. Please select a valid choice between 1 and "+(menu.length-1)+"!");
            }
            choice = menuView.renderMenu();
        }
    }
}
