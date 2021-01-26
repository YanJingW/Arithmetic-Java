package com.yanjingw.arithmeticdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OtherArithmetic {
    /**
     * 生成杨辉三角 我的想法
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = generateSingleLine(i == 0 ? null : returnList.get(i - 1));
            returnList.add(line);
        }
        return returnList;
    }

    private List<Integer> generateSingleLine(List<Integer> preLine) {
        ArrayList<Integer> objects = new ArrayList<>();
        if (preLine == null || preLine.size() == 0) {
            objects.add(1);
        } else {
            objects.add(1);
            for (int i = 0; i < preLine.size() - 1; i++) {
                objects.add(preLine.get(i) + preLine.get(i + 1));
            }
            objects.add(1);
        }
        return objects;

    }

    /**
     * 生成杨辉三角 递归
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> objects = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                objects.add(generatesingle(i, j));
            }
            returnList.add(objects);
        }
        return returnList;
    }

    private int generatesingle(int x, int y) {
        if (x == 0 || y == 0 || x == y) {
            return 1;
        }
        return generatesingle(x - 1, y - 1) + generatesingle(x - 1, y);
    }

    /**
     * 生成杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate3(int numRows) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> objects = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                objects.add(generatesingle(i, j, i == 0 ? null : returnList.get(i - 1)));
            }
            returnList.add(objects);
        }
        return returnList;
    }

    private Integer generatesingle(int x, int y, List<Integer> integers) {
        if ((integers == null || x == 0 || y == 0 || x == y)) {
            return 1;
        }
        return integers.get(y - 1) + integers.get(y);
    }

    /**
     * 斐波那契数
     */
    private int method(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return method(n - 1) + method(n - 2);
    }

    HashMap<Integer, Integer> cache = new HashMap();

    /**
     * 斐波那契数
     * 使用缓存
     */
    private int method1(int n) {

        Integer o = cache.get(n);
        int result;
        if (o != null) {
            result = o;
        } else {
            if (n < 2) {
                result = n;
            } else {
                result = method1(n - 1) + method1(n - 2);
            }
            cache.put(n, result);
        }

        return result;
    }

    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * f(n) = f(n-1) + f(n-2)
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     */
    public int climbStairs(int n) {
        Integer o = cache.get(n);
        int result;
        if (o != null) {
            result = o;
        } else {
            if (n < 3) {
                result = n;
            } else {
                result = climbStairs(n - 1) + climbStairs(n - 2);
            }
            cache.put(n, result);
        }

        return result;
    }

}
