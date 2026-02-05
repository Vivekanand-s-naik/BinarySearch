class Solution {
    // public boolean isTrionic(int[] nums) {
    //     // check whether atleast 3 emelents exist
    //     int n = nums.length;
    //     if (n < 4)
    //         return false;

    //     // phase 1
    //     Boolean phase1 = false;
    //     Boolean phase2 = false;
    //     Boolean phase3 = false;
    //     int phase1Ind = 0;
    //     int phase2Ind = 0;
    //     int phase3Ind = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (i < n - 1 && nums[i] == nums[i + 1])
    //             return false;
    //         // check for increasing
    //         if (i < n - 1 && nums[i] < nums[i + 1]) {
    //             phase1 = true;
    //             phase1Ind = i + 1;
    //         } else {
    //             break;
    //         }

    //     }
    //     for (int i = phase1Ind; i < n; i++) {
    //         // check for decreasing
    //         if (i < n - 1 && nums[i] > nums[i + 1]) {
    //             phase2 = true;
    //             phase2Ind = i + 1;
    //         } else {
    //             break;
    //         }
    //     }
    //     for (int i = phase2Ind; i < n; i++) {
    //         // check for increasing
    //         if (i < n-1 && nums[i] < nums[i + 1]) {
    //             phase3 = true;
    //             phase3Ind = i + 1;
    //         } else {
    //             break;
    //         }
    //     }
    //     if (phase3Ind == n-1)
    //         return phase1 && phase2 && phase3;
    //     else
    //         return false;
    // }

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while( start <= end ){
            int mid = start + (end - start)/2;
            if (nums[mid] == target)
                return true;
            //skip the iterations if start, end, mid are equals (as they are not the target)
            if (nums[mid]==nums[start] && nums[mid] == nums[end]){
                start++;
                end--;
            }else{
                //search for sorted space
                if (nums[mid] <= nums[end]){
                    //right sorted
                    if (nums[mid] <= target && nums[end] >= target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }else{
                    //right sorted
                    if (nums[start] <= target && nums[mid] >= target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 13;
        System.out.println("Result : " + new Solution().search(arr, target));

    }
}