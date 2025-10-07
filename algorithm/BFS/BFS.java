package algorithm.BFS;

import java.util.LinkedList;
import java.awt.Color;

public class BFS {
    private LinkedList<Node<String>> queue = new LinkedList<Node<String>>();

    public BFS() {
        Graph<String> graph = generateGraph();
        computeBFS(graph, graph.getAdjNodes(new Node<String>("A"))[0]);
    }

    private Graph<String> generateGraph() {
        Graph<String> graph = new Graph<String>();
        Node<String> a = new Node<String>("A");
        Node<String> b = new Node<String>("B");
        Node<String> c = new Node<String>("C");
        Node<String> d = new Node<String>("D");
        Node<String> e = new Node<String>("E");
        Node<String> f = new Node<String>("F");
        Node<String> g = new Node<String>("G");
        Node<String> h = new Node<String>("H");
        Node<String> i = new Node<String>("I");

        graph.add(new Node[] { a, b, c, d });
        graph.add(new Node[] { b, a, e, f });
        graph.add(new Node[] { c, a, f });
        graph.add(new Node[] { d, a, g });
        graph.add(new Node[] { e, b, h });
        graph.add(new Node[] { f, b, c, h });
        graph.add(new Node[] { g, d });
        graph.add(new Node[] { h, e, f, i });
        graph.add(new Node[] { i, h });

        return graph;
    }

    private void computeBFS(Graph<String> graph, Node<String> startNode) {
        int conut = 1;
        for (Node<String> u : graph.getNode()) {
            if (!u.equals(startNode)) {
                u.setColor(Color.WHITE);
                u.setDistance(Integer.MAX_VALUE);
                u.setParent(null);
            }
        }
        startNode.setColor(Color.GRAY);
        startNode.setDistance(0);
        startNode.setParent(null);
        enQueue(startNode);
        while (!queue.isEmpty()) {
            System.out.println("-----" + conut + "-----");
            Node<String> u = deQueue();
            System.out.println("u 為: " + u.getKey() + " : " + u.getDistance());
            for (Node<String> v : graph.getAdjNodes(u)) {
                if (v.getColor() == Color.WHITE) {
                    v.setColor(Color.GRAY);
                    v.setDistance(u.getDistance() + 1);
                    v.setParent(u);
                    enQueue(v);
                }
            }
            System.out.print("Q = {");
            for (Node<String> n : queue) {
                System.out.print(n.getKey() + " : " + n.getDistance() + ", ");
            }
            System.out.println("}");    
            u.setColor(Color.BLACK);
            for (int i = 0; i < graph.getNode().length / 2; i++) {
                System.out.println(graph.getNode()[i].getKey() + " : " + strColor(graph.getNode()[i].getColor()));
            }
            System.out.println();
            for (int i = graph.getNode().length / 2; i < graph.getNode().length; i++) {
                System.out.println(graph.getNode()[i].getKey() + " : " + strColor(graph.getNode()[i].getColor()));
            }
            conut++;
            System.out.println("\n\n");
        }
        System.out.println("=========== BFS Result ===========");
        for (Node<String> n : graph.getNode()) {
            System.out.println("Node " + n.getKey() + ": color = " + strColor(n.getColor()) + ", distance = "
                    + n.getDistance() + ", parent = " + (n.getParent() != null ? n.getParent().getKey() : "null"));
        }
    }

    private Node<String> deQueue() {
        return queue.poll();
    }

    private void enQueue(Node<String> node) {
        queue.add(node);
    }

    private String strColor(Color color) {
        if (color == Color.WHITE) {
            return "WHITE";
        } else if (color == Color.GRAY) {
            return "GRAY";
        } else if (color == Color.BLACK) {
            return "BLACK";
        } else {
            return "NULL";
        }
    }

    public static void main(String[] args) {
        new BFS();
    }
}
