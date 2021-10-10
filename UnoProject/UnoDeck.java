/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;
import java.util.*;

/**
 *
 * @author alons
 */
public class UnoDeck 
{
    
    private UnoCard[] cards;
    private int cardsInDeck;

    //constructor that creates an array of 108 cards in the uno deck
    public UnoDeck()
        {
            cards = new UnoCard[108];
        }

    //method that establishes colors and cards
    public void reset()
    {
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardsInDeck = 0;

        for(int i= 0; i < colors.length-1; i++)
            {
                UnoCard.Color color = colors[i];

                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));

                for(int j=1; j<10; j++)
                {
                    cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
                    cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
                }

                UnoCard.Value[] values = new UnoCard.Value[] { UnoCard.Value.drawTwo, UnoCard.Value.skip, UnoCard.Value.reverse };
                for (UnoCard.Value value : values)
                {
                    cards[cardsInDeck++] = new UnoCard(color, value);
                    cards[cardsInDeck++] = new UnoCard(color, value);
                }  
            }

            UnoCard.Value[] values = new UnoCard.Value[] { UnoCard.Value.wild, UnoCard.Value.wild_four };
            for (UnoCard.Value value : values)
            {
                for(int i =0; i < 4; i++)
                {
                    cards[cardsInDeck++] = new UnoCard(UnoCard.Color.wild, value);
                }
            }
    }

    //method that checks if the cardsInDeck variable is empty.
    //@returns true if cardsInDeck equals zero.
    public boolean isEmpty()
    {
        return cardsInDeck == 0;
    }

    //method that shuffles cards.
    public void shuffle()
    {
        int n = cards.length;
        Random random = new Random();

        for(int i =0; i < cards.length; i++)
        {
            int randomValue = i + random.nextInt(n-i);
            UnoCard randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    //method that returns an int value
    //@returns the amount of cards in the deck.
    public int getDeckCount() 
    {
        return cardsInDeck;
    }
    
    //method that 
    //@returns true if removing cards 
    public boolean removeCards(String cardValue)
    {   boolean cardfound = false;
        do
        {
            
            int i=0;
            
            while(i<cardsInDeck)
            {
                String value = cards[i].getValue();
                int compareValue = value.compareTo(cardValue); // assign zero if equal
                if(compareValue == 0)
                {
                    break;
                }
                else
                {
                    i++;
                }
                
            }
            if(i == cardsInDeck) // went through the whole deck
            {
                cardfound = true;
            }

            if(cardfound != true)
            {
            UnoCard tempCard;
            tempCard = cards[i];
            cards[i] = cards[cardsInDeck-1 ];
            cards[cardsInDeck-1]=tempCard;
            cardsInDeck = cardsInDeck-1;
            
            cardfound= false; // haven't found all of the cards yet
            }  
        }while(cardfound==false);

    return cardfound;
    }
    
    //method that draws a card from the deck
    //@returns the UnoCard drawn from deck
    public UnoCard drawCard() throws IllegalArgumentException
    {
        if(isEmpty())
        {
            return null;
            //throw new IllegalArgumentException("Cannot draw a card, no cards in deck");
        }
        return cards[--cardsInDeck];
    }

   
    //method that draws a card from the deck
    //@returns an UnoCard
    /*
    public UnoCard[] drawCard(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Must draw positive cards but tried to draw " + n + "cards");
        }

        if(n > cardsInDeck)
        {
            throw new IllegalArgumentException("Cannot draw " + n + "cards since there are only " + cardsInDeck + " cards");
        }

        UnoCard[] ret = new UnoCard[n];
        for(int i = 0; i < n; i++)
        {
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }
    */


    //method that adds a card back into deck
    //@param UnoCard
    public void addCard(UnoCard addedCard) 
    {
        cardsInDeck ++;
        cards[cardsInDeck-1] = addedCard; 
        
    }

    //method that adds a Deck and doesnt return anything
    public void addDeck(UnoDeck addedDeck)
    {
        int newDeckSize = addedDeck.getDeckCount();
        int currentDeckSize = cards.length;
        int totalDeckSize = newDeckSize + currentDeckSize;

        UnoCard[] tempCards = new UnoCard[totalDeckSize];

        for(int i =0; i < cards.length; i++)
        {
            tempCards[i] = cards[i];
        }

        for (int i = cards.length ; i < tempCards.length; i++)
        {
            UnoCard tempCard = addedDeck.drawCard();
            tempCards[i] = tempCard;
            
        }
        cards = tempCards;
        cardsInDeck= cards.length;
    }

}