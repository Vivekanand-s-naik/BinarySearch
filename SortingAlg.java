
import java.util.Arrays;

public class SortingAlg {

    public static void main(String[] args) {
        int[] arr = {5, 61, -1, 5, 32, 2};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = arr[start];
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void swapElement(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swapElement(arr, maxIndex, lastIndex);
        }
    }

    static void bsort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
