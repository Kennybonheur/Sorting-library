import java.io.FileWriter;
import java.io.IOException;
import java.util.random.RandomGenerator;


public class SortingExercise {

    // Generate random array
    public static int[] generate(int start, int end, int size) {
        RandomGenerator var3 = RandomGenerator.getDefault();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = var3.nextInt(start, end);
        }
        return arr;
    }
    public static void printArray(int[] arr) {
      for(int r : arr) {
         System.out.print(r + " ");
      }

      System.out.println();
   }

    // Write array to file
    public static void writeArrayToFile(int[] arr, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + (i < arr.length - 1 ? " " : ""));
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = generate(1, 1000000, 1000);
        System.out.println("Generated Numbers:");
        printArray(arr);
        writeArrayToFile(arr, "file.txt");

        // Bubble Sort
        int[] bubbleArr = arr.clone();
        bubbleSort(bubbleArr);
        writeArrayToFile(bubbleArr, "bubbleSort_output.txt");
        System.out.println("Bubble Sort Result:");
        printArray(bubbleArr);

        // Selection Sort
        int[] selectionArr = arr.clone();
        selectionSort(selectionArr);
        writeArrayToFile(selectionArr, "selectionSort_output.txt");
        System.out.println("Selection Sort Result:");
        printArray(selectionArr);

        // Insertion Sort
        int[] insertionArr = arr.clone();
        insertionSort(insertionArr);
        writeArrayToFile(insertionArr, "insertionSort_output.txt");
        System.out.println("Insertion Sort Result:");
        printArray(insertionArr);

        // Shell Sort
        int[] shellArr = arr.clone();
        shellSort(shellArr);
        writeArrayToFile(shellArr, "shellSort_output.txt");
        System.out.println("Shell Sort Result:");
        printArray(shellArr);
    }
}