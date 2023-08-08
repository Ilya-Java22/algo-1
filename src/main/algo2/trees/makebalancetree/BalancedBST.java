package main.algo2.trees.makebalancetree;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root; // корень дерева

    public BalancedBST()
    {
        Root = null;
    }


    public void GenerateTree(int[] a)
    {
        if (this.Root == null) {
            Arrays.sort(a);
            divideAndConquer(this.Root, a, 0, a.length - 1, 0);
        }
    }

    private BSTNode divideAndConquer(BSTNode bstNode, int[] a, int from, int to, int level) {
        if (to < from) {
            return null;
        }
        int mid = (from + to) / 2;
        BSTNode newBstNode = new BSTNode(a[mid], bstNode);
        if (bstNode == null) {
            this.Root = newBstNode;
        }
        newBstNode.Level = level;
        level++;
        newBstNode.LeftChild = divideAndConquer(newBstNode, a, from, mid - 1, level);
        newBstNode.RightChild = divideAndConquer(newBstNode, a, mid + 1, to, level);
        return newBstNode;
    }

        public boolean IsBalanced(BSTNode root_node)
        {
            AtomicBoolean isBalancedTree = new AtomicBoolean(true);
            calcTreeHeight(root_node, isBalancedTree);
            return isBalancedTree.get();
        }

        private int calcTreeHeight(BSTNode root_node, AtomicBoolean isBalancedTree) {
            if (root_node == null || !isBalancedTree.get()) {
                return 0;
            }
            int left_height = calcTreeHeight(root_node.LeftChild, isBalancedTree);
            int right_height = calcTreeHeight(root_node.RightChild, isBalancedTree);
            if (Math.abs(left_height - right_height) > 1) {
                isBalancedTree.set(false);
            }
            return Math.max(left_height, right_height) + 1;
        }
}