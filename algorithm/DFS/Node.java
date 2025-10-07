package algorithm.DFS;

import java.awt.Color;

public class Node<T extends Comparable<T>> {
    private T key;
    private Color color;
    private int discover;
    private int finish;
    private Node<T> parent;

    public Node() {

    }

    public Node(T key) {
        setkey(key);
    }

    public void setkey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setDiscover(int discover) {
        this.discover = discover;
    }

    public int getDiscover() {
        return discover;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getFinish() {
        return finish;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }
}
