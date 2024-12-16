/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// author Eddie Devine

//package
package com.mycompany.unit4test;

//imports
import java.util.Random;
import java.util.Arrays;

public class Unit4Test {

    public static void main(String[] args) {
        Card cards[] = {}; // my pulled cards
        
        for(int i = 0; i < 5;){ // pull 5 cards
            Card myCard = new Card(); // pulled card
            
            boolean cardInDeck = false; // is the card in the deck already?
            for(int j = 0; j < cards.length; j++){ // go through the deck to get if the card is in the deck
                String suit = cards[j].getSuit(); // suit of card in deck
                int face = cards[j].getFace(); // face of card in deck
                
                if((suit.equals(myCard.getSuit())) && (face == myCard.getFace())){ // pulled card is not the same as card in deck
                    cardInDeck = true;
                }
            }
            
            if(!cardInDeck){
                Card[] newCards = Arrays.copyOf(cards, cards.length + 1);
                newCards[cards.length] = myCard;
                cards = newCards;
                i++;
                System.out.println(myCard.print());
            }
        }
       
        Card highestCard = cards[0];
        for(int i = 1; i < cards.length; i++){
            int face = cards[i].getFace();
            if(face > highestCard.getFace()){
                highestCard = cards[i];
            }
        }
        
        System.out.println("Highest Card is: " + highestCard.print());
    }
}

class Card {
    private String suit; //instance for suit
    private int face; //instance for face
    
    //possible suits for card
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    
    //card constructor
    public Card(){
        Random randomNumber = new Random(); // random number generater to randomly generate cards
        int suitIndex = randomNumber.nextInt(4); // generate index within range of suits array to select random suit
        this.suit = SUITS[suitIndex]; // set suit based on index
        
        int faceNumber = randomNumber.nextInt(13)+1; // generate random number for face (1-13)
        this.face = faceNumber; // set face to randomly generated number
    }
    
    // generate string with card information
    public String print(){
        String toPrint = "Suit: " + suit + ", Face: " + face;
        return toPrint;
    }
    
    public String getSuit(){ return suit; } // getter for suit
    
    public int getFace(){ return face; } // getter for face
    
}
