package uno;

public class  UnoCard
{
    enum Color
    {
        red, blue, green, yellow, wild;

        private static final Color[] colors = Colors.values();
        public static Color getColor(int i) 
            {
                return Color.colors[i];
            }
    }

    enum Value 
    {
        zero, one, two, three, four, five, six, seven, eight, nine, drawTwo, skip, reverse, wild, wild_four;

        private static final Value[] values = Value.values();
        public static Value getValue(int i)
        {
            return Value.values[i];
        }
    }

    private final Color color;
    private final Value value; 

    public UnoCard(final Color color, final Value value)
    {
        this.color = color;
        this.value = value;
    }

    public Color getColor()
    {
        return this.color;
    }

    public Value getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return color + "_" + value;
    }
}





public class UnoDeck
{
    private UnoCard[] cards;
    private int cardsInDeck;

    public UnoDeck()
        {
            cards = new UnoCard[108];
        }

    public void reset()
    {
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardsInDeck = 0;

        for(int i= 0; i < colors.length -1; i++)
            {
                UnoCard.Color color = colors[i];

                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));

                for(int j=1; j<10; j++)
                {
                    cards[cardsInDeck++] = new UnoCard(color, UnoCard, Value.getValue(j));
                    cards[cardsInDeck++] = new UnoCard(color, UnoCard, Value.getValue(j));
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

    public void replaceDeckWith(ArrayList <UnoCard> cards)
    {
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    public boolean isEmpty()
    {
        return cardsInDeck == 0;
    }

    public void shuffle()
    {
        int n = cards.length;
        Random random = new Random();

        for(int i =0; i < cards.length; i++)
        {
            int randomValue = i + random.nextInt(n-i);
            Uno randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    public int getDeckCount() 
    {
        return cardsInDeck;
    }

    public UnoCard drawCard() throws IllegalArgumentException
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Cannot draw a card, no cards in deck");
        }
        return cards[--cardsInDeck];
    }

   

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

    public void addCard(Card addedCard) 
    {
        cardsInDeck ++;
        UnoCard[cardsInDeck-1] = addedCard; 
        shuffle();
    }

    public void addDeck(UnoDeck addedDeck)
    {
        int newDeckSize = addedDeck.getDeckCount();
        int currentDeckSize = cards.getDeckCOunt();
        int totalDeckSize = newDeckSize + currentDeckSize;

        UnoDeck tempCards = new UnoDeck[totalDeckSize];

        for(int i =0; i < cards.getDeckCount; i++)
        {
            tempCards[i] = cards[i];
        }

        int j = 0; 

        for (int i = currentDeckSize + 1 ; i < addedDeck.getDeckCount; i++)
        {
            tempCards[i] = addedDeck[j];
            j++
        }

        cards = tempCards;
        return cards;
    }




}