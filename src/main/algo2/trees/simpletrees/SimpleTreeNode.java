package main.algo2.trees.simpletrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root;
    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;

    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        NodeToDelete.Parent.Children.remove(NodeToDelete);
        LinkedList<SimpleTreeNode<T>> tempList = new LinkedList<>();
        treeTraversal(NodeToDelete, e -> true, tempList::add);
        while (!tempList.isEmpty()) {
            SimpleTreeNode<T> currentNode = tempList.pollLast();
            if (currentNode.Children != null) {
                currentNode.Children.clear();
                currentNode.Children = null;
            }
            NodeToDelete.NodeValue = null;
            NodeToDelete.Parent = null;
            }
    }

    private void treeTraversal(SimpleTreeNode<T> t, Predicate<SimpleTreeNode<T>> p, Consumer<SimpleTreeNode<T>> c) {
        if (p.test(t)) {
            c.accept(t);
        }
        if (t.Children != null && !t.Children.isEmpty()) {
            for (SimpleTreeNode<T> el : t.Children) {
                treeTraversal(el, p, c);
            }
        }
    }

    private void treeTraversal2(SimpleTreeNode<T> t, Predicate<SimpleTreeNode<T>> p, Consumer<SimpleTreeNode<T>> c) {
        if (p.test(t)) {
            c.accept(t);
            for (SimpleTreeNode<T> el : t.Children) {
                treeTraversal(el, p, c);
            }
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        List<SimpleTreeNode<T>> rsl = new LinkedList<>();
        if (this.Root != null) {
            treeTraversal(this.Root, e -> true, rsl::add);
            return rsl;
        }
        return rsl;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode<T>> rsl = new LinkedList<>();
        if (this.Root != null) {
            treeTraversal(this.Root, e -> e.NodeValue.equals(val), rsl::add);
            return rsl;
        }
        return rsl;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        if (NewParent.Children == null) {
            NewParent.Children = new ArrayList<>();
        }
        NewParent.Children.add(OriginalNode);
        OriginalNode.Parent.Children.remove(OriginalNode);
        OriginalNode.Parent = NewParent;
    }

    public int Count()
    {
        if (this.Root == null) {
            return 0;
        }
        if (this.Root.Children == null || this.Root.Children.isEmpty()) {
            return 1;
        }
        AtomicInteger count = new AtomicInteger(0);
        treeTraversal(this.Root, e -> true, e -> count.incrementAndGet());
        return count.get();
    }

    public int LeafCount()
    {
        if (this.Root == null) {
            return 0;
        }
        if (this.Root.Children == null || this.Root.Children.isEmpty()) {
            return 1;
        }
        AtomicInteger count = new AtomicInteger(0);
        treeTraversal(this.Root, e -> e.Children == null || e.Children.isEmpty(), e -> count.incrementAndGet());
        return count.get();
    }

    public ArrayList<T> EvenTrees()
    {
        ArrayList<T> resultList = new ArrayList<>();
            treeTraversal2(this.Root, e -> new SimpleTree<T>(e).Count() % 2 == 0, e -> {
                if (e != this.Root) {
                    resultList.add(e.Parent.NodeValue);
                    resultList.add(e.NodeValue);
                }
            });
        return resultList;
    }
}
