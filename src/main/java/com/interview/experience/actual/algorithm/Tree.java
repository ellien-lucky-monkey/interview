package com.interview.experience.actual.algorithm;

/**
 * @author Jiangkui
 * @since 2019/12/18 14:48
 */
public class Tree {


    /**
     * 根节点
     * 双亲节点
     * 子节点
     * 路径
     * 节点的度
     * 节点的权 【节点的值】
     * 叶子节点 【没有子节点】
     * 子树
     * 层
     * 树的高度  【最大层数】 度和层都是从0开始 根节点为第0层
     * 森林
     *
     */


    /**
     * 二叉树 【任何一个节点的子节点不超过两个】
     * 满二叉树【所有叶子节点都在最后一层，而且节点的总数为2^n-1 n为树的高度】
     * 完全二叉树【所有叶子节点只能在最后一层或者倒数第二次 最后一层叶子节点在左边连续、倒数第二层的叶子节点在右边连续】
     * <p>
     * <p>
     * 存储结构  链式存储 | 顺序存储
     */


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node2.parent = node1;

        node4.parent = node2;
        node5.parent = node2;


        node3.left = node6;
        node3.right = node7;
        node3.parent = node1;

        node6.parent = node3;
        node7.parent = node3;


        frontShow(node1);
        System.out.println(" ======================");
        middleShow(node1);
        System.out.println(" ======================");
        backShow(node1);

    }

    //前序遍历
    public static void frontShow(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode p = treeNode;
        System.out.println(p.value);
        TreeNode left = p.getLeft();
        TreeNode right = p.getRight();
        frontShow(left);
        frontShow(right);

    }

    //中序遍历
    public static void middleShow(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode p = treeNode;
        TreeNode left = p.getLeft();
        if (left != null) {
            middleShow(left);
        }
        System.out.println(p.value);
        TreeNode right = p.getRight();
        if (right != null) {
            middleShow(right);
        }
    }

    //后续遍历
    public static void backShow(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode p = treeNode;
        TreeNode left = p.getLeft();
        if (left != null) {
            backShow(left);
        }
        TreeNode right = p.getRight();
        if (right != null) {
            backShow(right);
        }
        System.out.println(p.value);

    }


    /**
     * 树的遍历
     */
    static final class TreeNode {

        TreeNode parent;
        TreeNode left;
        TreeNode right;
        int value;


        final TreeNode root() {
            for (TreeNode r = this, p; ; ) {
                if ((p = r.parent) == null) {
                    return p;
                }
                r = p;
            }
        }


        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
