package it.epicode.Esercizio3;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti=0;}


public void preleva (double x) throws BancaException  {

    if (nMovimenti < maxMovimenti) {
        saldo = saldo - x;
    } else {
        saldo = saldo - x - 0.50;
    }
    nMovimenti++;
    if (saldo < 0) {


        throw new BancaException("Il conto è in rosso");
    }
}


    public double restituisciSaldo () {
        return saldo;
    }
}