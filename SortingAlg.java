
import java.util.Arrays;

/*
Learnt 3 sorting algorithms 
1 Bubble Sort 
    Intution: start with left elem and move the large element to right (after each pass large elem move to right)
    Time complexities 
        O(n^2) Worst Case
        O(n) Best Case when Array is sorted and no swaps occur

2 Selection Sort
    Intution: Select min or max elem from portion and move the element to right or place in valid position, By doing so after each pass the large elems will be moved to right
    Used to get k-th largest or smallest elem from unordered List 
    Time complexities:
        O(n^2) for both Best and Worst case 

3 Insertion Sort
    Intution: select portion sort and then insert the next element('s) accordingly
    works well or steps are reduced for partially sorted Sequence
    Combined to form hybrid sorting    
    Time Complexities 
        O(n^2) worst Case when list is decending sorted
        O(n) Best case when array is sorted 
 */
public class SortingAlg {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 2, 5, 3, 8, 7, 4, 6};
        System.out.println(Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {
        int i = 0; //acts as key
        while (i < arr.length) {
            //Get the correct index of i^th element
            int correctIndex = arr[i] - 1;
            if (arr[i] == arr[correctIndex]) {
                i++;
            } else {
                swapElement(arr, i, correctIndex);
            }
        }
    }

    //Selection Sort
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swapElement(arr, maxIndex, lastIndex);
        }
    }

    //Bubble Sort
    static void bubbleSOrt(int[] arr) {
        boolean isSwapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapElement(arr, j, j - 1);
                    isSwapped = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!isSwapped) {
                break;
            }
        }
    }

    //Insertion Sort
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swapElement(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
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

}
