import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
    static class Graph {
        Set<Character> alphabet;
        Map<Character, Node> nodesMap;
        List<Node> nodes;

        public Graph() {
            alphabet = new HashSet<Character>();
            nodesMap = new HashMap<Character, Node>();
            nodes = new LinkedList<Node>();
        }

        public void addVertex(Character a) {
            alphabet.add(a);

            if (!nodesMap.containsKey(a)) {
                nodesMap.put(a, new Node(a));
            }
        }

        public void addEdge(Character a, Character b) {
            addVertex(a);
            addVertex(b);
            Node aNode = nodesMap.get(a);
            Node bNode = nodesMap.get(b);
            aNode.addChild(bNode);
        }

        public static Graph buildGraph(String [] strs) {
            Graph g = new Graph();
            for (String s: strs) {
                int len = s.length();
                if (len == 1) {
                    g.addVertex(s.charAt(0));
                } else if (len >=2) {
                    for (int i = 0; i < len - 1; i++) {
                        Character a = s.charAt(i);
                        Character b = s.charAt(i+1);
                        if (!a.equals(b))
                            g.addEdge(a,b);
                    }

                }
            }
            return g;
        }

        public List<Node> getNodes() {
            if (nodes.size() !=0 ) {
                return nodes;
            }
            for (Character a: alphabet) {
                if (nodesMap.containsKey(a)) {
                    nodes.add(nodesMap.get(a));
                } else {
                    nodes.add(new Node(a));
                }
            }
            return nodes;
        }

        public void initStateMap(Map<Node,State> stateMap) {
            List<Node> nodes = getNodes();

            for (Node n: nodes) {
                stateMap.put(n, State.UNVISITED);
            }
        }

    }

    static class Node {
        public Character val;
        public List<Node> children;


        public Node(char val) {
            this.val = val;
            this.children = new LinkedList<Node>();
        }

        public void addChild(Node ch) {
            children.add(ch);
        }

        public List<Node> getChildren() {
            return children;
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
                     + (val-'a');
            return result;
        }

    }

    enum State {UNVISITED, VISITING, VISITED};

    public static String alienOrder(String[] words) {
        Graph g = Graph.buildGraph(words);
        Map<Node, State> stateMap = new HashMap<Node, State>();
        g.initStateMap(stateMap);

        List<Node> nodes = g.getNodes();
        Stack<Character> stack = new Stack<Character>();

        for (Node n: nodes) {
            if (stateMap.get(n) == State.UNVISITED) {
                try {
                    dfs(n, stateMap, stack);

                } catch (RuntimeException e) {
                    return "";
                }
            }
        }

        String res = reverseStack(stack);
        return res;
    }

    public static void dfs (Node n, Map<Node, State> stateMap, Stack<Character> stack) {

        stateMap.put(n, State.VISITING);

        for (Node ch: n.getChildren()) {
            if (stateMap.get(ch) == State.UNVISITED) {
                dfs(ch, stateMap, stack);
            } else if (stateMap.get(ch) == State.VISITING) {
                throw new RuntimeException("cycle!");
            }
        }

        stateMap.put(n, State.VISITED);
        stack.add(n.val);
    }

    public static String reverseStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = (char)stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        String [] words = { "ace","df","bcd","def","fg"};

        String res = alienOrder(words);
        System.out.print(res);
        System.out.print(res.length());
    }
}
