public List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
    List<List<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
    List<TreeNode> currentLevel = new LinkedList<>();
    if (root != null) {
        currentLevel.add(root);
    }

    while (currentLevel.size() > 0) {
        result.add(currentLevel);
        List<TreeNode> parents = currentLevel;
        currentLevel = new LinkedList<>();
        for (TreeNode parent : parents) {
            if (parent.left != null) {
                currentLevel.add(parent.left);
            }
            if (parent.right != null) {
                currentLevel.add(parent.right);
            }
        }
    }

    return result;
}
