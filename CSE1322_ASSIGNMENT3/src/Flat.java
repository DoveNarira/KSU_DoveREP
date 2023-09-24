public class Flat extends Envelope
{
    private String contents;

    // Default constructor, calls parents' constructor and sets contents to empty
    public Flat()
    {
        super();
        contents = "";
    }

    // Overloaded constructor that has a delivery address, return address, width, length, thickness, and contents in parameters.
    // Calls super constructor with the delivery address, return address, width, length, and thickness parameters.
    // Sets contents equal to parameter 'cont'.
    public Flat(String delivAddress, String retAddress, double w, double l, double t, String cont)
    {
        super(delivAddress, retAddress, w, l, t);
        contents = cont;
    }

    public String getContents()
    {
        return contents;
    }
}
