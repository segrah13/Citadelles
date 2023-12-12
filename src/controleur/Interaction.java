package controleur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {
    private static Scanner sc = new Scanner(System.in);

    public static int lireUnEntier() {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                continu = false;
                sc.nextLine();  // vide le scanner jusqu'à la fin de ligne
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un entier : ");
                sc.nextLine();  // vide le scanner jusqu'à la fin de ligne
            }
        } while (continu);
        return i;
    }

    // renvoie un entier lu au clavier compris dans l'intervalle
    //     [borneMin, borneMax[
    public static int lireUnEntier(int i, int j) {
        int entierLu = 0;
        boolean continu = true;

        do {
            try {
                System.out.print("Veuillez entrer un entier entre " + i + " et " + (j - 1) + " : ");
                entierLu = sc.nextInt();

                if (entierLu >= i && entierLu < j) {
                    continu = false;
                } else {
                    System.out.println("La valeur doit être dans l'intervalle [" + i + ", " + (j - 1) + "]. Réessayez.");
                }
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un entier valide : ");
                sc.nextLine();  // vide le scanner jusqu'à la fin de ligne
            }
        } while (continu);

        return entierLu;
    }


    // lit les réponses "oui", "non", "o" ou "n" et renvoie un booléen
    public static boolean lireOuiOuNon() {
        boolean resultat = false;
        boolean continu = true;

        do {
            System.out.print("Veuillez répondre par 'oui' (o) ou 'non' (n) : ");
            String reponse = sc.nextLine().toLowerCase();

            if (reponse.equals("oui") || reponse.equals("o")) {
                resultat = true;
                continu = false;
            } else if (reponse.equals("non") || reponse.equals("n")) {
                continu = false;
            } else {
                System.out.println("Réponse invalide. Veuillez répondre par 'oui' (o) ou 'non' (n).");
            }
        } while (continu);

        return resultat;
    }


    // renvoie une chaîne de caractère lue au clavier :
    public static String lireUneChaine() {
        System.out.print("Veuillez entrer une chaîne de caractères : ");
        return sc.nextLine();
    }

}