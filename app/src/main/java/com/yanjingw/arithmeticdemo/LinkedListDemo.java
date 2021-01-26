package com.yanjingw.arithmeticdemo;

import com.yanjingw.arithmeticdemo.model.ListNode;

import java.util.Stack;

/**
 * 链表
 */
public class LinkedListDemo {


    /**
     * 剑指 Offer 24. 反转链表 --- 递归
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return reverseListIml(null, head);
    }

    private ListNode reverseListIml(ListNode newHead, ListNode oldHead) {
        if (oldHead == null) {
            return newHead;
        }
        ListNode tem = oldHead.next;
        oldHead.next = newHead;
        return reverseListIml(oldHead, tem);
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tem = head.next;
            head.next = newHead;
            newHead = head;
            head = tem;
        }
        return newHead;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode revertLinked(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode revertHead = revertLinked(head.next);
        head.next.next = head;
        //重点：没有致空这个逻辑，链尾会产生循环
        head.next = null;

        return revertHead;
    }


    /**
     * 合并两个有序链表 ok。
     *
     * @param node1
     * @param node2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 != null ? node1 : node2;
        }

        if (node1.val < node2.val) {
            ListNode tem = node1.next;
            node1.next = mergeTwoLists(tem, node2);
            return node1;
        } else {
            ListNode tem = node2.next;
            node2.next = mergeTwoLists(node1, tem);
            return node2;
        }
    }

    /**
     * 合并两个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    private static ListNode mergeTwoLists2(ListNode node1, ListNode node2) {

        ListNode newnode1 = node1;
        ListNode newnode2 = node2;

        ListNode start = null;
        ListNode nextNode = null;

        ListNode returnNode = null;
        while (true) {
            if (newnode1 == null || newnode2 == null) {
                nextNode = ((newnode1 != null) ? newnode1 : newnode2);
                newnode1 = null;
                newnode2 = null;
            } else {
                if (newnode1.val < newnode2.val) {
                    nextNode = newnode1;
                    newnode1 = newnode1.next;
                } else {
                    nextNode = newnode2;
                    newnode2 = newnode2.next;
                }
            }

            if (start == null) {
                returnNode = nextNode;
            } else {
                start.next = nextNode;
            }
            start = nextNode;

            if (newnode1 == null && newnode2 == null) {
                break;
            }
        }
        return returnNode;
    }

    /**
     * 合并两个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    private static ListNode mergeTwoLists3(ListNode node1, ListNode node2) {

        //哑节点
        ListNode start = new ListNode();
        start.val = -1;
        ListNode nextNode = start;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                nextNode.next = node1;
                node1 = node1.next;
            } else {
                nextNode.next = node2;
                node2 = node2.next;
            }
            nextNode = nextNode.next;
        }

        nextNode.next = node1 == null ? node2 : node1;

        return start.next;
    }


    /**
     * 求链表中倒数第k个结点
     */
    private static ListNode getKthFromEnd(ListNode node, int k) {
        if (k < 0) {
            return null;
        }

        ListNode newNode = node;

        int z = 0;
        while (newNode != null && z < k) {
            newNode = newNode.next;
            z++;
        }
        if (z < k) {
            return null;
        }
        while (newNode != null) {
            newNode = newNode.next;
            node = node.next;
        }

        return node;
    }

    /**
     * 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        //交换前两个节点
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;

        second.next = first;
        first.next = swapPairs(third);

        return second;
    }


    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        return reversePrintIml(head, 0);
    }

    /**
     * i是head的index
     *
     * @param head
     * @param i
     * @return
     */
    private int[] reversePrintIml(ListNode head, int i) {

        if (head == null) {
            return new int[i];
        }

        int[] ints = reversePrintIml(head.next, ++i);

        ints[ints.length - i] = head.val;

        return ints;
    }

    public int[] reversePrint2(ListNode head) {

        int i = 0;
        ListNode tem = head;
        while ((tem) != null) {
            i++;
            tem = tem.next;
        }
        int[] ints = new int[i];
        while (head != null) {
            ints[--i] = head.val;
            head = head.next;
        }
        return ints;
    }

    public int[] reversePrint3(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();
        while (head != null) {
            listNodes.push(head);
            head = head.next;
        }

        int i = 0;
        int[] ints = new int[listNodes.size()];
        while (!listNodes.empty()) {
            head = listNodes.pop();
            ints[i++] = head.val;
        }
        return ints;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tem = head;
        ListNode pre = null;
        while (tem != null) {
            if (tem.val == val) {
                //删除该节点
                if (pre == null) {
                    return tem.next;
                } else {
                    pre.next = tem.next;
                    return head;
                }
            }
            pre = tem;
            tem = tem.next;
        }

        return head;
    }

}
