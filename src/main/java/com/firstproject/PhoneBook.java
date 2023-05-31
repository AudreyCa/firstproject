package com.firstproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {

    public static Scanner sc = null;
    public static final String PHONE_BOOK_FILE_PATH = "C:\\Users\\bou_5\\Desktop\\javaFileTest\\phonebook.txt"; // Constante

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille: ");
        String userFirstName = getUserInput("Entrez un prenom: ");
        String userPhoneNumber = getUserInput("Entrez un numero de telephone: ");

        // On veut créer un nouvel object à partir d'un constructeur dans le fichier (et
        // la Class associée: ) "Contact.
        // On crée donc une méthode qui permet, en Java, d'instancier (créer) des objets
        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

        System.out.println(newContact.toString());

        File phoneBookFile = getOrCreatePhoneBookFile(PHONE_BOOK_FILE_PATH);
        appendContactToPhoneBook(phoneBookFile, newContact);

        sc.close();

    }

    public static String getUserInput(String userRequest) {

        if (userRequest == null || sc == null) {
            return null;
        }

        System.out.println(userRequest);
        return sc.nextLine();
        // nextLine() fait attendre (au Scanner) une entrée utilisateur avant d'exectuer
        // le reste. Ici, on attend quelque chose dans la console pour que le rest du
        // code s\'execute.
    }

    public static File getOrCreatePhoneBookFile(String phoneBookFilePath) {

        File phoneBookFile = new File(phoneBookFilePath);

        // Condition barrière : s'il existe, on le met dans le if et ca stop notre code.
        // Pas besoin d'aller plus loin
        if (phoneBookFile.exists()) {
            return phoneBookFile;
        }

        // Du coup, s'il n'existe pas, on créé le fichier, en gérant l'erreur au cas où
        // il y en aurait.
        try {
            phoneBookFile.createNewFile();
            System.out.println("Du coup, le fichier a ete cree ici : " + phoneBookFilePath);
            return phoneBookFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // et donc en cas d'erreur, on return null pour la gestion d'erreur
        return phoneBookFile;
    }

    public static void appendContactToPhoneBook(File phoneBookFile, Contact newContact) {

        // try {
        //     BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile,
        //             true));
        //     fileWriter.append(newContact.toString() + '\n');
        //     // le antislash est ajouté pour le saut à la ligne entre chaque contact qu'on ajoutera
        //     System.out.println("Contact ajoute");
        //     fileWriter.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        //     // permet d'afficher un log si ca a fait une erreur.
        // }

        // Factorisation d'un try/catch :
        try (BufferedWriter fileWriter = new BufferedWriter(new
        FileWriter(phoneBookFile, true))) {

        fileWriter.append(newContact.toString() + '\n');
        System.out.println("Contact ajoute");
        // fileWriter.close(); // plus besoin de close quand on le met dans le "try". Ca close automatiquement

        } catch (IOException e) {
        e.printStackTrace();
        }

    }
}