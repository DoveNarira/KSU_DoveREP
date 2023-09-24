public class RegularBox extends Box
{
    private String items;
    private double weight;

    // Default constructor, calls parents' default constructor and sets weight to 0 and items to empty
    public RegularBox()
    {
        super();
        weight = 0;
        items = "";
    }

    // Overloaded constructor that has a delivery address, return address, width, length, height, count, items, and weight in parameters.
    // Calls super constructor with the delivery address, return address, width, length, height, and count parameters.
    // Sets items equal to parameter 'item' and weight equal to 'wei'.
    public RegularBox(String delivAddress, String retAddress, double wid, double l, double h, int c, double wei, String item)
    {
        super(delivAddress, retAddress, wid, l, h, c);
        items = item;
        weight = wei;
    }

    public String getItems()
    {
        return items;
    }

    public double getWeight()
    {
        return weight;
    }

    // Overrides toString(), calls parents' toString() and adds a printout of the items, count, and weight.
    @Override
    public String toString()
    {
        String ret = "Items: " + items + "\n" + "Count: " + getCount() + "\n" + "Weight: " + weight;
        return super.toString() + ret;
    }
}
