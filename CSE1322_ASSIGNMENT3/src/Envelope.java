public abstract class Envelope extends Mail
{
    private double thickness;

    // Default constructor, sets thickness to 0.
    public Envelope()
    {
        thickness = 0;
    }

    // Overloaded constructor that has a delivery address, return address, width, length, and thickness in parameters.
    // Calls super constructor with the delivery address, return address, width, and length parameters.
    // Sets thickness equal to parameter 't'.
    public Envelope(String delivAddress, String retAddress, double w, double l, double t)
    {
        super(delivAddress, retAddress, w, l);
        thickness = t;
    }

    public double getThickness()
    {
        return thickness;
    }

    // Overrides toString(), calls parents' toString(), and prints out width, length, and thickness
    @Override
    public String toString()
    {
        return super.toString() + getWidth() + " x " + getLength() + " x " + thickness;
    }
}
