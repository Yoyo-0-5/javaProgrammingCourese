package algorithm.DFS;

import java.awt.Color;

public class DFS {

    private int time;

    public DFS() {
        Graph<String> graph = createGraph();
        computeDFS(graph);
    }

    public void computeDFS(Graph<String> graph) {
        for (Node<String> node : graph.getNode()) {
            node.setColor(Color.WHITE);
            node.setParent(null);
        }
        time = 0;
        for (Node<String> node : graph.getNode()) {
            if (node.getColor() == Color.WHITE) {
                DFS_Visit(graph, node);
            }
        }
    }

    public void DFS_Visit(Graph<String> graph, Node<String> node) {
        time++;
        node.setDiscover(time);
        node.setColor(Color.GRAY);
        printNodes(graph);
        for (Node<String> child : graph.getAdjNodes(node)) {
            if (child.getColor() == Color.WHITE) {
                child.setParent(node);
                DFS_Visit(graph, child);
            }
        }
        printNodes(graph);
        node.setColor(Color.BLACK);
        time++;
        node.setFinish(time);
        printNodes(graph);
    }

    private void printNodes(Graph<String> graph) {
        System.out.println("\n\n--------------------------------------------------");
        for (Node<String> node : graph.getNode()) {
            System.out.println(node.getKey() + ":d = " + node.getDiscover() + "\tf = " + node.getFinish() + "\tcolor = " + strColor(node.getColor()));
        }
    }

    public Graph<String> createGraph() {
        Node<String> u = new Node<>("U");
        Node<String> v = new Node<>("V");
        Node<String> w = new Node<>("W");
        Node<String> x = new Node<>("X");
        Node<String> y = new Node<>("Y");
        Node<String> z = new Node<>("Z");

        Graph<String> graph = new Graph<>();
        graph.add(new Node[] {u, v, x});
        graph.add(new Node[] {v, y});
        graph.add(new Node[] {w, y, z});
        graph.add(new Node[] {x, v});
        graph.add(new Node[] {y, x});
        graph.add(new Node[] {z, z});
        return graph;
    }

    private String strColor(Color color) {
        if (color == Color.WHITE) {
            return "WHITE";
        }
        if (color == Color.GRAY) {
            return "GRAY";
        }
        if (color == Color.BLACK) {
            return "BLACK";
        }
        return null;
    }

    public static void main(String[] args) {
        new DFS();
    }
}
