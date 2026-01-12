package prac;
import java.util.*;

/**
 * 通用二叉树节点 + 常用工具方法
 * 适用于大多数算法题（LeetCode/牛客/剑指 Offer 风格）
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // =========================
    // 构建 / 序列化（层序）
    // =========================

    /**
     * 从层序数组构建二叉树。
     * 输入：Integer[]（允许 null）
     * 输出：TreeNode root
     *
     * 例：{1, null, 2, 3} 表示：
     *   1
     *    \
     *     2
     *    /
     *   3
     */
    public static TreeNode fromLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();

            // left
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;

            // right
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    /**
     * 将二叉树序列化为层序数组（末尾多余 null 会裁剪）。
     * 输入：TreeNode root
     * 输出：Integer[]（允许 null）
     */
    public static Integer[] toLevelOrder(TreeNode root) {
        if (root == null) return new Integer[0];

        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                out.add(null);
                continue;
            }
            out.add(cur.val);
            q.offer(cur.left);
            q.offer(cur.right);
        }

        // 裁剪末尾多余 null
        int last = out.size() - 1;
        while (last >= 0 && out.get(last) == null) last--;
        out = out.subList(0, last + 1);

        return out.toArray(new Integer[0]);
    }

    /**
     * 友好打印：层序格式。
     */
    public static String toStringLevelOrder(TreeNode root) {
        return Arrays.toString(toLevelOrder(root));
    }

    // =========================
    // 常用遍历
    // =========================

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderDfs(root, res);
        return res;
    }

    private static void preorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorderDfs(node.left, res);
        preorderDfs(node.right, res);
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderDfs(root, res);
        return res;
    }

    private static void inorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderDfs(node.left, res);
        res.add(node.val);
        inorderDfs(node.right, res);
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderDfs(root, res);
        return res;
    }

    private static void postorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorderDfs(node.left, res);
        postorderDfs(node.right, res);
        res.add(node.val);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    // =========================
    // 常用属性 / 辅助
    // =========================

    /** 节点数 */
    public static int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    /** 树高（空树为 0，单节点为 1） */
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /** 是否相同树（结构和值都相同） */
    public static boolean equalsTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return equalsTree(a.left, b.left) && equalsTree(a.right, b.right);
    }

    // =========================
    // 示例自测
    // =========================
    public static void main(String[] args) {
        TreeNode root = TreeNode.fromLevelOrder(new Integer[]{3, 4, 5, 1, 2});
        System.out.println("level: " + TreeNode.toStringLevelOrder(root));
        System.out.println("pre: " + TreeNode.preorder(root));
        System.out.println("in: " + TreeNode.inorder(root));
        System.out.println("post: " + TreeNode.postorder(root));
        System.out.println("levels: " + TreeNode.levelOrder(root));
        System.out.println("size: " + TreeNode.size(root));
        System.out.println("height: " + TreeNode.height(root));
    }
}
