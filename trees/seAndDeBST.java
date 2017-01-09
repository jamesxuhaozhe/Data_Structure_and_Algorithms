// The problem is to serialize and deserialize a BST, the solution is to pre order traversal and
// build a BST from a pre order string representation.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String SEP = ":";

    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(Integer.toString(node.val)).append(SEP);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals(NULL)) {
            return null;
        }

        String[] strs = data.split(SEP);
        Queue<Integer> que = new LinkedList<>();
        for (String str : strs) {
            que.offer(Integer.parseInt(str));
        }

        return buildBSTFromQue(que);
    }

    private TreeNode buildBSTFromQue(Queue<Integer> que) {
        if (que.isEmpty()) {
            return null;
        }

        TreeNode node = new TreeNode(que.poll());

        Queue<Integer> leftQue = new LinkedList<>();

        while (!que.isEmpty() && que.peek() < node.val) {
            leftQue.offer(que.poll());
        }

        node.left = buildBSTFromQue(leftQue);
        node.right = buildBSTFromQue(que);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
