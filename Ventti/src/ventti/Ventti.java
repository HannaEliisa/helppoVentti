/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.util.*;

/**
 *
 * @author s1801503
 */
public class Ventti {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * @param args the command line arguments
     *
     */

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int i = 0;
        int v = 2;
        int h = 4;
        String[] maa = new String[]{"U+2660Pata", "Hertta", "Ruutu", "Risti"};
        String ventti;
        String input; //Käyttäjän syöte.
        //int[] cardDeck = new int[52]; // korttipakka
        List cardDeck = new ArrayList();

        for (i = 1; i <= 13; i++) {
            for (v = 2; v <= 14; v++) {
                for (h = 0; h <= 3; h++) {
                    cardDeck.add(maa[h] + " " + v);
                }
                v++;
                h = 1;
            }
        }
        Collections.shuffle(cardDeck);
        int hand = 0;
        System.out.println(ANSI_BLUE + "Tervetuloa pelaamaan tekstiventtiä, painamalla enter saat kortin.");
        input = ask.nextLine();
        while ("".equals(input) == true) {
            ventti = (String) cardDeck.get(i);
            if (ventti.contains("Hertta") || ventti.contains("Ruutu")) {
                System.out.println(ANSI_RED + ventti);
            } else {
                System.out.println(ventti);
            }
            input = ask.nextLine();
            i++;
        }
        int card = 0; // 
        //
/* 
        Ohjelma ei saa kortteja käteen.
         */

    }

}
