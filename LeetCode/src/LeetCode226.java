import java.util.*;

// 定义二叉树节点
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
    
}

public class LeetCode226 {

    // 翻转二叉树函数（递归）
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // 层序遍历打印二叉树
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("Level Order: ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    // 构建示例树 [4,2,7,1,3,6,9]
    public static TreeNode buildTestTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        return root;
    }

    // 主程序入口
    public static void main(String[] args) {
        TreeNode root = buildTestTree();

        System.out.println("Before Invert:");
        printLevelOrder(root);

        invertTree(root);

        System.out.println("After Invert:");
        printLevelOrder(root);
    }
}
