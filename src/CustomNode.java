/**
 * A Node class which implements a single node for the doubly linked list
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 * @param <Heap>
 *            generic java type
 */
public class CustomNode<Heap> {

    /**
     * This node represents the value of the previous node
     */
    private CustomNode<Heap> previousNode;
    /**
     * This dataValue holds the value of the data in the node
     */
    private Heap dataValue;

    /**
     * This node represents the value of the next node
     */
    private CustomNode<Heap> nextNode;

    /**
     * This sets a new node with the given value
     * 
     * @param value
     *            value of the node to be set with
     */
    CustomNode(Heap value) {
        dataValue = value;
    }


    /**
     * This method sets the value of the next node to the next node variable
     * 
     * @param nextNodeValue
     *            value of the next node value
     */
    public void setNextNode(CustomNode<Heap> nextNodeValue) {
        nextNode = nextNodeValue;
    }


    /**
     * This method sets the value of the previous node to the prev node variable
     * 
     * @param previousNodeValue
     *            value of the previous node value
     */
    public void setPreviousNode(CustomNode<Heap> previousNodeValue) {
        previousNode = previousNodeValue;
    }


    /**
     * This method returns the value of prev node variable
     * 
     * @return returns previous node variable value
     */
    public CustomNode<Heap> getPreviousNode() {
        return previousNode;
    }


    /**
     * This method returns the value of next node variable
     * 
     * @return returns next node variable value
     */
    public CustomNode<Heap> getNextNode() {
        return nextNode;
    }


    /**
     * This method returns the value of the node
     * 
     * @return returns the value of the node
     */
    public Heap getData() {
        return dataValue;
    }
}
