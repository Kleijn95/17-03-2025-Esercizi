package it.epicode.Esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main (String[] args) {
        Scanner scanner =  new Scanner(System.in);
        try {
            System.out.println("Inserisci i km percorsi.");
            int km = scanner.nextInt();
            System.out.println("Inserisci i litri di carburante consumati.");
            int litri = scanner.nextInt();
            if (litri == 0) {
                logger.error("Errore: Non puoi inserire 0 litri");
                return;
            }
            double consumo = km / litri;
            System.out.println("Il tuo mezzo consuma " + km / litri + " litri per km.");
        } catch (Exception e) {
            logger.error("Errore: inserisci un numero valido.");

        }
    }
}
