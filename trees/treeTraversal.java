class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        TreeNode(value, null, null);
    }
}

public static void inOrderTraversal(TreeNode root) {
    if (root == null) {
        return;
    }

    inOrderTraversal(root.left);

    // visit or deal with current node.
    System.out.println(root.value);

    inOrderTraversal(root.right);
}

public static void preOrderTraversal(TreeNode root) {
    if (root == null) {
        return;
    }

    System.out.println(root.value);

    preOrderTraversal(root.left);

    preOrderTraversal(root.right);
}

public static void postOrderTraversal(TreeNode root) {
    if (root == null) {
        return;
    }

    postOrderTraversal(root.left);

    postOrderTraversal(root.right);

    System.out.println(root.value);
}
