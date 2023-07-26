package main.algo2.trees.treearray;

public class aBST {
    public Integer[] Tree;

    public aBST(int depth)
    {
        int tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[ tree_size ];
        for (int i=0; i<tree_size; i++) {
            Tree[i] = null;
        }
    }

    public Integer FindKeyIndex(int key)
    {
        Integer findedKey = null;
        for (int i = 0; i < Tree.length; i = Tree[i] > key ? i * 2 + 1 : i * 2 + 2) {
            if (Tree[i] == null || Tree[i] == key) {
                findedKey = Tree[i] == null ? -i : i;
                break;
            }
        }
        return findedKey;
    }

    public int AddKey(int key)
    {
        Integer findedKey = FindKeyIndex(key);
        if (findedKey == null) {
            return -1;
        }
        if (findedKey < 0) {
            Tree[-findedKey] = key;
            return -findedKey;
        }
        if (findedKey > 0) {
            return findedKey;
        }
        if (Tree[1] == null && Tree[2] == null) {
            Tree[findedKey] = key;
        }
        return 0;
    }
}
