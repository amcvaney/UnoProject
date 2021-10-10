/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author alons
 */
public class UNOWorkout 
 
{//a
    
    private UnoDeck deck = null;
    private UnoCard[] playersHand  = new UnoCard[7];
    int playersHandSize=0;
    private String[] game = new String[1000];
    private int pushups;
    private int totalPushups;
    private int totalSkippedPushups;
    private int squats;
    private int totalSquats;
    private int totalSkippedSquats;
    private int situps;
    private int totalSitups;
    private int totalSkippedSitups;
    private int lounges;
    private int totalLounges;
    private int totalSkippedLounges;
    private int burpees;
    private int totalBurpees;
    
    //no argument constructor
    public void UNOWorkout()
    {
        
    }
    
    
    //constructor creates an instance of the game
    //@param with int and boolean
    UNOWorkout(int numberOfDecks,boolean together)
    {           UnoDeck secondDeck = null;
                UnoDeck thirdDeck = null;
                
                
        switch(numberOfDecks)
        {

            case 1:
                deck = new UnoDeck();
                deck.reset();
                deck.shuffle();
                break;
            case 2:
                    deck = new UnoDeck();
                    deck.reset();
                    secondDeck = new UnoDeck();
                    secondDeck.reset();
                if(together == true)
                {
                    deck.addDeck(secondDeck);
                    deck.shuffle();
                    
                    
                }
                else
                {
                    deck.shuffle();
                    secondDeck.shuffle();
                    
                    deck.addDeck(secondDeck);
                    
                }
                break;
            case 3:
                
                deck = new UnoDeck();
                deck.reset();
                secondDeck = new UnoDeck();
                secondDeck.reset();
                thirdDeck = new UnoDeck();
                thirdDeck.reset();
               
                if(together == true)
                {
                    deck.addDeck(secondDeck);
                    deck.addDeck(thirdDeck);
                    deck.shuffle();
                    
                    
                }
                else
                {
                    deck.shuffle();
                    secondDeck.shuffle();
                    thirdDeck.shuffle();
                    
                    deck.addDeck(secondDeck);
                    deck.addDeck(thirdDeck);
                    
                }
                break;
            default:
            
        }
          
    }
    
    //method that removes Action cards from the deck
    public void removeAllActions()
    {
        deck.removeCards("skip");
        deck.removeCards("drawTwo");
        deck.removeCards("reverse");
        deck.removeCards("wild");
        deck.removeCards("wild_four");
    }
    
    //method that draws 7 cards for the user to use
    public void drawSevenCards()
    {
        if(deck.getDeckCount() != 0)
        {
            playersHandSize=0;
            int i=0;
            while(i <7)
            {
                if(deck.isEmpty() == false)
                {
                    playersHand[i]= deck.drawCard();
                    playersHandSize++;
                }
                else
                {
                    playersHand[i] = null;
                }
                i++;
            }
            
            
        }
        else
        {
            
            playersHand = null;
            
        }
        
        
    }
    
    //method that sorts cards by their color in user's hand 
    public void sortCardsColor()
    {
        
        UnoCard[] tempHand = new UnoCard[7];
        int position =0;
        
        for(int i = 0;i<playersHandSize;i++)
        {
            String color =playersHand[i].getColor();
            if(color.compareTo("blue") == 0)
            {
                tempHand[position]=playersHand[i];
                position++;
            }
        }
        
        
         for(int i = 0;i<playersHandSize;i++)
        {
            String color =playersHand[i].getColor();
            if(color.compareTo("red") == 0)
            {
                tempHand[position]=playersHand[i];
                position++;
            }
        }
     
         for(int i = 0;i<playersHandSize;i++)
        {
            String color =playersHand[i].getColor();
            if(color.compareTo("yellow") == 0)
            {
                tempHand[position]=playersHand[i];
                position++;
            }
        }
        
         for(int i = 0;i<playersHandSize;i++)
        {
            String color =playersHand[i].getColor();
            if(color.compareTo("green") == 0)
            {
                tempHand[position]=playersHand[i];
                position++;
            }
        }
         
         for(int i = 0;i<playersHandSize;i++)
        {
            String color =playersHand[i].getColor();
            if(color.compareTo("wild") == 0)
            {
                tempHand[position]=playersHand[i];
                position++;
            }
        } 
        
         
         playersHand = tempHand;
       
    }
    
    //method that sorts cards by their value in user's hand 
    public void sortCardsValue()
    {
        
        UnoCard tempCard = null;

        
        boolean sort= false;
        while(sort == false){
        sort = true;
        for(int i = 0;i<playersHandSize-1;i++)
        {
            String value = playersHand[i].getValue();
            int cardValue=0;
            switch(value)
            {
                case "zero": cardValue= 0;
                    break;
                case "one": cardValue= 1;
                    break;
                case "two": cardValue= 2;
                    break;
                case "three":   cardValue= 3;
                    break;
                case "four":    cardValue= 4;
                    break;
                case "five":    cardValue= 5;
                    break;
                case "six": cardValue= 6;
                    break;
                case "seven":   cardValue= 7;
                    break;
                case "eight":   cardValue= 8;
                    break;
                case "nine":    cardValue= 9;
                    break;
                case "drawTwo": cardValue= 10;
                    break;
                case "skip":    cardValue=11;
                    break;
                case "reverse": cardValue= 12;
                    break;
                case "wild":    cardValue= 13;
                    break;
                case "wild_four":   cardValue= 14;
                    break;
                default:
                    
                
            }      
   
            String secondValue = playersHand[i+1].getValue();
            
            int secondCardValue=0;
            switch(secondValue)
            {
                case "zero": secondCardValue= 0;
                    break;
                case "one": secondCardValue= 1;
                    break;
                case "two": secondCardValue= 2;
                    break;
                case "three":   secondCardValue= 3;
                    break;
                case "four":    secondCardValue= 4;
                    break;
                case "five":    secondCardValue= 5;
                    break;
                case "six": secondCardValue= 6;
                    break;
                case "seven":   secondCardValue= 7;
                    break;
                case "eight":   secondCardValue= 8;
                    break;
                case "nine":    secondCardValue= 9;
                    break;
                case "drawTwo": secondCardValue= 10;
                    break;
                case "skip":    secondCardValue=11;
                    break;
                case "reverse": secondCardValue= 12;
                    break;
                case "wild":    secondCardValue= 13;
                    break;
                case "wild_four":   secondCardValue= 14;
                    break;
                default:   
            }
            
          if(cardValue>secondCardValue)
          {
              tempCard = playersHand[i+1];
              playersHand[i+1]=playersHand[i];
              playersHand[i]=tempCard;
              sort = false; 
          }
    }
        }
}
    
    //method that calculates totals
    public void calculate()
     {      pushups=0;
            situps=0;
            squats=0;
            lounges=0;
            burpees=0;
            
    
        for(int i=0;i<playersHandSize;i++)
        {
            String value = playersHand[i].getValue();
            String color = playersHand[i].getColor();
            int cardValue=0;
            switch(value)
            {
                case "zero": cardValue= 0;
                    break;
                case "one": cardValue= 1;
                    break;
                case "two": cardValue= 2;
                    break;
                case "three":   cardValue= 3;
                    break;
                case "four":    cardValue= 4;
                    break;
                case "five":    cardValue= 5;
                    break;
                case "six": cardValue= 6;
                    break;
                case "seven":   cardValue= 7;
                    break;
                case "eight":   cardValue= 8;
                    break;
                case "nine":    cardValue= 9;
                    break;
                case "drawTwo": cardValue= 10;
                    break;
                case "skip":    cardValue=11;
                    break;
                case "reverse": cardValue= 12;
                    break;
                case "wild":    cardValue= 13;
                    break;
                case "wild_four":   cardValue= 14;
                    break;
                default:
                    
                
            }
            
            switch(color)
            {
                case "blue":
                    if(cardValue !=0 && cardValue!=10 && cardValue!=11 && cardValue!= 12)
                    {
                    pushups =pushups+cardValue;
                            
                    }
                    
                    break;
                case "red":
                    if(cardValue !=0 && cardValue!=10 && cardValue!=11 && cardValue!= 12)
                    {
                    situps =situps+cardValue;
                            
                    }
                    
                    
                    break;
                case "yellow":
                    if(cardValue !=0 && cardValue!=10 && cardValue!=11 && cardValue!= 12)
                    {
                    squats =squats+cardValue;
                            
                    }
                    
                    break;
                case "green":
                    if(cardValue !=0 && cardValue!=10 && cardValue!=11 && cardValue!= 12)
                    {
                    lounges =lounges+cardValue;
                            
                    }
                    
                    break;
                case "wild": 
                    if(cardValue==13 || cardValue== 14)
                    {
                    burpees=burpees+4;
                            
                    }
                  
                    break;
                default:
                
            }
               
        }
       
        
        totalBurpees=+burpees;
        
        
        
        
        
    }
    
    //method that print cards in hand
    //@returns a string
    public String printHand()
    {
        
        String cardOne="NONE";
        String cardTwo="NONE";
        String cardThree="NONE";
        String cardFour="NONE";
        String cardFive="NONE";
        String cardSix="NONE";
        String cardSeven="NONE";
        
        
       switch(playersHandSize)
       {
           case 1:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        break;
        case 2:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        break;
        case 3:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        cardThree = playersHand[2].getColor().toUpperCase()+":"+playersHand[2].getValue().toUpperCase();
        break;
        case 4:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        cardThree = playersHand[2].getColor().toUpperCase()+":"+playersHand[2].getValue().toUpperCase();
        cardFour = playersHand[3].getColor().toUpperCase()+":"+playersHand[3].getValue().toUpperCase();
        break;
        case 5:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        cardThree = playersHand[2].getColor().toUpperCase()+":"+playersHand[2].getValue().toUpperCase();
        cardFour = playersHand[3].getColor().toUpperCase()+":"+playersHand[3].getValue().toUpperCase();
        cardFive = playersHand[4].getColor().toUpperCase()+":"+playersHand[4].getValue().toUpperCase();
        break;
        case 6:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        cardThree = playersHand[2].getColor().toUpperCase()+":"+playersHand[2].getValue().toUpperCase();
        cardFour = playersHand[3].getColor().toUpperCase()+":"+playersHand[3].getValue().toUpperCase();
        cardFive = playersHand[4].getColor().toUpperCase()+":"+playersHand[4].getValue().toUpperCase();
        cardSix = playersHand[5].getColor().toUpperCase()+":"+playersHand[5].getValue().toUpperCase();
        break;
        case 7:
        cardOne = playersHand[0].getColor().toUpperCase()+":"+playersHand[0].getValue().toUpperCase();
        cardTwo = playersHand[1].getColor().toUpperCase()+":"+playersHand[1].getValue().toUpperCase();
        cardThree = playersHand[2].getColor().toUpperCase()+":"+playersHand[2].getValue().toUpperCase();
        cardFour = playersHand[3].getColor().toUpperCase()+":"+playersHand[3].getValue().toUpperCase();
        cardFive = playersHand[4].getColor().toUpperCase()+":"+playersHand[4].getValue().toUpperCase();
        cardSix = playersHand[5].getColor().toUpperCase()+":"+playersHand[5].getValue().toUpperCase();
        cardSeven = playersHand[6].getColor().toUpperCase()+":"+playersHand[6].getValue().toUpperCase();
        default:
    }
        
        
        
        
        String all ="Cards in hand:"+cardOne+"   "+cardTwo+"   "+cardThree+"   "+cardFour+"   "+cardFive+"   "+cardSix+"   "+cardSeven;
        return all;
        
        
        
        
    }
    
    //method that prints the effects of the cards in hand
    //@returns a string
    public String printEffects()
    {       String effectList="Effects: ";
            for(int i =0 ;i<playersHandSize;i++)
            {
                String cardValue = playersHand[i].getValue();
                String cardColor;
                
                if(cardValue == "zero" || cardValue == "skip" || cardValue == "drawTwo" || cardValue == "reverse" || cardValue == "wild" || cardValue == "wild_four")
                {
                    switch(cardValue)
                    {
                        
                        case "reverse":
                        
                        
                                    cardColor = playersHand[i].getColor();
                                switch(cardColor)
                                {
                                    case "blue":    for(int j=0;j<playersHandSize;j++)
                                    {
                                        try
                                        {
                                        String checkColor= playersHand[j].getColor();
                                        String checkValue= playersHand[j].getValue();
                                        if(checkColor == "blue" && checkValue != "reverse")
                                        {
                                            
                                            UnoCard tempCard;
                                            tempCard=playersHand[j];
                                            deck.addCard(tempCard);
                                            playersHand[j]=null;
                                            totalPushups=-pushups;
                                            pushups=0;
                                            
                                            
                                            
                                        }
                                    }
                                    catch(NullPointerException e)
                                    {
                                        //No card exsit, its a null
                                    }
                                        
                                        
                                    }
                                                    
                                        break;
                                    case "red":    for(int j=0;j<playersHandSize;j++)
                                    {
                                        
                                        try
                                        {
                                        String checkColor= playersHand[j].getColor();
                                        String checkValue= playersHand[j].getValue();
                                        if(checkColor == "red" && checkValue != "reverse")
                                        {
                                            
                                            UnoCard tempCard;
                                            tempCard=playersHand[j];
                                            deck.addCard(tempCard);
                                            playersHand[j]=null;
                                            totalSitups=-situps;
                                            situps=0;
                                            
                                            
                                            
                                        }
                                         }
                                    catch(NullPointerException e)
                                    {
                                        //No card exsit, its a null
                                    }
                                        
                                    }
                                                    
                                        break;
                                    case "yellow":  for(int j=0;j<playersHandSize;j++)
                                    {
                                        
                                        try
                                        {
                                        String checkColor= playersHand[j].getColor();
                                        String checkValue= playersHand[j].getValue();
                                        if(checkColor == "yellow" && checkValue != "reverse")
                                        {
                                            
                                            UnoCard tempCard;
                                            tempCard=playersHand[j];
                                            deck.addCard(tempCard);
                                            playersHand[j]=null;
                                            totalSquats=-squats;
                                            squats=0;
                                            
                                            
                                            
                                        }
                                         }
                                    catch(NullPointerException e)
                                    {
                                        //No card exsit, its a null
                                    }
                                        
                                    }
                                                    
                                        break;
                                    case "green":  for(int j=0;j<playersHandSize;j++)
                                    {
                                        
                                        try
                                        {
                                        String checkColor= playersHand[j].getColor();
                                        String checkValue= playersHand[j].getValue();
                                        if(checkColor == "green" && checkValue != "reverse")
                                        {
                                            
                                            UnoCard tempCard;
                                            tempCard=playersHand[j];
                                            deck.addCard(tempCard);
                                            playersHand[j]=null;
                                            totalLounges=-lounges;
                                            lounges=0;
                                            
                                            
                                            
                                        }
                                         }
                                    catch(NullPointerException e)
                                    {
                                        //No card exsit, its a null
                                    }
                                    }
                                        break;
                                    
                                    
                                    
                                }
                        case "skip":
                                cardColor = playersHand[i].getColor();
                                switch(cardColor)
                                {
                                    case "blue":    effectList=effectList+"Skip pushups   ";
                                                    totalPushups= totalPushups-pushups;
                                                    totalSkippedPushups= totalSkippedPushups+pushups;
                                                    
                                        break;
                                    case "red":     effectList=effectList+"Skip situps   ";
                                                    totalSkippedSitups= totalSkippedSitups+situps;
                                                    totalSitups=totalSitups-situps;
                                        break;
                                    case "yellow":  effectList=effectList+"Skip squats   ";
                                                    totalSkippedSquats = totalSkippedSquats+squats;
                                                    totalSquats=totalSquats-squats;
                                        break;
                                    case "green":   effectList=effectList+"Skip lounges   ";
                                                    totalSkippedLounges= totalSkippedLounges+lounges;
                                                    totalLounges=totalLounges-lounges;
                                        break;
                                    
                                    
                                    
                                }
                        
                        
                        
                            break;
                        case "drawTwo":
                        
                                cardColor = playersHand[i].getColor();
                                switch(cardColor)
                                {
                                    case "blue":    totalPushups=+pushups;
                                                    pushups=+pushups;
                                                    effectList=effectList+"DrawTwo multiply by two pushups   ";
                                                    
                                        break;
                                    case "red":    totalSitups=+situps;
                                                    situps=+situps;
                                                    effectList=effectList+"DrawTwo multiply by two situps   ";
                                                    
                                        break;
                                    case "yellow":  totalSquats=+squats;
                                                    squats=+squats;
                                                    effectList=effectList+"DrawTwo multiply by two squats   ";
                                                    
                                        break;
                                    case "green":  totalLounges=+lounges;
                                                    lounges=+lounges;
                                                    effectList=effectList+"DrawTwo multiply by two lounges   ";
                                        break;
                                    
                                    
                                    
                                }
                        
                        
                        
                        
                        
                            break;
                        
                        case "wild":
                        effectList=effectList+"Wild card four burpees ";
                        
                            break;
                        case "wild_four":
                        effectList=effectList+"Wild card four burpees and multiply all excercises by four ";
                        totalPushups=-pushups;
                        pushups=pushups*4;
                        totalPushups=+pushups;
                        
                        totalSitups=-situps;
                        situps=situps*4;
                        totalSitups=+situps;
                        
                        totalSquats=-squats;
                        squats=squats*4;
                        totalSquats=+squats;
                        
                        totalLounges=-lounges;
                        lounges=-lounges;
                        totalLounges=+lounges;
                        
                        
                        
                        
                        
                            break;
                            
                        case "zero":
                                cardColor = playersHand[i].getColor();
                                switch(cardColor)
                                {
                                    case "blue":    
                                                    effectList=effectList+"Two minuterest after pushups   ";
                                                    
                                        break;
                                    case "red":    totalSitups=+situps;
                                                    situps=+situps;
                                                    effectList=effectList+"Two minuterest after situps   ";
                                                    
                                        break;
                                    case "yellow":  totalSquats=+squats;
                                                    squats=+squats;
                                                    effectList=effectList+"Two minuterest after squats   ";
                                                    
                                        break;
                                    case "green":  totalLounges=+lounges;
                                                    lounges=+lounges;
                                                    effectList=effectList+"Two minuterest after lounges   ";
                                        break;
                                    
                                    
                                    
                                }
                        
                        
                            break;
                        default:
                        
                        
                        
                    }
                    
                    
                    
                }
                
                
            }
            
        
        
        
        
        
        
        
        return effectList;
    }
    public String printExercises()
    {
        
     String exerciseList = "Pushups:"+pushups+"   Situps:"+situps+"   Squats:"+squats+"   Lounges:"+lounges+"   Burpees:"+burpees;
     
     
     
     
     
        
     return exerciseList;   
    }
    
    
    //method that plays and print game round into an array
    public void playGameRound()
    {
        int i=-1;
        boolean isDeckEmpty=false;
        do
        {
        drawSevenCards();
        sortCardsValue();
        sortCardsColor();
        calculate();   
        //game[i+1]=();
        System.out.print(printHand()+"\n");
        //game[i+1]=();
        System.out.print(printEffects()+"\n");
        
        //game[i+1]=();
        System.out.print(printExercises()+"\n");
        //game[i+1]=();
        System.out.print(deck.getDeckCount()+"\n");
        ///game[i+1]=();
        System.out.print("\n\n\n");
        if(deck.isEmpty() == true)
        {
         isDeckEmpty=true;   
        }
    
    
    }while(isDeckEmpty == false);
        
    }
}
    
   
    