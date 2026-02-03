
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch{
    static int bs(int[] arr, int target, int size){
        int start = 0;
        int end = size - 1;
        int res = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        } 
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int[] arr = new int[n];

        int target;
        System.out.println("Enter "+n+" Array Elements (space in between) :");
        String[] parts = br.readLine().split(" ");
        System.out.println("Enter Target Element :");
        target = Integer.parseInt(br.readLine());

        for(int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        int res = bs(arr, target, arr.length);
        System.out.println(res);
        
    }
}