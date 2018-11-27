/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

/**
 *
 * @author s1801503
 */
public class Kortti {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String SPADES_MARK = "\u2660";
    public static final String DIAMONDS_MARK = "\u2666";
    public static final String HEARTS_MARK = "\u2665";
    public static final String CLUBS_MARK = "\u2663";
    
    private String value;
    private String cardStyle;
    public Kortti (String value){
        this.value = value;
        if(value.contains("Pata")){
            cardStyle = " _____\n|" + SPADES_MARK + "    |\n|" + value + "\n|___" + 
                SPADES_MARK + "_|";
        } else if(value.contains("Ruutu")){
            cardStyle = " _____\n|" + DIAMONDS_MARK + "    |\n|"+ ANSI_RED + value + "\n|___" + 
                DIAMONDS_MARK + "_|";
        } else if(value.contains("Hertta")){
            cardStyle = " _____\n|" + HEARTS_MARK + "    |\n|"+ ANSI_RED + value + "\n|___" + 
                HEARTS_MARK + "_|";
        } else if(value.contains("Risti")){
            cardStyle = " _____\n|" + CLUBS_MARK + "    |\n|"+  value + "\n|___" + 
                CLUBS_MARK + "_|";
        }
    }
    public String toString() {
        return cardStyle;
    }
}
