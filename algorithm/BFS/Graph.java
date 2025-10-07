package algorithm.BFS;

import java.util.LinkedList;

public class Graph <T extends Comparable<T>> {
    private LinkedList<Node<T>[]> graph = new LinkedList<Node<T>[]>();

    public Graph() {
    }

    public Graph(Node<T>[] nodes) {
        add(nodes);
    }

    public void add(Node<T>[] nodes) {
        graph.add(nodes);
    }

    public Node<T>[] getAdjNodes(Node<T> node) {
        
        for(Node<T>[] n : graph) {
            if(n[0].getKey().compareTo(node.getKey()) == 0) {
                return n;
            }
        }
        return null;
    }

    public Node<T>[] getNode() {
        Node<T>[] nodes = new Node[graph.size()];
        for(int i = 0; i < graph.size(); i++) {
            nodes[i] = graph.get(i)[0];
        }
        return nodes;
    }
}
