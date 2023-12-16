package Bonus.WhoIsIntheMiddle;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static PriorityQueue<Long> firstPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Long> secondPriorityQueue = new PriorityQueue<Long>();

    public static void add(Long a) {
        if (secondPriorityQueue.isEmpty() || a > secondPriorityQueue.peek()) {
            secondPriorityQueue.add(a);
        } else {
            firstPriorityQueue.add(a);
        }
        if (secondPriorityQueue.size() - firstPriorityQueue.size() > 1) {
            firstPriorityQueue.add(secondPriorityQueue.poll());
        } else if (firstPriorityQueue.size() - secondPriorityQueue.size() > 1) {
            secondPriorityQueue.add(firstPriorityQueue.poll());
        }
    }

    public static Long remove() {
        if (secondPriorityQueue.isEmpty() && firstPriorityQueue.isEmpty()) {
            return 0l;
        }
        if (secondPriorityQueue.size() == firstPriorityQueue.size()) {
            return firstPriorityQueue.poll();
        } else {
            if (secondPriorityQueue.size() > firstPriorityQueue.size()) {
                return secondPriorityQueue.poll();
            } else {
                return firstPriorityQueue.poll();
            }
        }
    }

    public static Long update() {
        if (secondPriorityQueue.isEmpty() && firstPriorityQueue.isEmpty()) {
            return 0l;
        }
        if (secondPriorityQueue.size() == firstPriorityQueue.size()) {
            return firstPriorityQueue.peek();
        } else {
            if (secondPriorityQueue.size() > firstPriorityQueue.size()) {
                return secondPriorityQueue.peek();
            } else {
                return firstPriorityQueue.peek();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long height = scanner.nextLong();
            add(height);
        }
        for (int i = 1; i <= m; i++) {
            int event = scanner.nextInt();
            switch (event) {
                case 1:
                    Long x1 = scanner.nextLong();
                    add(x1);
                    break;
                case 2:
                    long x2 = remove();
                    break;
                case 3:
                    long x3 = update();
                    System.out.println(x3);
                    break;
            }
        }
    }
}