public class Main {
    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int[] arr4 = arr1.clone();
        int[] arr5 = arr1.clone();

        System.out.println("Original Array:");
        printArray(arr1);

        // Selection Sort
        SortingComparison.selectionSort(arr1, arr1.length);
        System.out.println("\nSelection Sort:");
        printArray(arr1);

        // Insertion Sort
        SortingComparison.insertionSort(arr2, arr2.length);
        System.out.println("\nInsertion Sort:");
        printArray(arr2);

        // Merge Sort
        SortingComparison.mergeSort(arr3, arr3.length);
        System.out.println("\nMerge Sort:");
        printArray(arr3);

        // Quick Sort
        SortingComparison.quickSort(arr4, arr4.length);
        System.out.println("\nQuick Sort:");
        printArray(arr4);

        // Bubble Sort
        SortingComparison.bubbleSort(arr5);
        System.out.println("\nBubble Sort:");
        printArray(arr5);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class SortingComparison {
    // Selection sort: O(n²) in worst, average, and best cases
    public static void selectionSort(int[] arr, int hi) {
        for (int x = 0; x < hi - 1; x++) {
            int locSmallest = x;
            for (int y = x + 1; y < hi; y++) {
                if (arr[locSmallest] > arr[y]) { // Fixed condition for ascending order
                    locSmallest = y;
                }
            }
            // Swap
            int temp = arr[locSmallest];
            arr[locSmallest] = arr[x];
            arr[x] = temp;
        }
    }

    // Insertion sort: Best case O(n), worst/average O(n²)
    public static void insertionSort(int[] arr, int hi) {
        for (int start = 1; start < hi; start++) {
            int temp = arr[start];
            int prev = start - 1;
            while (prev >= 0 && arr[prev] > temp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
    }

    // Merge Sort: O(n log n) in all cases
    public static void mergeSort(int[] arr, int hi) {
        mergeSortWorker(arr, 0, hi - 1);
    }

    private static void mergeSortWorker(int[] arr, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            mergeSortWorker(arr, lowerBound, mid);
            mergeSortWorker(arr, mid + 1, upperBound);
            merge(arr, lowerBound, mid, upperBound);
        }
    }

    private static void merge(int[] arr, int low, int mid, int upper) {
        int[] temp = new int[upper - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= upper) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= upper) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    // Quick Sort: Best/Average O(n log n), Worst O(n²)
    public static void quickSort(int[] arr, int hi) {
        quickSortWorker(arr, 0, hi - 1);
    }

    private static void quickSortWorker(int[] arrayData, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arrayData, lo, hi);
            quickSortWorker(arrayData, lo, pivot - 1);
            quickSortWorker(arrayData, pivot + 1, hi);
        }
    }

    private static int partition(int[] arrayData, int lo, int hi) {
        int pivot = arrayData[hi];
        int i = lo - 1;
        for (int x = lo; x < hi; x++) {
            if (arrayData[x] < pivot) {
                i++;
                int temp = arrayData[x];
                arrayData[x] = arrayData[i];
                arrayData[i] = temp;
            }
        }
        int temp = arrayData[i + 1];
        arrayData[i + 1] = arrayData[hi];
        arrayData[hi] = temp;
        return i + 1;
    }

    // Bubble Sort: Best O(n), Worst/Average O(n²)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) { // Fixed loop condition
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
