package Bonus.Query2;

import java.util.Scanner;

public class Solution {
    public static void build(int[] t, int[] a, int id, int l, int r) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(t, a, id * 2, l, mid);
        build(t, a, id * 2 + 1, mid + 1, r);
        t[id] = Math.min(t[id * 2], t[id * 2 + 1]);
    }

    public static long get(int[] t, int[] a, int id, int l, int r, int u, int v) {
        if (v < l || r < u) {
            return Long.MAX_VALUE;
        }
        if (u <= l && r <= v) {
            return t[id];
        }
        int mid = (l + r) / 2;
        return Math.min(get(t, a, id * 2, l, mid, u, v), get(t, a, id * 2 + 1, mid + 1, r, u, v));
    }

    public static void update(int[] t, int id, int u, int v, int l, int r) {
        if (u < l || u > r) {
            return;
        }
        if (l == r) {
            t[id] = v;
            return;
        }

        int mid = (l + r) / 2;
        update(t, id * 2, u, v, l, mid);
        update(t, id * 2 + 1, u, v, mid + 1, r);

        t[id] = Math.min(t[id * 2], t[id * 2 + 1]);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 5];
        int[] t = new int[4 * n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        build(t, a, 1, 1, n);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int query = scanner.nextInt();
            if (query == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(get(t, a, 1, 1, n, l, r));
            } else if (query == 2) {
                int id = scanner.nextInt();
                int v = scanner.nextInt();
                update(t, 1, id, v, 1, n);
            }
        }
    }
}
