package Bonus.StartUp;

import java.util.*;

public class Solution {
    static class Pair implements Comparable<Pair> {
        int value;
        int pos;

        public Pair(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value == other.value) {
                return Integer.compare(this.pos, other.pos);
            }
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long money = 0;
        int event, crush;
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            event = scanner.nextInt();
            if (event == 1) {
                int addNum = scanner.nextInt();
                queue.add(new Pair(addNum, i + 1));
            } else if (event == 2) {
                crush = scanner.nextInt();
                while (queue.size() >= crush) {
                    queue.poll();
                }
            }
        }
        event = scanner.nextInt();
        crush = scanner.nextInt();
        if (queue.size() < crush) {
            System.out.println(-1);
        } else {
            PriorityQueue<Integer> startUpPriorityQueue = new PriorityQueue<>();
            for (Pair m : queue) {
                money += m.value;
                startUpPriorityQueue.add(m.pos);
            }
            System.out.println(money);
            while (!startUpPriorityQueue.isEmpty()) {
                System.out.print(startUpPriorityQueue.poll() + " ");
            }
        }
    }
}
