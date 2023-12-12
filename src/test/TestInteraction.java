package test;

import controleur.Interaction;

public class TestInteraction {
    public static void main(String[] args) {
        TestInteraction testInteraction = new TestInteraction();

        testInteraction.test1();
        testInteraction.test2();
        testInteraction.test3();
        testInteraction.test4();
    }

    public void test1() {
        System.out.println("TEST POUR LIRE UN ENTIER");
        System.out.print("Veuillez rentrer un entier : ");
        int i = Interaction.lireUnEntier();
        System.out.println("entier = " + i);
        System.out.print("Veuillez rentrer un deuxième entier : ");
        int j = Interaction.lireUnEntier();
        System.out.println("entier = " + j);
    }

    public void test2() {
        System.out.println("TEST POUR LIRE UN ENTIER BORNE");
        System.out.print("Veuillez rentrer un entier dans l'intervalle [0, 10[: ");
        int entier = Interaction.lireUnEntier(0, 10);
        System.out.println("entier = " + entier);
        Test.test(entier >= 0 && entier < 10, "test de saisie d'un entier entre [0,10[");
    }

    public void test3() {
        System.out.println("TEST POUR LIRE UNE REPONSE OUI OU NON");
        System.out.print("Veuillez rentrer \"oui\", \"o\", \"non\" ou \"n\" : ");
        boolean reponse = Interaction.lireOuiOuNon();
        Test.test(reponse == true || reponse == false, "test de saisie d'une réponse oui ou non");
    }

    public void test4() {
        System.out.println("TEST POUR LIRE UNE CHAINE DE CARACTERES");
        System.out.print("Veuillez rentrer un mot : ");
        String s = Interaction.lireUneChaine();
        Test.test(s.length() != 0, "test de saisie d'une chaîne de caractères");
    }
}
