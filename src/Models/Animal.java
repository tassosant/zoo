package Models;

import InterfacesAndEnums.*;

import java.io.Serializable;


import static Controllers.ZooController.lastId;

public abstract class Animal implements ICrawl, IDive, IFeed, IFly, IJump, IMove, IRun, ISwim, IWalk, Serializable {


    private double avgWeight;
    private int avgMaxAge;

    //private Homotaxy homotaxy;

    private String nickname;

    private String animalName;

    private String homotaxy;

    private int Id;

    public Animal(double avgWeight, int avgMaxAge, String nickname) {
        this.avgWeight = avgWeight;
        this.avgMaxAge = avgMaxAge;
        this.homotaxy = getClass().getSuperclass().getSimpleName();
        this.nickname = nickname;
        this.animalName = getClass().getSimpleName();
        this.Id = lastId+1; //get last increment id
    }

    public String getAnimalName() {
        return animalName;
    }

    public String crawl() {
        return "Crawl";
    }

    public String dive() {
        return "Dive";
    }

    public String fly() {
        return "Fly";
    }

    public String jump() {
        return "Jump";
    }

    public String run() {
        return "Run";
    }

    public String swim() {
        return "Swim";
    }

    public String walk() {
        return "Walk";
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public int getAvgMaxAge() {
        return avgMaxAge;
    }

    public String getHomotaxy() {
        return homotaxy;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return Id;
    }

    public void feed(){
        System.out.println(this.nickname+" has just ate!");
    }
    protected String move(String... movements){
        StringBuilder movementsToReturn = new StringBuilder();
        for(String movement:movements){
            movementsToReturn.append(movement).append(",");
        }
        return movementsToReturn.substring(0,movementsToReturn.length()-1);
    }
    //feed(){
    //System.out.println(getinstanceofobject+"is eating");
    //all animals have eaten
    //}

}
