import java.util.Arrays;

public class FirstAndLastOccurrence{
    static int getFirstIndex(int[] arr, int target, int end){
        
        int start = 0;
        int indx = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                indx = mid;
                //search towards left 
                end = mid - 1;
            }else if (arr[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return indx;
    }
    static int getLastIndex(int[] arr, int target, int end){
        int start = 0;
        int indx = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                //search towards right
                indx = mid;
                start = mid + 1;
            }else if (arr[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return  indx;
    }
    public int[] getFirstAndLastIndex(int[] arr, int target){
        int size = arr.length;
        int firstIndex = getFirstIndex(arr, target, size-1);
        int lastIndex = getLastIndex(arr, target, size-1);
        return new int[]{firstIndex, lastIndex};
    }
    public static void main(String[] args){
        FirstAndLastOccurrence f1 = new FirstAndLastOccurrence();
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int target = 12;
        int[] res = f1.getFirstAndLastIndex(arr, target);
        System.out.println("Result : "+Arrays.toString(res));
        
    }
}