public class SearchInRotatedArray {

    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target)
                return mid;

            if ((arr[mid] <= arr[end])){
                //Right portion sorted
                if (arr[mid] <= target && arr[end] >= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if (arr[start] <= target && arr[mid] >= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
           }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {11, 13, 15, 1, 3, 5, 6, 7, 9};
        int target = 12;
        int res = search(arr, target);
        System.out.println("Result :"+res);
    }
}
