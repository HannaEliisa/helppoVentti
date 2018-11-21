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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int i = 0;
        int v = 2;
        String input; //Käyttäjän syöte.
        //int[] cardDeck = new int[52]; // korttipakka
        List cardDeck = new ArrayList();

        for (i = 1; i <= 52; i++) {
            for (v = 2; v <= 14; v++) {
                cardDeck.add(v);
                v++;
            }
        }
        Collections.shuffle(cardDeck);

        System.out.println("Tervetuloa pelaamaan tekstiventtiä, painamalla enter saat kortin.");
        input = ask.nextLine();
        while ("".equals(input) == true) {
            
            input = ask.nextLine();
            i++;
        }
        int card = 0; // 
        int hand = 0; //
/* 
        Ohjelma ei saa kortteja käteen.
        */



    }

}
