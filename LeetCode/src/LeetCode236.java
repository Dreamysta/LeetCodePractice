public class LeetCode236 {
    // 二叉树节点类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 主逻辑：递归查找最近公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }
    // 主函数：构造测试树并运行示例
    public static void main(String[] args) {
        // 构建二叉树
        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left.left;              // 节点5
        TreeNode q = root.right.right; // 节点4


        TreeNode lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("最近公共祖先是节点：" + lca.val);
        } else {
            System.out.println("未找到最近公共祖先");
        }
    }
}
