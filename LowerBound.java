public class LowerBound{
    static int getLowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = high;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid] >= target){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int target = 4;
        int res = getLowerBound(arr, target);
        System.out.println("Result : "+res);
    }
}