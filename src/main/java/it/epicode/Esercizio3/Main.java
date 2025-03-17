package it.epicode.Esercizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ContoCorrente conto1 = new ContoCorrente("Giovanni", 2000.0);
        ContoOnline conto2 = new ContoOnline("Giovanni", 2000.0, 1500.0);

        Scanner scanner = new Scanner(System.in);
        logger.debug("Stato Iniziale");
        logger.info("Conto {}: Numero movimenti: {} Saldo: {}",
                "conto1", conto1.getNMovimenti(), conto1.getSaldo());
        while (true) {
            logger.info("Inserisci importo da prelevare o premi 0 per uscire");
            double importo = scanner.nextDouble();
            if (importo == 0) {
                break;
            }


            try {

                conto1.preleva(importo);
                logger.debug("Stato dopo il prelievo");
                logger.info("Conto {}: Numero movimenti: {} Saldo: {}",
                        "conto1", conto1.getNMovimenti(), conto1.getSaldo());
            } catch (BancaException e) {
                logger.error("{} di {}, numero movimenti: {}", e.getMessage(), conto1.getSaldo(), conto1.getNMovimenti());
            }

        }
        logger.debug("Conto Corrente terminato. Ora puoi iniziare a prelevare dal Conto Online.");
        logger.debug("Stato Iniziale");
        logger.info("Conto {}: Numero movimenti: {} Saldo: {}",
                "conto2", conto2.getNMovimenti(), conto2.getSaldo());
        while (true) {
            logger.info("Inserisci importo da prelevare o premi 0 per uscire");
            double importo = scanner.nextDouble();
            if (importo == 0) {
                break;
            }
            try {
                conto2.preleva(importo);
                logger.debug("Stato dopo il prelievo");
                logger.info("Conto {}: Numero movimenti: {} Saldo: {}",
                        "conto2", conto2.getNMovimenti(), conto2.getSaldo());
            } catch (BancaException e) {
                logger.error(e.getMessage());


            }
        }
    }

}


