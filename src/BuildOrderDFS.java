import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class BuildOrderDFS {
    enum State {VISITING, VISITED, UNVISITED};

    static class Node {

        public State state;
        public int name;
        public ArrayList<Node> children;
        public HashSet<Integer> childMap;

        public Node(int n) {
            name=n;
            state = State.UNVISITED;
            children = new ArrayList<Node>();
            childMap = new HashSet<Integer>();
        }

        public void addChild(Node n) {
            if (!childMap.contains(n.name)) {
                children.add(n);
            }
        }
    }

    public static int [] findOrder(int n, int [][] depends){
        int [] res = new int[n];

        HashMap<Integer, Node> nodesMap = new HashMap<Integer, Node>();

        for (int i=0;i<n;i++) {
            nodesMap.put(i, new Node(i));
        }

        for (int i = 0; i < depends.length; i++) {
            int child = depends[i][0];
            int parent = depends[i][1];

            nodesMap.get(parent).addChild(nodesMap.get(child));
        }

        Stack<Integer> stack = new Stack<Integer>();

        for (Node nd: nodesMap.values()) {
            if (nd.state == State.UNVISITED) {
                if (!DFS(nd, stack)) {
                    return new int [0];
                }
            }
        }

        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public static boolean DFS(Node a, Stack<Integer> stack) {
        a.state = State.VISITING;

        for (int i=0; i< a.children.size(); i++) {
            if (a.children.get(i).state == State.UNVISITED) {
                if (!DFS(a.children.get(i), stack)) {
                    return false;
                }
            } else if (a.children.get(i).state == State.VISITING) {
                return false;
            }
        }

        stack.push(a.name);
        a.state = State.VISITED;
        return true;
    }


    public static void main(String args []) {


        int [][] depends = {{1,0},
                            {2,0},
                            {3,1},
                            {2,1}};



        int [] res = findOrder(4, depends);

        print(res);

    }
    private static void print(int [] ints) {
        for (int i = 0; i<ints.length;i++) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println();

    }
}
