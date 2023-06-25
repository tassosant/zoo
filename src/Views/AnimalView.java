package Views;

import Models.Animal;

import java.util.ArrayList;
import java.util.Arrays;

//we want to create an animal view
public class AnimalView {
    private ArrayList<Animal> animals;

    private int maxLengthOfMovementsString;

    private int[] colLengths;
    public AnimalView(ArrayList<Animal> animals, int maxLengthOfMovementsString){
        this.animals=animals;
        //leave it for debugging
        this.maxLengthOfMovementsString = maxLengthOfMovementsString;
        this.maxLengthOfMovementsString = 20;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void printColumns(){
        String animalId = "Id";
        String nicknameColumnName = "Nickname";
        String homotaxyColumnName = "Homotaxy";
        String animalNameColumnName = "Animal's Name";
        String ageColumnName = "Age(years)";
        String weightColumnName = "Weight(kg)";
        String abilitiesColumnName = "Abilities";


        //int rowLength = nicknameColumnName.length()+homotaxyColumnName.length()+ageColumnName.length()+weightColumnName.length()+abilitiesColumnName.length()+6;
        int[] columnLengths = {
            animalId.length(),
            nicknameColumnName.length(),
            homotaxyColumnName.length(),
            animalNameColumnName.length(),
            ageColumnName.length(),
            weightColumnName.length(),
            abilitiesColumnName.length()
        } ;
        this.colLengths = columnLengths.clone();
        int rowLength = 0;
        for(int columnLength:columnLengths){
            rowLength+=columnLength;
        }
        //print the length of dashes, also count the '|' symbol
        String rowTopAndBottomBorder = String.format("-".repeat(rowLength+columnLengths.length+1));

//        String columns=String.format
//                        (
//                         "| %-"+nicknameColumnName.length()  +   "s"
//                        +"| %-"+homotaxyColumnName.length()  +   "s"
//                        +"| %-"+ageColumnName.length()       +   "s"
//                        +"| %-"+weightColumnName.length()    +   "s"
//                        +"| %-"+abilitiesColumnName.length() +   "s"
//                        +"| %n",
//                                nicknameColumnName, homotaxyColumnName, ageColumnName, weightColumnName, abilitiesColumnName
//
//                        )
//                ;

        //System.out.printf("------------------------------%n");
                        //nickname,homotaxy,age,weight,abilities
        //System.out.printf(columns+"| %n", nicknameColumnName, homotaxyColumnName, ageColumnName, weightColumnName, abilitiesColumnName);
        //System.out.println(columns);
        //System.out.printf("------------------------------%n");
        System.out.println(rowTopAndBottomBorder);
        printRow(columnLengths,animalId,nicknameColumnName,homotaxyColumnName, animalNameColumnName,ageColumnName,weightColumnName,abilitiesColumnName);
        System.out.println(rowTopAndBottomBorder);
    }

    private void printRow(int[] lengths,String ...columns){
        StringBuilder formatBuilder = new StringBuilder();
        StringBuilder argsBuilder = new StringBuilder();
        //
        int index = 0;
        for(String column:columns){
            formatBuilder.append("|%-");
            //the last is abilities
            if(index<lengths.length-1) {
                formatBuilder.append(lengths[index++]);
            }else{
                formatBuilder.append(this.maxLengthOfMovementsString);
            }
            formatBuilder.append("s");
            argsBuilder.append(", ").append(column);
        }
        formatBuilder.append("|");
        //in second argument of string format we convert the argsbuilder to an array of strings so the commas will not be a string
        String row = String.format(formatBuilder.toString(), (Object[]) argsBuilder.toString().substring(2,argsBuilder.length()).split(", "));
        System.out.println(row);
    }

    public void printAnimals(){
        for(Animal animal:this.animals){
            printAnimal(animal);
        }
    }

    public void printAnimal(Animal animal){
        printRow(this.colLengths,
                                    String.valueOf(animal.getId()),
                                    animal.getNickname(),
                                    animal.getHomotaxy(),
                                    animal.getAnimalName(),
                                    String.valueOf(animal.getAvgMaxAge()),
                                    String.valueOf(animal.getAvgWeight()),
                                    animal.move())
                ;
    }
}
