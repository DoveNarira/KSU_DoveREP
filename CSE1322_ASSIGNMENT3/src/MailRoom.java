import java.util.ArrayList;
import java.util.Scanner;

public class MailRoom
{
    // handleLetter checks if the letter fits within the following characteristics (measurement is inches):
    // delivery and return addresses aren't empty
    // 5 <= letter.getLength() <= 11.5
    // 3.5 <= letter.getWidth() <= 6.125
    // 0.007 <= letter.getThickness() <= 0.25
    // letter is a rectangle ((letter.getLength() + 1.5) > letter.getWidth())
    public static Boolean handleLetter(Letter letter, ArrayList<Mail> deliver)
    {
        if(!letter.getDeliveryAddress().isEmpty() && !letter.getReturnAddress().isEmpty())
        {
            if((letter.getLength() >= 5 && letter.getLength() <= 11.5) && (letter.getWidth() >= 3.5 && letter.getWidth() <= 6.125))
            {
                if((letter.getThickness() >= 0.007 && letter.getThickness() <= 0.25) && ((letter.getLength() + 1.5) > letter.getWidth()))
                {
                    deliver.add(letter);
                    return true;
                }
            }
        }
        return false;

    }

    // handleFlat checks if the flat fits within the following characteristics (measurement is inches):
    // delivery and return addresses aren't empty
    // 11.5 <= flat.getLength() <= 15
    // 6.125 <= flat.getWidth() <= 12
    // 0.25 <= flat.getThickness() <= 0.75
    // flat's contents only contain "DOCUMENTS" (AKA flat.getContents().equals("DOCUMENTS"))
    public static Boolean handleFlat(Flat flat, ArrayList<Mail> deliver)
    {
        if(!flat.getDeliveryAddress().isEmpty() && !flat.getReturnAddress().isEmpty())
        {
            if((flat.getLength() >= 11.5 && flat.getLength() <= 15) && (flat.getWidth() >= 6.125 && flat.getWidth() <= 12))
            {
                if((flat.getThickness() >= 0.25 && flat.getThickness() <= 0.75) && flat.getContents().equalsIgnoreCase("DOCUMENTS"))
                {
                    deliver.add(flat);
                    return true;
                }
            }
        }
        return false;
    }

    // handleRegularBox checks if the box fits within the following characteristics:
    // delivery and return addresses aren't empty
    // 6 <= regularBox.getLength() <= 27in
    // 0.25 <= regularBox.getWidth() <= 17in
    // 3 <= regularBox.getHeight() <= 17in
    // 0 <= regularBox.getWeight() <= 70lbs
    // 0 <= regularBox.getCount() <= 50
    public static Boolean handleRegularBox(RegularBox regularBox, ArrayList<Mail> deliver)
    {
        if(!regularBox.getDeliveryAddress().isEmpty() && !regularBox.getReturnAddress().isEmpty())
        {
            if((regularBox.getLength() >= 6 && regularBox.getLength() <= 27) && (regularBox.getWidth() >= 0.25 && regularBox.getWidth() <= 17))
            {
                if((regularBox.getHeight() >= 3 && regularBox.getHeight() <= 17) && (regularBox.getWeight() >= 0 && regularBox.getWeight() <= 70) && (regularBox.getCount() >= 0 && regularBox.getCount() <= 50))
                {
                    deliver.add(regularBox);
                    return true;
                }
            }
        }
        return false;
    }

    // handleLiveBox checks if the box fits within the following characteristics:
    // delivery and return addresses aren't empty
    // 6 <= liveBox.getLength() <= 27in
    // 0.25 <= liveBox.getWidth() <= 17in
    // 3 <= liveBox.getHeight() <= 17in
    // liveBox contains "HONEYBEES" with between 0-20 honeybees (liveBox.getAnimal().equals("HONEYBEES"))
    // OR
    // liveBox contains "CHICKEN" with between 0-10 chickens, none older than 1 or negative age. (liveBox.getAnimal().equals("CHICKEN"))
    public static Boolean handleLiveBox(LiveBox liveBox, ArrayList<Mail> deliver)
    {
        if(!liveBox.getDeliveryAddress().isEmpty() && !liveBox.getReturnAddress().isEmpty())
        {
            if((liveBox.getLength() >= 6 && liveBox.getLength() <= 27) && (liveBox.getWidth() >= 0.25 && liveBox.getWidth() <= 17) && (liveBox.getHeight() >= 3 && liveBox.getHeight() <= 17))
            {
                if(("HONEYBEES").contains(liveBox.getAnimal()))
                {
                    if((liveBox.getCount() >= 0) && (liveBox.getCount() <= 20))
                    {
                        deliver.add(liveBox);
                        return true;
                    }
                }

                if(("CHICKEN").contains(liveBox.getAnimal()))
                {
                    if((liveBox.getCount() >= 0) && (liveBox.getCount() <= 10))
                    {
                        if((liveBox.getAge() >= 0) && (liveBox.getAge() <= 1))
                        {
                            deliver.add(liveBox);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<Mail> deliver = new ArrayList<Mail>();    // Our list of mail
        Scanner scan = new Scanner(System.in);
        int user_choice;

        System.out.print("Welcome to KSUPS\n");
        do
        {
            System.out.println();
            System.out.print("1- Send letter\n" +
                    "2- Send flat\n" +
                    "3- Send regular box\n" +
                    "4- Send live box\n" +
                    "5- Dispatch items\n" +
                    "6- Quit\n" +
                    "Enter option: ");

            user_choice = scan.nextInt();       //get user's menu choice
            System.out.println();

            selectionSort(user_choice, deliver);
            // if user picked 6, it exits the do-while.
            if(user_choice == 6)
            {
                System.out.println("Quitting...");
            }
        }
        while((user_choice >= 1) && (user_choice <= 5));
    }

    public static void selectionSort(int user_choice, ArrayList<Mail> deliver)
    {
        Scanner scan = new Scanner(System.in);

        // USED FOR STORING USER INPUTS IN DO-WHILE
        String delivAddress;    //delivery address
        String retAddress;      //return address
        int width;              //width
        int length;             //length
        double thickness;       //thickness
        int height;             //height
        String contents;        //contents
        int items;              //items (box)
        int weight;             //weight (box)
        String animal;          //animal (live box)
        int age;                //age (live box)

        // Asking here as every single choice requires this information.

        // if user picks 5, print out the toString() of each Mail item in deliver before clearing the deliver ArrayList.
        if(user_choice == 5)
        {
            if(deliver.isEmpty())
            {
                System.out.println("Delivery queue is empty.");
            }
            else
            {
                System.out.println("DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:");
                System.out.println("==========");
                for (Mail mail : deliver)
                {
                    System.out.println(mail.toString());
                    System.out.println("==========");
                }
                deliver.clear();
                System.out.println();
            }

            return;
        }

        System.out.print("Enter the delivery address: ");
        delivAddress = scan.nextLine();

        System.out.print("Enter the return address: ");
        retAddress = scan.nextLine();

        System.out.print("Enter the width of your mail: ");
        width = scan.nextInt();

        System.out.print("Enter the length of your mail: ");
        length = scan.nextInt();

        // if user picks 1 or 2, it will ask them questions.
        if(user_choice == 1 || user_choice == 2)
        {
            System.out.print("Enter the thickness of your mail: ");
            thickness = scan.nextDouble();

            scan.nextLine();

            System.out.print("Enter the contents of your Letter: ");
            contents = scan.nextLine();
            System.out.println();

            // If user picked 1, it will construct a letter using their inputs, and send it to handleLetter.
            // if handleLetter returns true (AKA is added to deliver), it'll print that the letter has been added.
            // otherwise, it'll print that the letter couldn't get added.
            if(user_choice == 1)
            {
                Letter letter = new Letter(delivAddress, retAddress, width, length, thickness, contents);
                if(handleLetter(letter, deliver))
                {
                    System.out.println("Letter accepted for delivery!");
                }
                else
                {
                    System.out.println("Letter cannot be mailed.");
                }
            }
            // if user picks 2, it will construct a Flat using their inputs, and send it to handleFlat.
            // if handleFlat returns true (AKA is added to deliver), it'll print that the Flat has been added.
            // otherwise, it'll print that the Flat couldn't get added.
            else
            {
                Flat flat = new Flat(delivAddress, retAddress, width, length, thickness, contents);
                if(handleFlat(flat, deliver))
                {
                    System.out.println("Flat accepted for delivery!");
                }
                else
                {
                    System.out.println("Flat cannot be mailed.");
                }
            }

        }
        // if user picks 3, ask them questions, construct a Regular Box using their inputs, and send it to handleRegularBox.
        // if handleRegularBox returns true (AKA is added to deliver), it'll print that the Regular box has been added.
        // otherwise, it'll print that the Regular box couldn't get added.
        else if(user_choice == 3)
        {
            System.out.print("Enter the height of your mail: ");
            height = scan.nextInt();

            System.out.print("Enter how many items your box has: ");
            items = scan.nextInt();

            System.out.print("Enter the weight of your box: ");
            weight = scan.nextInt();

            scan.nextLine();

            System.out.print("Enter the contents of your Box: ");
            contents = scan.nextLine();
            System.out.println();

            RegularBox regularBox = new RegularBox(delivAddress, retAddress, width, length, height, items, weight, contents);
            if(handleRegularBox(regularBox, deliver))
            {
                System.out.println("Regular box accepted for delivery!");
            }
            else
            {
                System.out.println("Regular box cannot be mailed.");
            }
        }
        // if user picks 4, ask them questions, construct a Live Box using their inputs, and send it to handleLiveBox.
        // if handleLiveBox returns true (AKA is added to deliver), it'll print that the Live box has been added.
        // otherwise, it'll print that the Live box couldn't get added.
        else if(user_choice == 4)
        {

            System.out.print("Enter the height of your mail: ");
            height = scan.nextInt();

            System.out.print("Enter how many items your box has: ");
            items = scan.nextInt();

            scan.nextLine();

            System.out.print("Enter what animal is being shipped: ");
            animal = scan.nextLine().toUpperCase();

            System.out.print("Enter age of the oldest animal, in days: ");
            age = scan.nextInt();
            System.out.println();

            LiveBox liveBox = new LiveBox(delivAddress, retAddress, width, length, height, items, animal, age);
            if(handleLiveBox(liveBox, deliver))
            {
                System.out.println("Live box accepted for delivery!");
            }
            else
            {
                System.out.println("Live box cannot be mailed.");
            }
        }
    }
}
