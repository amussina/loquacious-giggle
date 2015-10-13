public class BinaryTreeUpsideDown {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode [] NRRef = new TreeNode[1];
        traversePreRightOrder(root, NRRef);
        return NRRef[0];
    }

    private static TreeNode traversePreRightOrder(TreeNode root, TreeNode [] NRRef) {


        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            NRRef[0] = root;
            return root;
        }

        if (root.left != null) {

            TreeNode right = root.right;

            TreeNode NR = traversePreRightOrder(root.left, NRRef);
            NR.left = right;
            NR.right = root;
            root.left=null;
            root.right=null;
            return NR.right;
        } else {
            return root;
        }

    }

    public static void main(String [] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);


        treeNode.left=treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;

        TreeNode root = upsideDownBinaryTree(treeNode);
        System.out.print(root.val);
//        System.out.print(root.right.val);
//        System.out.print(root.left.val);
    }
}
