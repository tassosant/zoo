package Views;

import java.sql.Array;
import java.util.Scanner;

//we want to create a menu view for the user
public class MenuView {
    private static String menu[] = new String[]
            {
                    "1. View all animals",
                    "2. Add a new animal",
                    "3. Search by nickname",
                    "4. Search by id",
                    "5. Delete by id",
                    "6. Feed all animals",
                    "7. Exit"
            };
    public int renderMenu(){

        System.out.println("Please select a choice between 1 and " + (menu.length-1)+"!");
        for(String menuElement:menu){
            System.out.println(menuElement);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    //check if user type number which is off limits
    public boolean validatedInput(int num){
        if(num<1 || num>menu.length-1){
            return false;
        }
        return true;
    }

    public static String[] getMenu() {
        return menu;
    }
}
