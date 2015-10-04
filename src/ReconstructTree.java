import java.util.HashMap;

public class ReconstructTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode reconstructTreeFromPreOrderInOrder(int [] preorder, int [] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i=0;i<inorder.length;i++) {
            indexMap.put(inorder[i], i);
        }
        return reconstructTreeFromPreOrderInOrderHelper(preorder, 0, preorder.length, 0, inorder.length, indexMap);

    }

    public TreeNode reconstructTreeFromPreOrderInOrderHelper(int [] preorder, int pre_start, int pre_end,
                                                             int in_start, int in_end, HashMap<Integer, Integer> inOrderIndexMap) {

        if (pre_end <= pre_start ||
            in_end <=  in_start   ) {
            return null;
        }

        int val = preorder[pre_start];


        int indexInInorder = inOrderIndexMap.get(val);

        int sizeOfLeftSubtree = indexInInorder - in_start;
        int sizeOfRightSubtree = in_end - indexInInorder;

        TreeNode root = new TreeNode(val,
                                     reconstructTreeFromPreOrderInOrderHelper(preorder, pre_start+1, pre_start + 1 + sizeOfLeftSubtree,
                                                       in_start, indexInInorder, inOrderIndexMap),
                                     reconstructTreeFromPreOrderInOrderHelper(preorder, pre_start + 1 + sizeOfLeftSubtree, pre_end,
                                                  indexInInorder + 1 , in_end, inOrderIndexMap));
        return root;
    }
}
