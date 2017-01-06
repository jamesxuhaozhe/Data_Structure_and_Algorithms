// Problem: Implement a function to check if the given binary tree is valid BST.
// the following algorithms is going to work only if there be no duplicates in the binary tree.
public static void processTreeNode(TreeNode root, List<Integer> list) {
    if (root == null) {
        return;
    }

    processTreeNode(root.left, list);

    list.add(root.value);

    processTreeNode(root.right, list);
}

public static boolean isValidBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    processTreeNode(root, list);
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) <= list.get(i - 1)) {
            return false;
        }
    }
    return true;
}
