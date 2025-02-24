import java.util.Arrays;

public class Main
{
    public static void mergeSort(String[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }// end if
    }// end mergeSort

    public static void merge(String[] arr, int left, int mid, int right)
    {
        String[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        String[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length)
        {
            if (leftArray[i].compareToIgnoreCase(rightArray[j]) <= 0)
            {
                arr[k++] = leftArray[i++];
            }// end if statement
            else
            {
                arr[k++] = rightArray[j++];
            }// end else statement
        }// end while loop
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }// end merge method

    public static void main(String[] args)
    {
        String[] books =
                {
                "The Great Gatsby",
                "To Kill a Mockingbird",
                "1984",
                "Moby Dick",
                "Pride and Prejudice"
                };
        System.out.println("Before Sorting: " + Arrays.toString(books));

        mergeSort(books, 0, books.length - 1);

        System.out.println("After Sorting: " + Arrays.toString(books));
    }// end maiin
}// end class
