package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public String serialize(TreeNode root) {
        return serial(root, new StringBuilder()).toString();
    }

    private StringBuilder serial(TreeNode node, StringBuilder sb) {
        if(node==null) return sb.append("#");
        sb.append(node.val).append(",");
        serial(node.left, sb).append(",");
        serial(node.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<String>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserial(queue);
        node.right = deserial(queue);
        return node;
    }
}