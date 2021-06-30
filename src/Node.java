/**
 * A Node class which implements a single node for the doubly linked list
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 * @param <E>
 *            generic java type
 */
public class Node<E> {

    /**
     * This node represents the value of the previous node
     */
    private Node<E> previousNode;
    /**
     * This dataValue holds the value of the data in the node
     */
    private E dataValue;

    /**
     * This node represents the value of the next node
     */
    private Node<E> nextNode;

    /**
     * This sets a new node with the given value
     * 
     * @param value
     *            value of the node to be set with
     */
    Node(E value) {
        dataValue = value;
    }


    /**
     * This method sets the value of the next node to the next node variable
     * 
     * @param nextNodeValue
     *            value of the next node value
     */
    public void setNextNode(Node<E> nextNodeValue) {
        nextNode = nextNodeValue;
    }


    /**
     * This method sets the value of the previous node to the prev node variable
     * 
     * @param previousNodeValue
     *            value of the previous node value
     */
    public void setPreviousNode(Node<E> previousNodeValue) {
        previousNode = previousNodeValue;
    }


    /**
     * This method returns the value of prev node variable
     * 
     * @return returns previous node variable value
     */
    public Node<E> getPreviousNode() {
        return previousNode;
    }


    /**
     * This method returns the value of next node variable
     * 
     * @return returns next node variable value
     */
    public Node<E> getNextNode() {
        return nextNode;
    }


    /**
     * This method returns the value of the node
     * 
     * @return returns the value of the node
     */
    public E getData() {
        return dataValue;
    }
}
