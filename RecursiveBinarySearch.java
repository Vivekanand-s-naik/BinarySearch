public class RecursiveBinarySearch{
    public static int binarySearch(int[] arr, int low, int high, int target){
        int mid = low + (high - low)/2;
        if (arr[mid] == target){
            return mid ;

        }
        else if (arr[mid] <  target) {
            return binarySearch(arr, mid + 1, high, target);
        }
        else{
            //arr[mid] > target
            return binarySearch(arr, low,  mid - 1, target);
        }
    }
    public static void main(String[] args) {
        int searchElem = 13;
        int[] arr = {10, 11, 13, 15, 17, 21};
        int res = binarySearch(arr, 0, arr.length - 1, searchElem); 
        System.out.println("Result : "+res);
    }
}