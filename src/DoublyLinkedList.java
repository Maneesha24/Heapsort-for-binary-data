/**
 * The DoublyLinkedList class implements DoublyLinkedList that has a head and a
 * tail node
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 * @param <E> generic
 *            java type
 */
public class DoublyLinkedList<E> {

    /**
     * This node represents the value of the head in the doubly linked list
     */
    private Node<E> headNode;
    /**
     * This node represents the value of the tail in the doubly linked list
     */
    private Node<E> tailNode;

    /**
     * This method initializes the DoublyLinkedList class with nodes holding
     * the nodes with the number of nodes taken as argument
     * 
     * @param num
     *            holds the value of the size of the list
     * 
     */
    public DoublyLinkedList(int num) {
        headNode = new Node<E>(null);
        tailNode = new Node<E>(null);
        
        headNode.setNextNode(tailNode);
        tailNode.setPreviousNode(headNode);
        
        for (int i = 1; i <= num; i++) {
            Node<E> nullNode = new Node<E>(null);
            headNode.getNextNode().setPreviousNode(nullNode);
            nullNode.setNextNode(headNode.getNextNode());
            nullNode.setPreviousNode(headNode);
            headNode.setNextNode(nullNode);
        }
    }


    /**
     * This method is used to either shift up the pool or add the value to the
     * list if not
     * present
     * 
     * @param data
     *            data to be shifted or added
     * @return the node that is added
     */
    public E shiftAddNode(E data) {

        Node<E> node = headNode;
        while ((node = node.getNextNode()) != tailNode) {
            if (data.equals(node.getData())) {
                node.getNextNode().setPreviousNode(node.getPreviousNode());
                node.getPreviousNode().setNextNode(node.getNextNode());

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
     * @param data
     *            is the value of the node to be added to the list
     * @return the data of the last node
     */
    public E addNode(E data) {
        Node<E> node = new Node<E>(data);
        node.setPreviousNode(headNode);
        node.setNextNode(headNode.getNextNode());
        headNode.getNextNode().setPreviousNode(node);
        headNode.setNextNode(node);

        Node<E> last = tailNode.getPreviousNode();
        last.getPreviousNode().setNextNode(tailNode);
        tailNode.setPreviousNode(last.getPreviousNode());
        return last.getData();
    }

}
