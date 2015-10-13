import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    static class ListNodeIndex {
        public ListNode node;
        public int index;
        public ListNodeIndex(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) {
            return null;
        }

        int k = lists.length;
        if (k == 1) {
            return lists[0];
        }

        PriorityQueue<ListNodeIndex> PQ = new PriorityQueue<ListNodeIndex>(k, new Comparator<ListNodeIndex>() {
            @Override
            public int compare(final ListNodeIndex o1, final ListNodeIndex o2) {
                ListNode n1 = o1.node;
                ListNode n2 = o2.node;
                return n1.val - n2.val;
            }
        });

        ListNode firstStub = new ListNode(0);
        ListNode prev = null;

        for (int i=0; i < k; i++) {
            ListNode node = lists[i];

            if (node != null) {
                PQ.add(new ListNodeIndex(node, i));
                lists[i] = node.next;
                node.next = null;
            }
        }

        while (!PQ.isEmpty()) {
            ListNodeIndex curListNodeIndex = PQ.poll();

            ListNode curNode = curListNodeIndex.node;
            int index = curListNodeIndex.index;

            if (lists[index] != null) {
                ListNode nextNode = lists[index];
                PQ.add(new ListNodeIndex(nextNode, index));
                lists[index] = nextNode.next;
                nextNode.next = null;
            }

            if (prev == null) {
                firstStub.next = curNode;
            } else {
                prev.next = curNode;
            }
            prev = curNode;
        }

        return firstStub.next;
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node  = node.next;
        }
    }

    public static void main (String [] args) {
        ListNode L10 = new ListNode(3);
        ListNode L11 = new ListNode(4);
        ListNode L12 = new ListNode(5);
        ListNode L2 = new ListNode(1);
        ListNode L30 = new ListNode(2);
        ListNode L31 = new ListNode(2);
        ListNode L32 = new ListNode(10);

        L10.next = L11;
        L11.next = L12;

        L30.next = L31;
        L31.next = L32;

        ListNode [] lists = {L10, L2, L30};

        ListNode res = mergeKLists(lists);
        print(res);
    }
}
