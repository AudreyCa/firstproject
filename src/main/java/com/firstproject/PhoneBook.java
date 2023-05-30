package com.firstproject;

import java.util.Scanner;

public class PhoneBook {

    public static Scanner sc = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille: ");
        String userFirstName = getUserInput("Entrez un prenom: ");
        String userPhoneNumber = getUserInput("Entrez un numero de telephone: ");

        // On veut créer un nouvel object à partir d'un constructeur dans le fichier (et la Class associée: ) "Contact.
        // On crée donc une méthode qui permet, en Java, d'instancier (créer) des objets
        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
        


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