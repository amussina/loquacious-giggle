/*
*
* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
* write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

*
* */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ValidTree {

    public static HashMap<Integer, Node>  nodesMap = new HashMap<Integer, Node>();

    public static class Node {
        public int val;
        List<Node> adjacentList;

        public Node(int v) {
            val = v;
            adjacentList = new LinkedList<Node>();
        }

        public void addAdj(Node adj) {
            adjacentList.add(adj);
        }

        public List<Node> getAdjacent() {
            return adjacentList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;

            if (this.val != node.val) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                     + val;
            return result;
        }
    }

    private static Node getNode(int a) {
        if (!nodesMap.containsKey(a) ) {
            Node n = new Node(a);
            nodesMap.put(a, n);
        }

        return nodesMap.get(a);
    }

    public static boolean validTree(int n, int[][] edges) {
        if (edges == null ) {
            return false;
        }

        if (n == 1 && edges.length ==0) {
            return true;
        } else if (n > 1 && edges.length < n - 1) {
            return false;
        }

        int E = edges.length;

        for (int e = 0; e < E; e++) {
            int e1 = edges[e][0];
            int e2 = edges[e][1];

            Node n1 = getNode(e1);
            Node n2 = getNode(e2);

            n1.addAdj(n2);
            n2.addAdj(n1);
        }

        return !dfsCheckCyclesOrMultipleTrees();

    }

    public enum State {UNVISITED, VISITING, VISITED};

    private static boolean dfsCheckCyclesOrMultipleTrees() {
        HashMap<Node, State> stateMap = new HashMap<Node, State>();
        HashMap<Node, Node> parentMap = new HashMap<Node, Node>();

        for (Node n : nodesMap.values()) {
            stateMap.put(n, State.UNVISITED);
        }

        int countTrees = 0;

        for (Node n : nodesMap.values()) {
            if (stateMap.get(n) == State.UNVISITED) {
                countTrees++;
                if (dfsCheckCyclesHelper(n, stateMap, parentMap)) {
                    return true;
                };
            }
        }

        return countTrees > 1;
    }

    private static boolean dfsCheckCyclesHelper(Node n, HashMap<Node, State> stateMap, HashMap<Node, Node> parentMap) {
        stateMap.put(n, State.VISITING);

        List<Node> adjacent = n.getAdjacent();

        for (Node adj: adjacent) {

            if (!adj.equals(parentMap.get(n))) {
                State state = stateMap.get(adj);

                if (state == State.UNVISITED) {
                    parentMap.put(adj, n);
                    if (dfsCheckCyclesHelper(adj, stateMap, parentMap)) {
                        return true;
                    }
                } else if (state == State.VISITING){
                    return true;
                }
            }
        }

        stateMap.put(n, State.VISITED);

        return false;
    }

    public static void main(String [] args) {
        int n = 1;
        int [][] edges = { {0,1}, {2,3}, {1,2}};

        boolean isTree = validTree(n ,edges);

        System.out.print(isTree);
    }

}
