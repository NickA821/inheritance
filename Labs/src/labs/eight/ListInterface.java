package labs.eight;

/**
 * ADT to model a list. (CA06)
 * @author Dr. William Kreahling
 * @version Modified Oct. 2013
 */
public interface ListInterface<E> {
    /**
     * Purpose: Add a new entry to the end of a list.
     * Current elements in the list are unaffected, starting position is 0
     * @param newEntry object to add to the list
     * @return true if the object was added, false is the list was full
     */
    public boolean add(E newEntry);

    /**
     * Purpose: Removes all enrties from the list.
     */
    public void clear();

    /**
     * Purpose: get the current length of the list
     * @return the number of entries in the list
     */
    public int getLength();

    /**
     * Purpose: See if the list is empty or not.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Display all entries in the list (in order in which they occur). One per
     * line
     */
    public void display();
}