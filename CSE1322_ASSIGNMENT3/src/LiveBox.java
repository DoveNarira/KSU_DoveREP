public class LiveBox extends Box
{
    private String animal;
    private int age;

    // Default constructor, calls parents' default constructor and sets animal to empty and age to 0.
    public LiveBox()
    {
        super();
        animal = "";
        age = 0;
    }

    // Overloaded constructor that has a delivery address, return address, width, length, height, count, animal, and age in parameters.
    // Calls super constructor with the delivery address, return address, width, length, height, and count parameters.
    // Sets animal equal to parameter 'ani' and age equal to 'ag'.
    public LiveBox(String delivAddress, String retAddress, double w, double l, double h, int c, String ani, int ag)
    {
        super(delivAddress, retAddress, w, l, h, c);
        animal = ani;
        age = ag;
    }

    public String getAnimal()
    {
        return animal;
    }

    public int getAge()
    {
        return age;
    }

    // Overrides toString(), calls parents' toString() and adds a printout of the animal, count, and age (in days).
    @Override
    public String toString()
    {
        String ret = "Animal: " + animal + "\n" + "Count: " + getCount() + "\n" + "Age (Days): " + age;
        return super.toString() + ret;
    }
}
