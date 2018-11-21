/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.*;
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
        Pattern p = Pattern.compile("\\d+"); //regular expression. d means digit, + means one or more, ie all numbers.
        Matcher findNum;

        Scanner ask = new Scanner(System.in);
        int i = 0; // variables i, h and v are used in loops
        int v = 2;
        int h = 4;
        String[] continent = new String[]{"Pata", "Hertta", "Ruutu", "Risti"}; //Continents in array lang FI-fi
        String ventti;
        String input; //User input
        List cardDeck = new ArrayList(); // Array list where we place all cards in our current game.

        for (v = 2; v <= 14; v++) { //all fourteen cards. first card is number two.
            for (h = 0; h <= 3; h++) { // Arrays start from 0. so 0 = pata, 1 = Hertta, 2 = Ruutu, 3 = Risti.
                cardDeck.add(continent[h] + " " + v); // this will cast cards with same number "pata 2, hertta 2.." etc.
            }
            h = 0;
        }
        Collections.shuffle(cardDeck); //Will shuffle our array
        int hand = 0;
        System.out.println(ANSI_BLUE + "Tervetuloa pelaamaan tekstiventtiä, painamalla enter saat kortin.");
        input = ask.nextLine();
        while ("".equals(input) == true) { // User input. Enter will deal card as it is empty.
            if (hand>21){ // To Lose a game
                System.out.println("hävisit.");
                input ="tappio";
                continue;
            }
            ventti = (String) cardDeck.get(i); // We will pull one card from our dect to table with list.get()
            findNum = p.matcher(ventti); // we use this to parse numeralls to diffent variable called hand later.
            while (findNum.find()) {
                hand += Integer.parseInt(findNum.group());
                System.out.println("Kätesi arvo on nyt: " + hand);
            }
            if (ventti.contains("Hertta") || ventti.contains("Ruutu")) { // this 'if' for us to get right color for some cards.
                System.out.println(ANSI_RED + ventti);
            } else {
                System.out.println(ventti); // black card
            }
            input = ask.nextLine(); // user input and loop continues..
            i++; //counter for next card.
        }
        int card = 0; // 
        //
/* 
        Emäntä puuttuu...
         */

    }

}
