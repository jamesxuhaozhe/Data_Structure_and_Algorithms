// Design an algorithm and write code to find the first common ancestor of two nodes
// in a binary tree. Avoid storing additional nodes in a data structure. Note: This is not necessarily a binary search tree

// solution: for a particular node, if p, q are on the left side of the node, then we have to branch left to find the first common ancestor
// if p, q are on the right side of the node, then we have to branch right to find the first common ancestor,
// if p, q are no longer on the same side, then the particualr node is the one we are looking for

// returns if root covers node q, that is, if q is the descendent of the root
public static boolean covers(TreeNode root, TreeNode q) {
    if (root == null) {
        return false;
    }

    if (root == q) {
        return true;
    }

    return covers(root.left, q) || covers(root.right, q);
}

public static TreeNode firstCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
        return root;
    }

    if (root == q || root == p) {
        return root;
    }

    boolean is_p_on_left = covers(root.left, p);
    boolean is_q_on_left = covers(root.left, q);

    if (is_p_on_left != is_q_on_left) {
        return root;
    }

    TreeNode nodeToSearch = is_p_on_left ? root.left : root.right;

    return firstCommonAncestorHelper(nodeToSearch, p, q);
}

public static TreeNode mainFind(TreeNode root, TreeNode p, TreeNode q) {
    if (!covers(root, p) || !covers(root, q)) {
        return null;
    }

    return firstCommonAncestorHelper(root, p, q);
}
