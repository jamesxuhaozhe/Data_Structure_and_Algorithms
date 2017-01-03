// Problem Given a sorted(increasing order) array with unique integer elements,
// write an algorithm to craete a binary search tree with minimal height.

public static TreeNode createMinimalBST(int[] arr, int start, int end) {
    if (start > end) {
        return null;
    }

    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = createMinimalBST(arr, start, mid - 1);
    node.right = createMinimalBST(arr, mid + 1, end);
    return node;
}

public static TreeNode createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length - 1);
}

// To create a tree of minimal height, we need to match the number of nodes, in the left
// subtree to the number of nodes in the right subtree as much as possible. This means that we want
// the root to be the minimal of the array, since this would mean that half the elements would be less than
// the root and half would be greater than it. 
