
public class UpperBound {
    static class GetUpperBound{
        public int getUpperBound(int[] arr, int target){
            int low = 0;
            int high = arr.length - 1;
            int ans = low;

            while (low <= high){
                int mid = low + (high - low)/2;
                if (arr[mid] <= target){
                    low = mid + 1;
                    ans = mid;
                }
                else {
                    high = mid - 1;
                }
            }
            return ans;
        }
    
    }
    public static void main(String[] args) {
        GetUpperBound upperbnd = new GetUpperBound();
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int target = 10 ;
        int res = upperbnd.getUpperBound(arr, target);
        System.out.println("Result : "+res);
    }
}
