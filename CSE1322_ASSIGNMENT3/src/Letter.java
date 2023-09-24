public class Letter extends Envelope
{
    private String letterBody;

    // Default constructor, calls parents' default constructor and sets letterBody to empty
    public Letter()
    {
        super();
        letterBody = "";
    }


    // Overloaded constructor that has a delivery address, return address, width, length, thickness, and letterBody in parameters.
    // Calls super constructor with the delivery address, return address, width, length, and thickness parameters.
    // Sets letterBody equal to parameter 'letBody'.
    public Letter(String delivAddress, String retAddress, double w, double l, double t, String letBody)
    {
        super(delivAddress, retAddress, w, l , t);
        letterBody = letBody;
    }

    public String getLetterBody()
    {
        return letterBody;
    }
}
