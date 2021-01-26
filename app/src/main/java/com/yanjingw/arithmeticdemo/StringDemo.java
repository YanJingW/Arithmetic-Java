package com.yanjingw.arithmeticdemo;

public class StringDemo {

    /**
     * 反转字符串,didi == 字符数组？
     * 考察点：了解字符串在内存中的存储形式
     */
    public char[] revert(char[] src) {
        if (src == null) {
            return null;
        }

        for (int i = 0; i < src.length / 2; i++) {
            char tem = src[i];
            src[i] = src[src.length - 1 - i];
            src[src.length - i - 1] = tem;
        }

        return src;
    }

    /**
     * 递归
     *
     * @param src
     * @return
     */
    public char[] revert2(char[] src) {
        revert2(0, src);
        return src;
    }

    public void revert2(int i, char[] src) {
        if (src == null) {
            return;
        }
        if (i >= src.length / 2) {
            return;
        }
        char tem = src[i];
        src[i] = src[src.length - 1 - i];
        src[src.length - i - 1] = tem;
        revert2(i + 1, src);
    }

    /**
     * 以相反的顺序打印字符串,迭代
     */
    public void printReverse(char[] src) {
        for (int i = src.length - 1; i >= 0; i--) {
            System.out.println(src[i]);
        }
    }

    /**
     * 以相反的顺序打印字符串，递归
     */
    public void printReverse2(char[] src) {
        printReverse(0, src);
    }

    private void printReverse(int i, char[] src) {
        if (src == null) {
            return;
        }
        if (i >= src.length) {
            return;
        }
        printReverse(i + 1, src);
        System.out.println(src[i]);
    }

}
