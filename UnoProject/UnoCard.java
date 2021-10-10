/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;


public class UnoCard 
{
    //enumeration for variable Color
    enum Color
    {
        red, blue, green, yellow, wild;

        private static final Color[] colors = Color.values();
        public static Color getColor(int i) 
            {
                return Color.colors[i];
            }
    }

    //enumeration for variable Value
    enum Value 
    {
        zero, one, two, three, four, five, six, seven, eight, nine, drawTwo, skip, reverse, wild, wild_four;

        private static final Value[] values = Value.values();
        public static Value getValue(int i)
        {
            return Value.values[i];
        }
    }

    //global variables 
    private final Color color;
    private final Value value; 

    public UnoCard(final Color color, final Value value)
    {
        this.color = color;
        this.value = value;
    }

    //@returns the color name of card as a string
    public String getColor()
    {
        return this.color.name();
    }

    //@returns the value of card as a string
    public String getValue()
    {
        return this.value.name();
    }

    //@returns a string that combines the color and value of card
    public String toString()
    {
        return color + "_" + value;
    }
  
    
    
    
    
}
