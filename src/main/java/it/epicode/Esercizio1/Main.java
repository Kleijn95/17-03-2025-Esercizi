package it.epicode.Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static int[] creaArray() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }
        return array;
    }

    public static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = creaArray();
        stampaArray(array);

        while(true) {
            System.out.println("Inserisci la posizione dell'array che vuoi modificae tra 1 e 5, 0 per uscire");
            int posizione;
            try {
                posizione = scanner.nextInt();
                if (posizione == 0) break;
                if (posizione < 1 || posizione > 5) {
                    logger.error("Posizione non valida, deve essere tra 1 e 5.");
                    scanner.nextLine();
                    continue;
                }
            } catch (Exception e) {
                logger.error("Errore: inserisci un numero valido per la posizione da 1 a 5.");
                scanner.nextLine();
                continue;
            }

                System.out.println("Inserisci il numero che vuoi inserire tra 1 e 10");
            try {
                int numero = scanner.nextInt();
                if (numero > 10) {
                    logger.error("Il numero inserito deve essere da 1 a 10");
                    scanner.nextLine();
                    continue;
                }
                array[posizione -1] = numero;
                stampaArray(array);
            } catch (Exception e) {
                logger.error("Errore nell'inserimento del numero.");
                scanner.nextLine();

            }
        }
    }

}
