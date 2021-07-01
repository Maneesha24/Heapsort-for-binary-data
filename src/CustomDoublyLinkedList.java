/**
 * The DoublyLinkedList class implements DoublyLinkedList that has a head and a
 * tail node
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 * @param <Heap>
 *            generic
 *            java type
 */
public class CustomDoublyLinkedList<Heap> {

    /**
     * This node represents the value of the head in the doubly linked list
     */
    private CustomNode<Heap> headNode;
    /**
     * This node represents the value of the tail in the doubly linked list
     */
    private CustomNode<Heap> tailNode;

    /**
     * This method initializes the DoublyLinkedList class with nodes holding
     * the nodes with the number of nodes taken as argument
     * 
     * @param num
     *            holds the value of the size of the list
     * 
     */
    public CustomDoublyLinkedList(int num) {
        // The headNode is initialized to be null
        headNode = new CustomNode<Heap>(null);
        // The tailNode is initialized to be null
        tailNode = new CustomNode<Heap>(null);

        // Set the next node of head to be the tail
        headNode.setNextNode(tailNode);
        // Set the previous node of tail to be the head
        tailNode.setPreviousNode(headNode);

        // Loop till the the size of the list
        for (int i = 1; i <= num; i++) {
            // Initialize the node to be null
            CustomNode<Heap> node = new CustomNode<Heap>(null);
            // Assign the next node of the node variable to be head
            CustomNode<Heap> nextNode = headNode.getNextNode();
            // Assign the previous node of the node variable to be the node
            // holding null value
            nextNode.setPreviousNode(node);
            // Assign the next node of the new node to be the next of the head
            // node
            node.setNextNode(headNode.getNextNode());
            // Set the previous node to be head node
            node.setPreviousNode(headNode);
            headNode.setNextNode(node);
        }
    }


    /**
     * This method is used to either shift up the pool or add the value to the
     * list if not present
     * 
     * @param data
     *            data to be shifted or added
     * @return the node that is added
     */
    public Heap shiftAddNode(Heap data) {

        // If found, it shifts the buffer up the pool and returns null or else
        // if adds it the list
        CustomNode<Heap> node = headNode;
        // Loop till the end of the list
        while ((node = node.getNextNode()) != tailNode) {
            if (data.equals(node.getData())) {
                // Set the previous of the node to be the next of the previous
                // node
                CustomNode<Heap> prevNode = node.getPreviousNode();
                node.getNextNode().setPreviousNode(prevNode);
                CustomNode<Heap> nextNode = node.getNextNode();
                // Set the next of the node to be the previous of the next
                // node
                node.getPreviousNode().setNextNode(nextNode);
                node.setPreviousNode(headNode);
                node.setNextNode(headNode.getNextNode());
                headNode.getNextNode().setPreviousNode(node);
                headNode.setNextNode(node);
                return null;
            }
        }

        return addNode(data);
    }


    /**
     * This method adds a node with the value taken as a argument to the doubly
     * linked list
     * 
     * @param value
     *            is the value of the node to be added to the list
     * @return the data of the last node
     */
    public Heap addNode(Heap value) {
        // Create a new node with data equal to value variable
        CustomNode<Heap> node = new CustomNode<Heap>(value);
        // Set the previous of the newly created node to be head
        node.setPreviousNode(headNode);
        // Set the next of the newly created node to be the second node
        // previously
        node.setNextNode(headNode.getNextNode());
        headNode.getNextNode().setPreviousNode(node);
        // Set the next node of the head to be the newly created node
        headNode.setNextNode(node);
        // The last variable holds the value of the previous of the tail node
        CustomNode<Heap> last = tailNode.getPreviousNode();
        // Set the next of the second last node to be the tail node
        last.getPreviousNode().setNextNode(tailNode);
        CustomNode<Heap> secondLastNode = last.getPreviousNode();
        tailNode.setPreviousNode(secondLastNode);
        // Return the value of the node
        return last.getData();
    }

}
