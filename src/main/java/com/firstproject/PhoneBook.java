package com.firstproject;

import java.util.Scanner;

public class PhoneBook {

    public static Scanner sc = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille: ");
        String userFirstName = getUserInput("Entrez un prenom: ");
        String userPhoneNumber = getUserInput("Entrez un numero de telephone: ");

        System.out.println(userLastName);
        System.out.println(userFirstName);
        System.out.println(userPhoneNumber);

        sc.close();

        
    }

    public static String getUserInput(String userRequest) {
        System.out.println(userRequest);
        // nextLine() fait attendre (au Scanner) une entrée utilisateur avant d'exectuer le reste. Ici, on attend quelque chose dans la console pour que le rest du code s\'execute.
        return sc.nextLine();
    }

}