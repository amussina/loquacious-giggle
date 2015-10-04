import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPounterInTree {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
    public class Solution {

        public  class TreeLinkNode {
            public TreeLinkNode left;
            public TreeLinkNode right;
            public TreeLinkNode next;
        }

        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeLinkNode> Q = new LinkedList<TreeLinkNode>();

            Q.add(root);

            while(!Q.isEmpty()) {

                int size = Q.size();
                TreeLinkNode prevNode = null;

                while (size > 0) {

                    TreeLinkNode node = Q.poll();

                    if (prevNode != null) {
                        prevNode.next = node;
                    }
                    node.next = null;
                    prevNode = node;

                    if (node.left !=null) {
                        Q.add(node.left);
                    }
                    if (node.right != null) {
                        Q.add(node.right);
                    }

                    size--;
                }

            }
        }
    }
}
