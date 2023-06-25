package Views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//we want to create a menu view for the user
public class MenuView {
    private static String menu[] = new String[]
            {
                    "1. View all animals",
                    "2. Add a new animal",
                    "3. Search by animal name",
                    "4. Search by id",
                    "5. Delete by id",
                    "6. Feed all animals",
                    "7. Exit"
            };
    public static int renderMenu(){

        System.out.println("Please select a choice between 1 and " + (menu.length-1)+"!");
        for(String menuElement:menu){
            System.out.println(menuElement);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    //check if user type number which is off limits
    public static boolean validatedInput(int num){
        if(num<1 || num>menu.length){
            return false;
        }
        return true;
    }

    public static String[] getMenu() {
        return menu;
    }

    public static Set<String> getAnimalCategories(HashMap<String,?> animalCategories){
        Set<String> categories = animalCategories.keySet();
        return categories;
    }

    public static void renderAnimalCategoriesMenu(Set<?> categories){
        System.out.println("Please choose one of the following categories!");
        int index = 1;
        for (Object category : categories){
            System.out.println(String.valueOf(index)+"."+category);
            index++;
        }



    }

    public static ArrayList<String> getAnimalsByCategory(HashMap<String,ArrayList<String>> animalCategories, String category){
        return animalCategories.get(category);
    }

    public static void renderAnimalsMenu(ArrayList<String> animals){
        System.out.println("Please choose one of the following animals!");
        int index = 1;
        for (String animal : animals){
            System.out.println(String.valueOf(index)+"."+animal);
            index++;
        }
    }




}
