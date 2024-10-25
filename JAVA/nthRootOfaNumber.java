// package JAVA;

import java.lang.Math;
// Problem Statement: Given two numbers n and m, find n-th root of m.

public class nthRootOfaNumber {
    public static void main(String[] args) {
        int res = nthRootOfaNum(27, 3);
        System.out.println(res);
    }

    static int nthRootOfaNum(int m, int n) {
        int ans = -1;
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (Math.pow(mid, n) == m)
                return mid;

            else if (Math.pow(mid, n) < m)
                start = mid + 1;

            else
                end = mid - 1;

        }

        return ans;
    }
}
