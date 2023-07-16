package main.binarysearchtrees;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок	

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T> {
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        BSTFind<T> rsl = new BSTFind<>();
        BSTNode<T> currentNode = this.Root;
        while (currentNode != null) {
            rsl.Node = currentNode;
            if (currentNode.NodeKey == key) {
                rsl.NodeHasKey = true;
                return rsl;
            }
            if (currentNode.NodeKey > key) {
                currentNode = currentNode.LeftChild;
                rsl.ToLeft = true;
                continue;
            }
            currentNode = currentNode.RightChild;
            rsl.ToLeft = false;
        }
        return rsl;
    }

    public boolean AddKeyValue(int key, T val) {
        if (this.Root == null) {
            this.Root = new BSTNode<>(key, val, null);
            return true;
        }
        BSTFind<T> bstFindResult = FindNodeByKey(key);
        if (bstFindResult.NodeHasKey) {
            return false;
        }
        BSTNode<T> newNode = new BSTNode<>(key, val, bstFindResult.Node);
        if (bstFindResult.ToLeft) {
            bstFindResult.Node.LeftChild = newNode;
            return true;
        }
        bstFindResult.Node.RightChild = newNode;
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        BSTNode<T> rsl = null;
        while (FromNode != null) {
            rsl = FromNode;
            FromNode = FindMax ? FromNode.RightChild : FromNode.LeftChild;
        }
        return rsl;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> deletedFindNode = FindNodeByKey(key);
        if (!deletedFindNode.NodeHasKey) {
            return false;
        }
        if (deletedFindNode.Node.RightChild == null && deletedFindNode.Node.LeftChild == null) {
            eraseNode(deletedFindNode.Node);
            return true;
        }
        if (deletedFindNode.Node.RightChild != null && deletedFindNode.Node.LeftChild != null) {
            BSTNode<T> leftFromRightNode = FinMinMax(deletedFindNode.Node.RightChild, false);
            deletedFindNode.Node.NodeKey = leftFromRightNode.NodeKey;
            deletedFindNode.Node.NodeValue = leftFromRightNode.NodeValue;
            if (leftFromRightNode.RightChild == null) {
                eraseNode(leftFromRightNode);
                return true;
            }
            breakAndLinkNodes(leftFromRightNode.RightChild, leftFromRightNode);
            return true;
        }
        BSTNode<T> node = deletedFindNode.Node.RightChild == null ?
                deletedFindNode.Node.LeftChild : deletedFindNode.Node.RightChild;
        breakAndLinkNodes(node, deletedFindNode.Node);
        return true;
    }

    private void eraseNode(BSTNode<T> node) {
        node.NodeValue = null;
        if (node.Parent == null) {
            this.Root = null;
            return;
        }
        if (node.Parent.NodeKey > node.NodeKey) {
            node.Parent.LeftChild = null;
        } else {
            node.Parent.RightChild = null;
        }
        node.Parent = null;
    }

    private void breakAndLinkNodes(BSTNode<T> downNode, BSTNode<T> intermediateNode) {
        if (intermediateNode == this.Root) {
            downNode.Parent = null;
            this.Root = downNode;
        } else {
            BSTNode<T> upNode = intermediateNode.Parent;
            downNode.Parent = upNode;
            if (upNode.NodeKey > downNode.NodeKey) {
                upNode.LeftChild = downNode;
            } else {
                upNode.RightChild = downNode;
            }
        }
        intermediateNode.NodeValue = null;
        intermediateNode.Parent = null;
        intermediateNode.RightChild = null;
        intermediateNode.LeftChild = null;
    }

    public int Count() {
        AtomicInteger count = new AtomicInteger(0);
        treeTraversal(this.Root, e -> count.incrementAndGet());
        return count.get();
    }

    private void treeTraversal(BSTNode<T> currentNode, Consumer<BSTNode<T>> action) {
        if (currentNode != null) {
            action.accept(currentNode);
            treeTraversal(currentNode.LeftChild, action);
            treeTraversal(currentNode.RightChild, action);
        }
    }
}