package algorithm.BFS;
import java.awt.Color;

public class Node <T extends Comparable<T>> {
    private T key;
    private Color color;
    private int distance;
    private Node<T> parent;

    public Node(){
        
    }

    public Node(T key){
        setKey(key);
    }

    public void setKey(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return this.distance;
    }

    public void setParent(Node<T> parent){
        this.parent = parent;
    }

    public Node<T> getParent(){
        return this.parent;
    }

}
