public boolean isValidBST(TreeNode root, int min, int max) {
    if (root == null) {
        return true;
    }

    if (root.value <= min || root.value > max) {
        return false;
    }

    if (!isValidBST(root.left, min, root.value) || !isValidBST(root.right, root.value, max)) {
        return false;
    }

    return true;
}
