package com.yanjingw.arithmeticdemo;

import com.yanjingw.arithmeticdemo.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树算法
 */
public class TreeSimpleArith {

    //⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇二叉树的反转⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇

    /**
     * 二叉树的反转 非递归，用栈实现 keep
     *
     * @param root
     */
    public static void flipTreeByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 二叉树的反转 递归 keep
     *
     * @param root
     * @return
     */
    public static TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = flipTree(root.left);
        root.right = flipTree(root.right);
        swap(root);
        return root;
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆二叉树的反转⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆

    //⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇二叉树的遍历⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇
    List<Integer> treeList = new ArrayList();

    //------------------------------------------第一种方式-递归----------------------------------------------

    /**
     * 二叉树的前序遍历（中左右）-递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        treeList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return treeList;
    }

    /**
     * 二叉树的中序遍历（左右中）-递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        inorderTraversal(root.left);
        treeList.add(root.val);
        inorderTraversal(root.right);

        return treeList;
    }

    /**
     * 二叉树的后序遍历（左右中）-递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        treeList.add(root.val);

        return treeList;
    }
    //------------------------------------------第一种方式-递归----------------------------------------------

    //------------------------------------------第二种方式-栈----------------------------------------------

    /**
     * 二叉树的前序遍历-栈
     * * 验证通过
     */
    public List<Integer> preorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return treeList;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            treeList.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return treeList;
    }


    /**
     * 二叉树的中序遍历-栈
     * * 验证通过
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return treeList;
        }

        Stack<TreeNode> stack = new Stack();

        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            treeList.add(pop.val);
            root = pop.right;
        }

        return treeList;
    }

    /**
     * 二叉树的后序遍历-栈
     * <p>
     * 验证通过
     */
    public List<Integer> postorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return treeList;
        }

        Stack<TreeNode> stack = new Stack();

        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop);
                root = pop.right;
                pop.right = null;
            } else {
                treeList.add(pop.val);
            }
        }

        return treeList;
    }

    //------------------------------------------第三种方式-栈----------------------------------------------

    /**
     * 二叉树的前序遍历-栈
     */
    public List<Integer> preorderTraversalByStack2(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.empty()) {
            if (root != null) {
                treeList.add(root.val);//步骤一，取根节点的值
                stack.push(root);//把根节点放入栈中
                root = root.left;//步骤二，遍历左子树
            } else {
                TreeNode tem = stack.pop();
                root = tem.right;//步骤三，遍历右子树
            }
        }
        return treeList;
    }

    /**
     * 二叉树的中序遍历-栈。
     * 验证通过。
     */
    public List<Integer> inorderTraversalByStack2(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tem = stack.pop();
                treeList.add(tem.val);
                root = tem.right;
            }
        }
        return treeList;
    }


    /**
     * 二叉树的后序遍历-栈。
     * 验证通过
     */
    public List<Integer> postorderTraversalByStack2(TreeNode root) {
        if (root == null) {
            return treeList;
        }
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.empty()) {
            if (root != null) {
                treeList.add(0, root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode tem = stack.pop();
                root = tem.left;
            }
        }
        return treeList;
    }


    //⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆二叉树的遍历⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆


}
