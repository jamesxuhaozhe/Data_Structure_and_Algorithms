// You are given a binary tree in which each node contains a value. Design an algorithm to println
all paths which sum to a given value. The path does not need to start or end at the root.


public static void printPathSum(TreeNode root, int sum) {
    int depth = getDepth(root);
    int[] path = new int[depth];
    findSum(root, sum, path, 0);
}

public static void findSum(TreeNode root, int sum, int[] path, int level) {
    if (root == null) {
        return;
    }

    path[level] = root.value;
    int t = 0;
    for (int i = level; i >= 0; i--) {
        t += path[i];
        if (t == sum) {
            print(path, i, level);
        }
    }

    findSum(root.left, sum, path, level + 1);
    findSum(root.right, sum, path, level + 1);

    path[level] = Integer.MIN_VALUE;
}

public static void print(int[] path, int start, int end) {
    for (int i = start, i <= end; i++) {
        System.out.print(path[i] + " ");
    }
}

public static int getDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
}
