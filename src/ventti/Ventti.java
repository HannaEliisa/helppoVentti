/*
  *  Copyright (c) <2018> Pablo Lehto

  *  Permission is hereby granted, free of charge, to any person obtaining a copy
  *  of this software and associated documentation files (the "Software"), to deal
  *  in the Software without restriction, including without limitation the rights
  *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  *  copies of the Software, and to permit persons to whom the Software is
  *  furnished to do so, subject to the following conditions:

  *  The above copyright notice and this permission notice shall be included in all
  *  copies or substantial portions of the Software.

  *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  *  SOFTWARE.
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
        String hostessDeck; //Comp player
        int hostessHand = 0; //Comp player hand
        int hand = 0;
        int hostAmbition = new Random().nextInt(7) + 14;
        System.out.println(hostAmbition);
        List cardDeck = new ArrayList(); // Array list where we place all cards in our current game.

        for (v = 2; v <= 14; v++) { //all fourteen cards. first card is number two.
            for (h = 0; h <= 3; h++) { // Arrays start from 0. so 0 = pata, 1 = Hertta, 2 = Ruutu, 3 = Risti.
                cardDeck.add(continent[h] + " " + v); // this will cast cards with same number "pata 2, hertta 2.." etc.
            }
            h = 0;
        }
        Collections.shuffle(cardDeck); //Will shuffle our array
        System.out.println(ANSI_BLUE + "Tervetuloa pelaamaan tekstiventtiä, painamalla enter saat kortin.");
        input = ask.nextLine();
        while ("".equals(input) == true) { // User input. Enter will deal card as it is empty.
            if (hand > 21) { // To Lose a game
                System.out.println("hävisit.");
                input = "tappio";
                continue;
            }
            ventti = (String) cardDeck.get(i); // We will pull one card from our deck to table with list.get()
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
            System.out.println("Nostatko lisää kortteja? || Paina enter nostaaksesi.");
            input = ask.nextLine(); // user input and loop continues..
            if (hostessHand < hostAmbition) {
                i++;
                hostessDeck = (String) cardDeck.get(i);
                findNum = p.matcher(hostessDeck);
                while (findNum.find()) {
                    hostessHand += Integer.parseInt(findNum.group());
                }
                System.out.println("Emännän käden arvo on nyt: " + hostessHand);
            }

            i++; //counter for next card.
        }
        while (hostessHand < hostAmbition) {
            i++;
            hostessDeck = (String) cardDeck.get(i);
            findNum = p.matcher(hostessDeck);
            while (findNum.find()) {
                hostessHand += Integer.parseInt(findNum.group());
            }
            System.out.println("Emännän käden arvo on nyt: " + hostessHand);
        }
        if (hostessHand > 21 && hand < 21 || hostessHand < hand && hand < 21) {
            System.out.println("Voitit");
        } else if (hostessHand == hand) {
            System.out.println("Tasapeli.");
        } else {
            System.out.println("Emäntä vei pelin.");
        }
    }

}
