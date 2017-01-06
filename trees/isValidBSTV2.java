private static int lastValue = Integer.MIN_VALUE;


public static boolean checkBST(TreeNode root) {
    if (root == null) {
        return true;
    }

    if (!checkBST(root.left)) {
        return false;
    }

    if (root.value <= lastValue) {
        return false;
    }
    lastValue = root.value;

    if (!checkBST(root.right)) {
        return false;
    }

    // if nothing happens then it means all good, then it is a valid BST
    return true;
}

public static boolean isValidBST(TreeNode root) {
    if (!isValidBST(root)) {
        return false;
    }
    return true;
}
