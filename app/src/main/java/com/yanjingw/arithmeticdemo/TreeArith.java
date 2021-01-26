package com.yanjingw.arithmeticdemo;

import java.io.File;

public class TreeArith {
    /**
     * 计算文件夹大小
     */
    public static void flipTreeByStack(File root) {
        long size = 0;
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                size += file.length();
            } else {
                flipTreeByStack(file);
            }
        }
    }

}
