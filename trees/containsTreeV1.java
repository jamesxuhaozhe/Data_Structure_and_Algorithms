// Problem: You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
// Create an algorithm to decide if T2 is a subtree of T1.
// The folllwing is going to work if the numebr of the node is not insanely large

public static void inOrderTraverse(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("NULL");
        return;
    }

    inOrderTraverse(root.left, sb);

    sb.append(Integer.toString(root.value));

    inOrderTraverse(root.right, sb);
}

public static boolean containsTree(TreeNode t1, TreeNode t2) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    inOrderTraverse(t1, sb1);
    inOrderTraverse(t2, sb2);

    String rep1 = sb1.toString();
    String rep2 = sb2.toString();

    return rep1.contains(rep2);
}
