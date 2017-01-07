public static boolean containsTree(TreeNode t1, TreeNode t2) {
    if (t2 == null) {
        // if t2 is empty, always return true, fore sure t1 contains t2, right?
        return true;
    }

    return isSubtree(t1, t2);
}

// This method return true if t2 is a subtree of t1 in terms of structure.
public static boolean isSubtree(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
        // if the big tree is null, then for sure t2 can not be part of t1
        return false;
    }

    if (t1.value == t2.value) {
        return isSameTree(t1, t2);
    }

    return isSubtree(t1.left, t2) || isSubtree(t2.right, t2);
}

// check if two trees are exactly the same.
public static boolean isSameTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
        return true;
    }

    if (t1 == null || t2 == null) {
        return false;
    }

    if (t1.value != t2.value) {
        return false;
    } else {
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
