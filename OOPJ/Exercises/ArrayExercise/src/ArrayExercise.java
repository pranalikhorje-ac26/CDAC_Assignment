class ArrayExercises
{
    // 1. Sort numeric array
    static void sortArray(int a[])
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    // 2. Sum of array
    static void sumArray(int a[])
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
        {
            sum = sum + a[i];
        }
        System.out.println("Sum = " + sum);
    }


    // 3. Average of array
    static void averageArray(int a[])
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
        {
            sum = sum + a[i];
        }
        double average = (double) sum / a.length;
        System.out.println("Average = " + average);
    }


    // 4. Copy array
    static void copyArray(int a[])
    {
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++)
        {
            b[i] = a[i];
        }
        System.out.println("Copied Array:");
        for (int i = 0; i < b.length; i++)
        {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }


    // 5. Maximum and minimum
    static void maxMin(int a[])
    {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > max)
                max = a[i];

            if (a[i] < min)
                min = a[i];
        }
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
    }


    // 6. Reverse array
    static void reverseArray(int a[])
    {
        System.out.println("Reverse Array:");
        for (int i = a.length - 1; i >= 0; i--)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    
    // 7. Duplicate values
    static void duplicateValues(int a[])
    {
        System.out.println("Duplicate Values:");
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] == a[j])
                {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }

    // 8. Common elements between two arrays
    static void commonElements(int a[], int b[])
    {
        System.out.println("Common Elements:");
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                if (a[i] == b[j])
                {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.print("Enter size of array: ");
        int n = ConsoleInput.getInt();
        int a[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
        {
            a[i] = ConsoleInput.getInt();
        }
        sortArray(a);
        sumArray(a);
        averageArray(a);
        copyArray(a);
        maxMin(a);
        reverseArray(a);
        duplicateValues(a);

        // Second array for common elements
        System.out.print("Enter size of second array: ");
        int m = ConsoleInput.getInt();

        int b[] = new int[m];
        System.out.println("Enter second array elements:");
        for (int i = 0; i < m; i++)
        {
            b[i] = ConsoleInput.getInt();
        }
        commonElements(a, b);
    }
}
