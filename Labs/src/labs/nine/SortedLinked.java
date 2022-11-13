package nine;

import java.util.*;

/**
 * Implementation of the ADT List using linked lists
 * @author Kate Morovat
 * @version 2020
 *
 */
public class SortedLinked {
    /** First node in the list */
    private Node    head;
    /** Number of elements in the list */
    //private int length;

    /**
     * Models a Node that is one piece of a linked list.
     */ 
    private class Node {
        /** Reference to the data */
        private int data;
        /** Reference to the next node is in the list */
        private Node next;

        /**
         * Sets the data for this node.
         * @param data data to be carried by this node.
         */
        private Node(int data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Sets the data for the node and assigns the next node in the list.
         * @param data data to be carried by this node.
         * @param nextNode next node in the list.
         */
        private Node(int data, Node nextNode) {
            this.data = data;
            this.next = nextNode;
        }
        /**
         * Returns just the data portion of the node.
         * @return The data portion of the node.
         */
        private int getData() {
            return this.data;
        }
        /**
         * Modified just the data portion of the node.
         * @param data new data to be contained within the node.
         */
        private void setData(int data) {
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
            return ""+this.data;  
        }
    }
    /**
     * Default constructor, sets initial values
     */
    public SortedLinked() {
        clear();    // clear does what we want, so use it
    }

    /**
     * Remove everything from our list
     */
    public final void clear() {
        //this.length     = 0;
        this.head       = null;       // Garbage collection cleans up!
    }



    /**
     * Display the linked list.
     */ 
    public void display() {
        Node cNode = head;
        while (cNode != null) {
               System.out.print("\t" + cNode+ "\n");
               cNode = cNode.next;
        }
    }

    /**
     * Tell if the list is empty or not.
     * @return a boolean result. True of empty.
     */ 
    public boolean isEmpty() {
        if (head == null) {
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
     * Purpose: Add a new entry to the sorted list.
     * @param entry object to add to the list
     * @return true if the object was added, false is the list was full
     */
    public void insert(int entry) {
    	Node current = head;
    	Node back = null;
    	Node elem = new Node(entry);
    	if(!isEmpty()) {
    		int lowest = head.data;
	    	while(current != null) {
	    		if(current.data < lowest) {
	    			back.next = current.next;
	    			head = current;
	    			lowest = current.data;
	    		}
	    		if(entry < lowest) {
	    			elem.next = head;
	    			head = elem;
	    			lowest = entry;
	    		}
	    		back = current;
	    		current = current.next;
	    	}
	    	if(elem != head) {
	    		current = elem;
	    		back.next = current;
	    	}
    	}
    	else {
    		head = elem;
    	}
		
    }
    /**
     * Delete this node with if this exists in the list
     * @param data.
     * @throws NoSuchElementException
     */
    public int delete(int data) {
    	 Node current = head;
    	 Node previous = null;
    	 int deleted = 0;
    	 boolean preEmpty = isEmpty();
    	 while(current != null) {
    		 if(current.data == data) {
	    		 if(current != head) {
		    		 if(current.next != null) {
		    			 previous.next = current.next;
		    			 deleted = data;
		    		 }
		    		 else {
		    			 previous.next = null;
		    			 deleted = data;
		    		 }
	    		 }
	    		 else {
	    			 if(current.next != null) {
						 head = current.next;
						 deleted = data;
	    			 }
	    			 else {
	    				 head = null;
	    				 deleted = data;
	    			 }
	    		 }
    		 }
    		 previous = current;
    		 current = current.next;
    	 }
    	 if(deleted == 0 || preEmpty) {
    		 System.out.println(deleted);
    		 throw new NoSuchElementException();
    	 }
    	 return deleted;
    }

    /**
     * find the middle element of the list
     */
    public Node middleItem() {
    	Node current = head;
		if(!isEmpty()) {
	    	Node forward = head.next;
	    	if(forward.getNextNode() != null) {
	    		if(forward.getNextNode() != null) {
		    		forward = forward.next;
		    	}
	    		else {
	    			forward = forward.next;
	    		}
	    	}
			while(forward.next !=null) {
				System.out.println("Forward " + forward);
				current = current.next;
				forward = forward.next;
			}
		}
		else {
			throw new NoSuchElementException();
		}
		return current;
    }

    /**
     * find a cycle in the list. 
     * @param : no parameter
     * @return: true if the list has a cycle
     */
 
 
}
