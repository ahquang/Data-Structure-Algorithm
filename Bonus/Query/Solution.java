package Bonus.Query;

import java.util.*;

public class Solution {

    public static void build(int[] t, int[] a, int id, int l, int r) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(t, a, id * 2, l, mid);
        build(t, a, id * 2 + 1, mid + 1, r);
        t[id] = Math.max(t[id * 2], t[id * 2 + 1]);
    }

    private static int get(int[] t, int[] a, int id, int l, int r, int u, int v) {
        if (v < l || r < u) {
            return -Integer.MAX_VALUE;
        }
        if (u <= l && r <= v) {
            return t[id];
        }
        int mid = (l + r) / 2;
        return Math.max(get(t, a, id * 2, l, mid, u, v), get(t, a, id * 2 + 1, mid + 1, r, u, v));
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
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(get(t, a, 1, 1, n, l, r));
        }
    }
}
