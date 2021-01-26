package com.yanjingw.arithmeticdemo;

/**
 * 递归
 */
public class RecursionArith {


    /**
     * 递归实例 n! = 1 x 2 x 3 x ... x n
     * fact(n)=n!=1×2×3×⋅⋅⋅×(n−1)×n=(n−1)!×n=fact(n−1)×n
     *
     * @param n
     * @return
     */
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * 尾递归
     *
     * @param n
     * @return
     */
    public static int fact2(int n) {
        return fact_iter(n, 1);
    }

    private static int fact_iter(int n, int i) {
        if (n == 0) {
            return i;
        }
        return fact_iter(n - 1, i * n);
    }


}
