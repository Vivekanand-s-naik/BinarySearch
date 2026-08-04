
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// class Solution {
//     // public boolean isTrionic(int[] nums) {
//     //     // check whether atleast 3 emelents exist
//     //     int n = nums.length;
//     //     if (n < 4)
//     //         return false;
//     //     // phase 1
//     //     Boolean phase1 = false;
//     //     Boolean phase2 = false;
//     //     Boolean phase3 = false;
//     //     int phase1Ind = 0;
//     //     int phase2Ind = 0;
//     //     int phase3Ind = 0;
//     //     for (int i = 0; i < n; i++) {
//     //         if (i < n - 1 && nums[i] == nums[i + 1])
//     //             return false;
//     //         // check for increasing
//     //         if (i < n - 1 && nums[i] < nums[i + 1]) {
//     //             phase1 = true;
//     //             phase1Ind = i + 1;
//     //         } else {
//     //             break;
//     //         }
//     //     }
//     //     for (int i = phase1Ind; i < n; i++) {
//     //         // check for decreasing
//     //         if (i < n - 1 && nums[i] > nums[i + 1]) {
//     //             phase2 = true;
//     //             phase2Ind = i + 1;
//     //         } else {
//     //             break;
//     //         }
//     //     }
//     //     for (int i = phase2Ind; i < n; i++) {
//     //         // check for increasing
//     //         if (i < n-1 && nums[i] < nums[i + 1]) {
//     //             phase3 = true;
//     //             phase3Ind = i + 1;
//     //         } else {
//     //             break;
//     //         }
//     //     }
//     //     if (phase3Ind == n-1)
//     //         return phase1 && phase2 && phase3;
//     //     else
//     //         return false;
//     // }
//     public boolean search(int[] nums, int target) {
//         int start = 0;
//         int end = nums.length - 1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (nums[mid] == target) {
//                 return true;
//             }
//             //skip the iterations if start, end, mid are equals (as they are not the target)
//             if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
//                 start++;
//                 end--;
//             } else {
//                 //search for sorted space
//                 if (nums[mid] <= nums[end]) {
//                     //right sorted
//                     if (nums[mid] <= target && nums[end] >= target) {
//                         start = mid + 1;
//                     } else {
//                         end = mid - 1;
//                     }
//                 } else {
//                     //right sorted
//                     if (nums[start] <= target && nums[mid] >= target) {
//                         end = mid - 1;
//                     } else {
//                         start = mid + 1;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         // int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//         // int target = 13;
//         // System.out.println("Result : " + new Solution().search(arr, target));
//         // int[] temp = {5, 4};
//         // temp = temp +  new int[]{5, 3, 2};
//         // int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
//         // List<Integer> res = findDuplicates(arr);
//         // System.out.println(res.toString());
//         // System.out.println(Arrays.toString(temp));
//         List<Integer> res = new ArrayList<>();
//         res.toArray();
//     }
//     static int[] findErrorNums(int[] nums) {
//         int[] res = {-1, -1};
//         int len = nums.length;
//         int i = 0;
//         while (i < len) {
//             int elem = nums[i];
//             if (elem != i + 1) {
//                 //Swapping Case
//                 int correctIndex = elem - 1;
//                 if (elem == nums[correctIndex]) {
//                     //duplicate
//                     res[0] = elem;
//                     i++;
//                 } else {
//                     int temp = elem;
//                     nums[i] = nums[correctIndex];
//                     nums[correctIndex] = temp;
//                 }
//             } else {
//                 i++;
//             }
//         }
//         //for missing elementt
//         for (int k = 1; k <= len; k++) {
//             if (nums[k - 1] != k) {
//                 //missing element found
//                 res[1] = k;
//             }
//         }
//         return res;
//     }
//     static List<Integer> findDuplicates(int[] nums) {
//         int len = nums.length;
//         List<Integer> list = new ArrayList<>(0);
//         int i = 0;
//         while (i < len) {
//             if (nums[i] != i + 1) {
//                 int correctIndex = nums[i] - 1;
//                 if (nums[i] == nums[correctIndex]) {
//                     list.add(nums[i]);
//                     i++;
//                 } else {
//                     int temp = nums[i];
//                     nums[i] = nums[correctIndex];
//                     nums[correctIndex] = temp;
//                     System.out.println(Arrays.toString(nums));
//                 }
//             } else {
//                 i++;
//             }
//         }
//         return list;
//     }
// }
class Solution {

    public static void main(String[] args) {
        // int[] nums1 = new int[]{1, 3};
        // int[] nums2 = new int[]{2, 7};
        // System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] arr = new int[]{1, 2};
        int res = elementGreaterThanK(arr, arr.length, 2);
        System.out.println(res);
    }

    static int elementGreaterThanK(int[] arr, int len, int k) {
        int start = 0;
        int end = len - 1;
        int res = k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                res = arr[mid];
            }
        }
        System.out.println("start : " + arr[start] + " End" + arr[end]);
        return res;
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 1) {
            return nums2[len2 - 1];
        }
        if (len2 == 0 && len1 == 1) {
            return nums1[len1 - 1];
        }

        double start = nums1[0] < nums2[0] ? nums1[0] : nums2[0];
        double end = nums1[len1 - 1] > nums2[len2 - 1] ? nums1[len1 - 1] : nums2[len2 - 1];
        double median = nums1[0];
        // while (start <= end) {
        double mid = start + (end - start) / 2;
        if ((len1 + len2) % 2 == 0) {
            return mid;
        }

        median = getMedian(nums1, nums2, len1, len2, mid);
        System.out.println("median : " + median);
        if (mid == median) {
            return mid;
        }
        //     if (median > mid) {
        //         start = mid + 1;
        //     } else {
        //         end = mid - 1;
        //     }
        // }
        return median;
    }

    static double getMedian(int[] nums1, int[] nums2, int len1, int len2, double target) {
        if ((len1 + len2) % 2 == 0) {
            return target;
        }
        int res1 = bs(nums1, len1, (int) target);
        if (res1 != -1) {
            return res1;
        }
        int res2 = bs(nums2, len2, (int) target);
        if (res2 != -1) {
            return res2;
        }
        //the mid value is not present, So return the value less then median
        if (nums1[len1 - 1] > target) {
            return lessMedianValue(nums1, len1, (int) target);
        }
        int res4 = lessMedianValue(nums2, len2, (int) target);
        if (res4 != -1) {
            return res4;
        }
        return target;
    }

    static int bs(int[] arr, int size, int target) {
        int start = 0;
        int end = size - 1;
        System.out.println("target : " + target);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                System.out.println(":mid " + mid);
                return arr[mid];
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int lessMedianValue(int[] arr, int size, int target) {
        int start = 0;
        int end = size - 1;
        System.out.println("target : " + target);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        // System.out.println("arrend : "+arr[end]);

        return arr[start - 1];
    }
}
