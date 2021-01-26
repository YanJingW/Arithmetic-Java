package com.yanjingw.arithmeticdemo;

import java.util.HashMap;

public class ArrayArith {
    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void mergeArray(int[] A, int m, int[] B, int n) {
        if (B == null) {
            return;
        }

        if (m == 0 || n == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }

        if (A[m - 1] > B[n - 1]) {
            A[m + n - 1] = A[m - 1];
            m = m - 1;
        } else {
            A[m + n - 1] = B[n - 1];
            n = n - 1;
        }

        mergeArray(A, m, B, n);
    }

    public void mergeArray2(int[] A, int m, int[] B, int n) {
        if (B == null) {
            return;
        }

        while (n > 0 && m > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m = m - 1;
            } else {
                A[m + n - 1] = B[n - 1];
                n = n - 1;
            }
        }

        if (m == 0 || n == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }

    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        //交换
                        int tem = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tem;
                        break;
                    }
                }
            }
        }

    }

    /**
     * 找出数组中重复的数字。
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {

        HashMap<Integer, Integer> recodeMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (recodeMap.containsKey(nums[i])) {
                return nums[i];
            } else {
                recodeMap.put(nums[i], 1);
            }
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {

        int[] ints = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (ints[nums[i]] == 1) {
                return nums[i];
            } else {
                ints[nums[i]] = 1;
            }
        }
        return -1;
    }

    /**
     * 感觉有问题，但是在leetcode执行是对的，个人觉得第5个方法是对的
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber4(int[] nums) {

        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            //值和索引是否相等
            int value = nums[i];
            if (value == i) {
                continue;
            } else {
                if (value == nums[value]) {
                    return value;
                } else {
                    //把该值交换到其对应的索引位置下
                    int tem = nums[value];
                    nums[value] = value;
                    nums[i] = tem;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber5(int[] nums) {

        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            //值和索引是否相等
            while (nums[i] != i){
                int value = nums[i];

                if (value == nums[value]) {
                    return value;
                } else {
                    //把该值交换到其对应的索引位置下
                    int tem = nums[value];
                    nums[value] = value;
                    nums[i] = tem;
                }
            }
        }
        return -1;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,4,5,1,2]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int pre = numbers[0];
        for (int number : numbers) {
            if (number >= pre) {
                pre = number;
            } else {
                return number;
            }
        }
        return numbers[0];
    }

    /**
     * 自问：1.
     * <p>
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        Boolean isReturn = false;
        for (int i = 0; i < nums.length; i++) {
            if (isReturn) {
                break;
            }
            int num = nums[i];
            if (num % 2 == 0) {
                //如果是偶数则在之后的数据中查找奇数进行交换位置
                if (i + 1 < nums.length) {
                    for (int j = i + 1; j < nums.length; j++) {

                        if (nums[j] % 2 == 1) {
                            nums[i] = nums[j];
                            nums[j] = num;
                            break;
                        }
                        //时间优化：如果已经遍历到了数组尾部，则整体排列已完成
                        if (j == nums.length - 1) {
                            isReturn = true;
                        }
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 同上 从尾部开始替换
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        if (nums == null) {
            return null;
        }
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            //在前指针和后指针碰在一起的时候，整体排列完成
            if (i >= end) {
                break;
            }
            if (nums[i] % 2 == 0) {
                //从尾部开始查找奇数
                for (int j = end; j > i; j--) {
                    if (nums[j] % 2 == 1) {
                        //进行交换
                        int tem = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tem;
                        //一个新的end
                        end = j - 1;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        //对数组进行排序

        return -1;
    }

}
