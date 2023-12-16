package Bonus.Gift;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt(); 
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long max = a[0];
        queue.add(a[0]);

        System.out.print(max + " ");
        for(int i = 1; i < n; i ++){
            if (i < k){
                max += a[i];
                queue.add(a[i]);
            }
            else {
                if(a[i] > queue.peek()){
                    max = max - queue.poll() + a[i];
                    queue.add(a[i]);
                }
            }
            System.out.print(max + " "); 
        }
    }
}