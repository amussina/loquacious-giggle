import java.util.HashMap;

public class ReconstructTreeV2 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inOrderIndexMap = new HashMap<Integer, Integer>();

        for (int i =0;i< inorder.length;i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(inOrderIndexMap, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTreeHelper(HashMap<Integer, Integer> inorderIndexMap, int inStart, int inEnd,
                                    int [] postorder, int postStart, int postEnd) {

        if (postEnd <= postStart ||
                inEnd <= inStart) {
            return null;
        }

        int val = postorder[postEnd - 1];

        int inOrderIndex = inorderIndexMap.get(val);
        int leftTreeSize = inOrderIndex - inStart;

        int rightTreeSize = inEnd - inOrderIndex - 1;

        TreeNode root = new TreeNode(val);

        root.left = buildTreeHelper(
                inorderIndexMap, inStart, inOrderIndex,
                postorder, postStart, postStart + leftTreeSize);
        root.right
                = buildTreeHelper(inorderIndexMap, inOrderIndex + 1, inEnd,
                                  postorder, postStart + leftTreeSize, postEnd - 1);
        return root;

    }


}
