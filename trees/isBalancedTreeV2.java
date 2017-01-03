public static int checkHeight(TreeNode root) {
    if (root == null) {
        return 0;
    }

    // lets take a look at the left subtree
    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) {
        return -1;
    }

    // lets take a look at the right subtree
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) {
        return -1;
    }

    // if left subtree and right subtree are all healthy, then lets take a look at their diff
    if (Math.abs(rightHeight - leftHeight) > 1) {
        return -1;
    } else {
        // don't foget to plus one since the current level should be counted
        return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
    }
}

public static boolean isBalanced(TreeNode root) {
    if (checkHeight(root) == -1) {
        return false;
    } else {
        return true;
    }
}
