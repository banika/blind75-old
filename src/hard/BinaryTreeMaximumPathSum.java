package hard;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if(node==null) return 0;
        int left = Math.max(maxGain(node.left),0);
        int right = Math.max(maxGain(node.right),0);
        int newPath = left+right+node.val;
        maxSum = Math.max(maxSum, newPath);
        return Math.max(left, right)+node.val;
    }
}
