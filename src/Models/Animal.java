package Models;

import InterfacesAndEnums.*;

import java.io.Serializable;

public abstract class Animal implements ICrawl, IDive, IFeed, IFly, IJump, IMove, IRun, ISwim, IWalk, Serializable {


    private double avgWeight;
    private int avgMaxAge;

    private Homotaxy homotaxy;

    private String nickname;

    private int Id;

    public Animal(double avgWeight, int avgMaxAge, Homotaxy homotaxy, String nickname) {
        this.avgWeight = avgWeight;
        this.avgMaxAge = avgMaxAge;
        this.homotaxy = homotaxy;
        this.nickname = nickname;
        //this.Id = Ids.get(Ids.size() - 1); //get last increment id
    }

    public void crawl() {
        System.out.print("Crawl");
    }

    public void dive() {
        System.out.print("Dive");
    }

    public void fly() {
        System.out.print("Fly");
    }

    public void jump() {
        System.out.print("Jump");
    }

    public void run() {
        System.out.print("Run");
    }

    public void swim() {
        System.out.println("Swim");
    }

    public void walk() {
        System.out.println("Walk");
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public int getAvgMaxAge() {
        return avgMaxAge;
    }

    public Homotaxy getHomotaxy() {
        return homotaxy;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return Id;
    }

    public void feed(){
        System.out.println(this.nickname+"has just ate!");
    }

    //feed(){
    //System.out.println(getinstanceofobject+"is eating");
    //all animals have eaten
    //}
}
