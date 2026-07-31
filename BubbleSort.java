
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 61, -1, 5, 32, 2};
        bsort(arr);
        System.out.println(Arrays.toString(arr));;
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
