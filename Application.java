package com.bridglabz.sweetshop;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public void handleUserSelection(int option) {
        UserInterface userInterface = UserInterface.getInstance();
        SweetRepository sweetRepository = SweetRepository.getInstance();
        Set sweetList = sweetRepository.getSweetList();

        switch (option){
            case 1 :
                Sweet sweet = addSweet();
                sweetRepository.add(sweet);
                break;
            case 2 :
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter sweet name : ");
                String getName = sc.nextLine();
                Sweet deleteSweet = sweetRepository.getSweet(getName);
                sweetRepository.delete(deleteSweet);
                break;
            case 3 :
                editSweet();
                break;
            case 4 :
                System.out.println("Diet sweet : ");
                userInterface.printDietSweet(sweetList);
                break;
            case 5 :
                System.out.println("Normal sweet : ");
                userInterface.printNormalSweet(sweetList);
                break;
            case 6 :
                System.out.println("All sweets : ");
                userInterface.print(sweetList);
                break;
            case 7 :
                System.out.print("Good bye...");
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    private Sweet addSweet() {
        Sweet sweet = new Sweet();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Sweet name : ");
        sweet.name = scan.next();
        System.out.println("Enter sweet price : ");
        sweet.price = scan.nextInt();
        System.out.println("Enter sweet id : ");
        sweet.id = scan.next();
        System.out.println("Category \nEnter 1 for Milk \nEnter 2 for Sugerless \nEnter 3 for ghee" +
                "\nEnter for bengalisweet \nEnter 5 for suger");
        int getCategory = scan.nextInt();
        switch (getCategory){
            case 1 :
                sweet.category = Sweet.Category.MILK;
                break;
            case 2 :
                sweet.category = Sweet.Category.SUGERLESS;
                break;
            case 3 :
                sweet.category = Sweet.Category.GHEE;
                break;
            case 4 :
                sweet.category = Sweet.Category.BENGALISWEET;
                break;
            case 5 :
                sweet.category = Sweet.Category.SUGER;
                break;
            default:
                System.out.println("Invalid Input");
        }

        System.out.println("Color \nEnter 1 for RedWhite \nEnter 2 for White \nEnter 3 for GreenWhite" +
                "\nEnter for Yellow");
        int getColor = scan.nextInt();
        switch (getColor) {
            case 1:
                sweet.color = Sweet.Color.RED_WHITE;
                break;
            case 2:
                sweet.color = Sweet.Color.WHITE;
                break;
            case 3:
                sweet.color = Sweet.Color.GREEN_WHITE;
                break;
            case 4:
                sweet.color = Sweet.Color.YELLOW;
                break;
            default:
                System.out.println("Invalid Input");
        }

        System.out.println("Color \nEnter 1 for diet sweet \nEnter 2 for normal sweet");
        int getType = scan.nextInt();
        switch (getType) {
            case 1:
                sweet.propertyType = Sweet.PropertyType.IsDiet;
                break;
            case 2:
                sweet.propertyType = Sweet.PropertyType.IsNormal;
                break;
            default:
                System.out.println("Invalid Input");
        }
        return sweet;
    }

    private void editSweet() {
        SweetRepository sweetRepository = SweetRepository.getInstance();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter sweet name : ");
        String getSweetName = scan.nextLine();
        Sweet editName = sweetRepository.getSweet(getSweetName);
        System.out.println("Enter 1 for edit category \nEnter 2 for color" +
                "\nEnter 3 for price \nEnter 4 for id \nEnter 5 for name");
        int getInput = scan.nextInt();
        switch (getInput){
            case 1 :
                System.out.println("Enter 1 for Milk \nEnter 2 for Sugerless \nEnter 3 for ghee" +
                        "\nEnter for bengalisweet \nEnter 5 for suger");
                int getCategory = scan.nextInt();
                switch (getCategory){
                    case 1 :
                        editName.category = Sweet.Category.MILK;
                        break;
                    case 2 :
                        editName.category = Sweet.Category.SUGERLESS;
                        break;
                    case 3 :
                        editName.category = Sweet.Category.GHEE;
                        break;
                    case 4 :
                        editName.category = Sweet.Category.BENGALISWEET;
                        break;
                    case 5 :
                        editName.category = Sweet.Category.SUGER;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                break;
            case 2 :
                System.out.println("Enter 1 for RedWhite \nEnter 2 for White \nEnter 3 for GreenWhite" +
                        "\nEnter 4 for Yellow");
                int getColor = scan.nextInt();
                switch (getColor) {
                    case 1:
                        editName.color = Sweet.Color.RED_WHITE;
                        break;
                    case 2:
                        editName.color = Sweet.Color.WHITE;
                        break;
                    case 3:
                        editName.color = Sweet.Color.GREEN_WHITE;
                        break;
                    case 4:
                        editName.color = Sweet.Color.YELLOW;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                break;
            case 3 :
                editName.price = scan.nextInt();
                break;
            case 4 :
                editName.id = scan.next();
                break;
            case 5 :
                editName.name = scan.next();
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    public static void main(String[] args) {
        int option =0;
        final int EXIT = 7;
        System.out.println("Welocme to sweet shop management system ");
        Application application = new Application();
        UserInterface userInterface = UserInterface.getInstance();
        while(option != EXIT) {
            option = userInterface.showUserMenu();
            application.handleUserSelection(option);
        }
    }
}