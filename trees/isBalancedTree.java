public static int getHeight(TreeNode root) {
    if (root == null) {
        return 0;
    }
    // you need to plus since current level shoule be counted
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

public static boolean isBalanced(TreeNode root) {
    // base case,
    if (root == null) {
        return true;
    }

    int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
    if (heightDiff > 1) {
        return false;
    } else {
        // recurse
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
