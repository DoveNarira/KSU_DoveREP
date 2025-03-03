import java.util.Scanner;

public class BubbleSort
{
    // counts how many swaps happen for arrays.
    public static int count = 0;

    // Performs BubbleSort, where the largest number in the array will 'bubble' to the top.
    public static void bubbleSort(int[] array)
    {
        int size = array.length;

        // Loops the array, reducing its range by one each loop.
        for(int j = size - 1; j > 0; j--)
        {
            // It will go through the array once, comparing array[i] to array[i+1].
            for(int i = 0; i < j; i++)
            {
                // If array[i] is bigger than array[i+1], call swap and increment the count by 1.
                if(array[i] > array[i+1])
                {
                    // calls swap and increases count by 1
                    swap(array, i, i+1);
                    count++;
                }
            }
        }
    }

    // Swaps two values in an array.
    // pos1 is i, and pos2 is i+1.
    public static void swap(int[] array, int pos1, int pos2)
    {
        // temp is equal to i
        int temp = array[pos1];

        // set array[i] to array[i+1], which means you are setting array[i] to a smaller value
        array[pos1] = array[pos2];

        // set array[i+1] to temp, which means you are setting array[i+1] to a bigger value
        array[pos2] = temp;
    }

    // prints out the array
    public static void print(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            System.out.print(array[i] + " | ");
        }
        System.out.print(array[array.length - 1]);
    }

    // CAN BE IGNORED. TEST TO MAKE SURE THE BUBBLE SORT WORKS!
    // Step 1, testing that BubbleSort works
    public static void introduce(int[] myArray)
    {
        Scanner scan = new Scanner(System.in);
        int input = 0;

        System.out.print("Hello, user! ");

        do {
            System.out.println("Please enter a number greater than 0!");
            input = scan.nextInt();
        }
        while(input < 0);

        System.out.println("Thank you! Creating a randomized int array of that length...");

        myArray = new int[input];

        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = (int) (Math.random() * 100) + 1;
        }

        System.out.println("Done! Here is your unsorted array: ");
        print(myArray);

        System.out.println("\nNow here is the array sorted using bubble sort!");

        bubbleSort(myArray);
        print(myArray);
    }

    public static void main(String[] args)
    {
        // Asking and getting user input
        Scanner scan = new Scanner(System.in);
        int input = 0;

        System.out.println("Please enter a number greater than 0! This will be the size of each array!");
        input = scan.nextInt();

        System.out.println("Please wait...");

        // the amount of time it took for a single array to be sorted (aka the average of the total time)
        float running_time = 0;

        // the total time taken for the arrays to be sorted
        long total_time = 0;

        // makes 1000 arrays, fills those arrays, and sorts them.
        // records the start and end time for each array and gets the total time.
        for (int i = 0; i < 1000; i++)
        {
            int[] array = new int[input];

            for (int j = 0; j < array.length; j++)
            {
                array[j] = (int) (Math.random() * 100) + 1;
            }

            long start_time = System.currentTimeMillis();

            bubbleSort(array);

            long end_time = System.currentTimeMillis();

            // get the difference between end_time and start_time.
            total_time += (end_time - start_time);
        }

        // get the average run time by dividing the total time by 1000.
        running_time = (float) total_time / 1000;

        System.out.println("\n" + total_time + "ms in total");
        System.out.println(running_time + "ms per array");
        System.out.println(count + " swaps in total");
    }
}
