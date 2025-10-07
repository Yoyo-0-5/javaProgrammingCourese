package algorithm;

public class BinarySearchTree {
    Node root = null;

    public void insert(int data)
    {
        System.out.println("Insert " + data);
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node node, int data)
    {
        if (node == null)
        {
            return new Node(data);
        }
        if (data < node.data)
        {
            node.left = insertHelper(node.left, data);
        }
        else if (data > node.data)
        {
            node.right = insertHelper(node.right, data);
        }
        return node;
    }

    public void print()
    {
        System.out.println("Binary Search Tree:");
        printHelper(root);
    }
    
    private void printHelper(Node node)
    {
        if (node != null)
        {
            printHelper(node.left);
            System.out.print(" -> " + node.data);
            printHelper(node.right);
        }
    }
}
