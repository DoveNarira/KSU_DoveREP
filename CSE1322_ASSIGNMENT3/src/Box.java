public abstract class Box extends Mail
{
    private double height;
    private int count;

    // Default constructor, calls parents' default constructor and sets height and count to 0
    public Box()
    {
        super();
        height = 0;
        count = 0;
    }

    // Overloaded constructor that has a delivery address, return address, width, length, height, and count in parameters.
    // Calls super constructor with the delivery address, return address, width, and length parameters.
    // Sets height equal to parameter 'h' and count equal to parameter 'c'.
    public Box(String delivAddress, String retAddress, double w, double l, double h, int c)
    {
        super(delivAddress, retAddress, w, l);
        height = h;
        count = c;
    }

    public double getHeight()
    {
        return height;
    }

    public int getCount()
    {
        return count;
    }

    // Overrides toString(), calls parents' toString(), and prints out width, length, and height
    @Override
    public String toString()
    {
        return super.toString() + getWidth() + " x " + getLength() + " x " + height + "\n";
    }
}
