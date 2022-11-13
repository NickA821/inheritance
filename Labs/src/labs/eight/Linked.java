package labs.eight;
import java.util.*;

/**
 * Implementation of the ADT List using linked lists
 * @author William Kreahling
 * @version 2012, 2013, 2014
 *
 * (Modifications by Scott Barlowe, 2018)
 */
public class Linked<E> implements ListInterface<E> {
    /** First node in the list */
    private Node    head;
    /** Number of elements in the list */
    private int     length;

    /**
     * Default constructor, sets initial values
     */
    public Linked() {
        clear();    // clear does what we want, so use it
    }

    /**
     * Remove everything from our list
     */
    public final void clear() {
        this.length     = 0;
        this.head       = null;       // Garbage collection cleans up!
    }

    /**
     * Purpose: Add a new entry to the end of a list.
     * Current elements in the list are unaffected, starting position is 0
     * @param entry object to add to the list
     * @return true if the object was added, false is the list was full
     */
    public boolean add(E entry) {

        assert entry != null: "Entry is null";

        Node newNode = new Node(entry);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node lastNode = getNodeAt(length - 1);
            lastNode.next = newNode;
        }
        length++;
        return true;
    }

    /**
     * Purpose: Gets a reference to a node at a given positon
     * @param position of the node in the list
     * @return reference to the Node at the given position
     */
    private Node getNodeAt(int position) {
        assert !isEmpty() && (position >= 0) && position < length;

        Node cNode = head;

        for (int i = 0; i < position; i++)
            cNode = cNode.next;

        assert cNode != null;
        return cNode;
    }

    /**
     * Display the linked list.
     */
    public void display() {
        Node cNode = head;
        for (int i = 0; i < length; i++) {
            if (cNode != null) {
                System.out.print("\t" + cNode+ "\n");
                cNode = cNode.next;
            }
        }
    }

    /**
     * Get the length of the lined list
     * @return The size of the list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Tell if the list is empty or not.
     * @return a boolean result. True of empty.
     */
    public boolean isEmpty() {
        if (length == 0) {
            // this has better be true, or something funky has happened
            assert head == null;
            return true;
        }
        assert head != null;
        return false;
    }

    /*
     * --------------------------------------------------------------
     * Methods to be completed!
     * ---------------------------------------------------------------
     */


    /**
     * Swap this node with the one before it by swapping the data
     * @param second The second of the two ajacent nodes to swap.
     * @throws NoSuchElementException
     */
    public void swap(int second) {
        if(head != null && head.next != null && second > 0 && second < length) {
            Node present = head;
            System.out.println(present.next.next != null);
            if(present.next.next != null && present != null && present != head) {
                for(int i = 0; i < second-2; i++) {
                    present = present.next;
                }
                Node next = present.next;
                Node after = present.next.next;
                present.next = after;
                next.next = after.next;
                after.next = next;
            }
            else if(second == 1) {
                Node next = present.next;
                Node after = present.next.next;
                head = next;
                present.next = after;
                next.next = present;
            }
            else {
                for(int i = 0; i < second-1; i++) {
                    present = present.next;
                }
                Node next = present.next;
                Node after = present.next.next;
                present.next = after;
                next.next = null;
                after.next = next;

            }
        }
        else {
            throw new NoSuchElementException();
        }
    }



    /**
     * Cycle though the nodes so ABCD becomes BCDA, then next time cycle is
     * called CDAB.
     */
    public void cycle() {
        Node newTail = head;
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        head = newTail.next;
        current.next = newTail;

    }

    /**
     * Reverse the linked list in place.
     * THOU SHALT NOT create another linked list to acheive this.
     * THOU SHALT NOT getNodeAt(idx) n/2 times and swap the entries
     *      (this is inefficient).
     * You must arrange the list on each end.
     */
    public void reverse() {
        if(head != null) {
            Node current = head;
            Node forwards = null;
            Node backwards = null;
            while(current != null) {
                forwards = current.next;
                current.next = backwards;
                backwards = current;
                current = forwards;
            }
            head = backwards;
        }
    }

    /**
     * Extracts a section of the list and places it at the start of the list
     * @param startPos
     *            The starting position at which the list should be extracted.
     *            startPos is the position of the first item in section to be
     *            extracted.
     *
     * @param endPos
     *            The ending position at which the list should be extracted.
     *            endPos is the position of the last item in the section to be
     *            extracted.
     *
     *            If startPos == 0, leave the list as is.
     *
     *            If endPos is not a valid position, leave the list as is.
     *
     * Example:  Given startPos = 2, endPos = 5
     *
     *           A-B-C-D-E-F-G would become C-D-E-F-A-B-G
     *
     * THOU SHALT NOT create a new list or any new nodes
     * THOU SHALT NOT call the cycle method
     */
    public void extract(int startPos, int endPos){
        Node current = head;
        Node point = null;
        Node back = null;
        System.out.println("Extracting");
        for(int i = 0; i < length; i++) {
            if(i == startPos) {
                point = back;
                head = current;
            }
            back = current;
            current = current.next;
            if (current == null) {
                current = head;
            }
            System.out.println("Extracting" + current);
        }

    }

    /**
     * Models a Node that is one piece of a linked list.
     */
    private class Node {
        /** Reference to the data */
        private E data;
        /** Reference to the next node is in the list */
        private Node next;

        /**
         * Sets the data for this node.
         * @param data data to be carried by this node.
         */
        private Node(E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Sets the data for the node and assigns the next node in the list.
         * @param data data to be carried by this node.
         * @param nextNode next node in the list.
         */
        private Node(E data, Node nextNode) {
            this.data = data;
            this.next = nextNode;
        }
        /**
         * Returns just the data portion of the node.
         * @return The data portion of the node.
         */
        private E getData() {
            return this.data;
        }
        /**
         * Modified just the data portion of the node.
         * @param data new data to be contained within the node.
         */
        private void setData(E data) {
            this.data = data;
        }

        /**
         * What node does this node point to.
         * @return the node that this node points to or null if it does not
         * point anywhere.
         */
        public Node getNextNode() {
            return this.next;
        }

        /**
         * Change the node that this node points to.
         * @param nextNode a new node for this node to point to.
         */
        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        /**
         * Display the state of just the data portion of the node.
         */
        public String toString() {
            return this.data.toString();
        }
    }
    public static void main(String[] args) {
        Linked<String> list = new Linked<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.display();
        list.extract(2,4);
        list.display();
    }
}
