package structure;
/**
 * a traversal to traverse hash tables.
 *
 * @version $Id: HashtableIterator.java 8 2006-08-02 19:03:11Z bailey $
 * @author, 2001 duane a. bailey
 */
class HashtableIterator extends AbstractIterator
{
    /**
     * The current entry being considered.
     */
    protected int current;
    /**
     * Reference to hash table data
     */
    protected Association data[];

    /**
     * Construct a traversal over a hashtable.
     *
     * @post constructs a new hash table traversal
     * 
     * @param table The array of lists to be traversed.
     */
    public HashtableIterator(Association[] table)
    {
        data = table;
        reset();
    }

    /**
     * Resets the traversal to point to the beginning of the table.
     *
     * @post resets traversal to beginning of hash table
     */
    public void reset()
    {
        for (current = 0; current < data.length; current++)
        {
            if (data[current] != null &&
                data[current] != Hashtable.reserved) break;
        }
        return;
    }

    /**
     * Returns true iff there are unconsidered elements within the table.
     *
     * @post returns true if there are unvisited elements
     * 
     * @return True iff there are elements yet to be considered within table.
     */
    public boolean hasNext()
    {
        return current < data.length;
    }

    /**
     * Returns current value and increments traversal.
     *
     * @pre hasNext()
     * @post returns current element, increments traversal
     * 
     * @return The current value, before incrementing.
     */
    public Object next()
    {
        Object result = data[current];
        for (current++; current < data.length; current++)
        {
            if (data[current] != null &&
                data[current] != Hashtable.reserved) break;
        }
        return result;
    }

    /**
     * Get current value of traversal.
     *
     * @post returns current element
     * 
     * @return The current value.
     */
    public Object get()
    {
        return data[current];
    }
}
