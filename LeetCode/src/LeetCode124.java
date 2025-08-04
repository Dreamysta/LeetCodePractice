public class LeetCode124 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);

        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(priceNewPath,maxSum);

        return node.val + Math.max(leftGain,rightGain);

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LeetCode124 solution = new LeetCode124();
        int result = solution.maxPathSum(root);

        System.out.println("最大路径和为：\n" + result);
    }
}
