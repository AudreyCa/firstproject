package com.firstproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        System.out.println(newContact.toString());

        File phoneBookFile = new File("C:\\Users\\bou_5\\Desktop\\javaFileTest\\phonebook.txt");

        if(phoneBookFile.exists()) {
            System.out.println("Le fichier existe dans l'emplacement donne");
        } else {
            System.out.println("Le fichier n'existe pas");

            try {
                phoneBookFile.createNewFile();
                System.out.println("Le fichier a ete cree");
            } catch (IOException e) {
                e.printStackTrace();
            }
            

        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));
            fileWriter.append(newContact.toString() + '\n');
            // le antislash est ajouté pour le saut à la ligne entre chaque contact qu'on ajoutera
            System.out.println("Contact ajoute");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            // permet d'afficher un log si ca a fait une erreur.
        }

        sc.close();

        
    }

    public static String getUserInput(String userRequest) {

        if(userRequest == null || sc == null) {
            return null;
        }
        
        System.out.println(userRequest);
        return sc.nextLine();
        // nextLine() fait attendre (au Scanner) une entrée utilisateur avant d'exectuer le reste. Ici, on attend quelque chose dans la console pour que le rest du code s\'execute.
    }

}