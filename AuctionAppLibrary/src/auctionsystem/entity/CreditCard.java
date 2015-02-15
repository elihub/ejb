/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.entity;

import java.io.Serializable;

/**
 *
 * @author Humberto
 */
public class CreditCard implements Serializable{
    private final char[] cardNumber;
    private final short expiresMonth;
    private final short expiresYear;
    private final char[] csv;
    private final String holderName;

    public CreditCard(char[] cardNumber, short expiresMonth, short expiresYear, char[] csv, String holderName) {
        this.cardNumber = cardNumber;
        this.expiresMonth = expiresMonth;
        this.expiresYear = expiresYear;
        this.csv = csv;
        this.holderName = holderName;
    }  

    public char[] getCardNumber() {
        return cardNumber;
    }

    public short getExpiresMonth() {
        return expiresMonth;
    }

    public short getExpiresYear() {
        return expiresYear;
    }

    public char[] getCsv() {
        return csv;
    }

    public String getHolderName() {
        return holderName;
    }   
}
