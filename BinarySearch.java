
import java.io.IOException;

public class BinarySearch {

    static int bs(int[] arr, int target, int size) {
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int ceilingOfNumber(int[] arr, int target) {
        //Ceiling => Number greater that or equal to target
        int start = 0;
        int end = arr.length - 1;
        if (arr[end] < target) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int floorOfNumber(int[] arr, int target) {
        // floor => largest Number samller than or equal to target
        int start = 0;
        int end = arr.length - 1;

        if (arr[start] > target) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    static int searchRange(int[] nums, int target, boolean fromStart) {
        // nums = [5,7,7,8,8,10], target = 8
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (fromStart) {
                //search towards left 
                if (nums[mid] >= target) {
                    end = mid - 1;
                    if (nums[mid] == target) {
                        res = mid;
                    }
                } else {
                    start = mid + 1;
                }
            } else {
                //search towards right
                if (nums[mid] <= target) {
                    start = mid + 1;
                    if (nums[mid] == target) {
                        res = mid;
                    }
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }

    static int binarySearchInInfiniteArray(int arr[], int target) {
        int start = 0;
        int end = 1;

        //update the size by current size * 2
        try {
            while (arr[end] < target) {
                System.out.println("start : " + start + "End : " + end);
                int newStart = end + 1;
                end = end + (end - start + 1) * 2;
                start = newStart;
            }
        } catch (Exception e) {
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int getPivotIndex(int[] arr) {
        //4 cases for rotated Array 
        // 1. if mid elem > next elem then return mid
        // 2. if mid-1 elem > mid elem return mid - 1
        // 3. start elem > mid, end = mid
        // 4. start elem < mid, start = mid + 1
        int start = 0;
        int end = arr.length - 1;
        if (end == 0) {
            return 0;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: mid - 1 is the pivot
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            // Case 3: pivot is on the left
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } // Case 4: pivot is on the right
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int sqrtOfNum(int num) {
        int start = 0;
        int end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sq = (long) mid * mid;
            if (sq == num) {
                return mid;
            }
            if (sq > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length - 1;

        while (start < matrix[0].length && end >= 0) {
            if (matrix[start][end] == target) {
                return true;
            }

            if (matrix[start][end] > target) {
                end--;
            } else if (matrix[start][end] < target) {
                start++;
            }
        }
        return false;
    }

    public int[] searchMatrixIndex(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = 5;
        // int[] arr = new int[n];

        // int target;
        // System.out.println("Enter " + n + " Array Elements (space in between) :");
        // String[] parts = br.readLine().split(" ");
        // System.out.println("Enter Target Element :");
        // target = Integer.parseInt(br.readLine());
        // for (int i = 0; i < parts.length; i++) {
        //     arr[i] = Integer.parseInt(parts[i]);
        // }
        // int res = bs(arr, target, arr.length);
        // int ceil = ceilingOfNumber(arr, target);
        // System.out.println("Ceiling : " + ceil);
        // int floor = floorOfNumber(arr, target);
        // System.out.println("floor : " + floor);
        // System.out.println(res);
        // int[] arr = new int[]{4, 1, 3};
        // int minElem = Arrays.stream(arr).sum();
        // System.out.println(minElem);
        // int target = 1;
        // int res = getPivotIndex(arr);
        // System.out.println(res);
        // int[] range = new int[]{searchRange(arr, target, true), searchRange(arr, target, false)};
        // System.out.println(Arrays.toString(range));
        // int num = 2147395599;
        // System.out.println("sq : " + sqrtOfNum(num));
        int num = 5;
        for (int i = 1; i <= num; i++) {
            System.out.println(num + (1 / Math.pow(10, i)));
        }
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 8));

    }
}
