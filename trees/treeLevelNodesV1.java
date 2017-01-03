// Given a binary tree, design an algorithm which creates a linked list of all the nodes at
// each depth(e.g., if you have a tree with depth D, you will have D linked list)

public void createLevelList(TreeNode root, List<List<TreeNode>> lists, int level) {
    if (root == null) {
        return;
    }

    List<TreeNode> curLevelList = null;
    if (lists.size() == level) {
        curLevelList = new LinkedList<>();
        lists.add(curLevelList);
    } else {
        curLevelList = lists.get(level);
    }
    curLevelList.add(root);
    createLevelList(root.left, lists, level + 1);
    createLevelList(root.right, lists, level + 1);
}

public List<List<TreeNode>> createLevelList(TreeNode root) {
    List<List<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
    createLevelList(root, lists, 0);
    return lists;
}

// this is a mod of pre-order traversal, where we pass level + 1 to the next recursive call. The code above provides an impl
// using dfs.
