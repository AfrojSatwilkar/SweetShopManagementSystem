package com.bridglabz.sweetshop;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {

    public static UserInterface instance;

    private UserInterface(){

    }

    public static synchronized UserInterface getInstance(){
        if (instance == null){
            instance = new UserInterface();
        }
        return instance;
    }

    void print(Set<Sweet> set){
        for(Sweet getSweet : set){
            System.out.println(getSweet);
        }
    }

    void printDietSweet(Set<Sweet> set){
        for(Sweet getDietSweet : set){
            if(getDietSweet.propertyType == Sweet.PropertyType.IsDiet){
                System.out.println(getDietSweet);
            }
        }
    }

    void printNormalSweet(Set<Sweet> set){
        for(Sweet getNormalSweet : set){
            if(getNormalSweet.propertyType == Sweet.PropertyType.IsNormal){
                System.out.println(getNormalSweet);
            }
        }
    }

    public int showUserMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for add the sweet \nEnter 2 for delete the sweet \nEnter 3 for edit sweet " +
                "\nEnter 4 for diet sweet \nEnter 5 for normal sweet \nEnter 6 for all sweet \nEnter 7 for exit ");
        int getInput = sc.nextInt();
        return getInput;
    }
}
