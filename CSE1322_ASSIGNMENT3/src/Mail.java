public abstract class  Mail
{
    private String deliveryAddress;
    private String returnAddress;
    private double width;
    private double length;
    private int id;
    private static int nextId = 0;

    // Default constructor, sets all Strings to empty, all doubles to 0, sets id to nextId, and adds 1 to nextId.
    public Mail()
    {
        deliveryAddress = "";
        returnAddress = "";
        width = 0.0;
        length = 0.0;
        id = nextId;
        nextId++;
    }

    // Overloaded constructor that has a delivery address, return address, width, and length in parameters.
    // Sets private fields equal to parameters, id to nextId, and adds 1 to nextId.
    public Mail(String delivAddress, String retAddress, double w, double l)
    {
        deliveryAddress = delivAddress;
        returnAddress = retAddress;
        width = w;
        length = l;
        id = nextId;
        nextId++;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public String getReturnAddress()
    {
        return returnAddress;
    }

    public double getWidth()
    {
        return width;
    }

    public double getLength()
    {
        return length;
    }

    public int getId()
    {
        return id;
    }

    // Overrides toString and prints out id, deliveryAddress, and returnAddress.
    @Override
    public String toString()
    {
        return id + "\n" + deliveryAddress + "\n" + returnAddress + "\n";
    }
}
