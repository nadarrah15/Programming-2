// An implementation of priority queues that makes use of ordering vectors.
// (c) 1998, 2001 duane a. bailey
package structure;

/**
 * A vector-based implementation of a priority queue.  Similar to
 * an ordered vector, except that only the smallest value may be
 * accessed in this structure.
 * 
 * @see structure.OrderedVector
 * @version $Id: PriorityVector.java 19 2006-08-10 04:52:00Z bailey $
 * @author, 2001 duane a. bailey
 */
public class PriorityVector implements PriorityQueue
{
    /**
     * The vector of data that is maintained in increasing order.
     */
    protected Vector data;

    /**
     * Construct an empty priority queue.
     *
     * @post constructs a new priority queue
     */
    public PriorityVector()
    {
        data = new Vector();
    }

    /**
     * Fetch the smallest value of the priority queue.
     *
     * @pre !isEmpty()
     * @post returns the minimum value in the priority queue
     * 
     * @return The smallest value of the structure.
     */
    public Comparable getFirst()
    {
        return (Comparable)data.get(0);
    }

    /**
     * Remove the smallest value of the structure.
     *
     * @pre !isEmpty()
     * @post removes and returns minimum value in priority queue
     * 
     * @return The smallest value of the structure.
     */
    public Comparable remove()
    {
        return (Comparable)data.remove(0);
    }
    /**
     * Add a comparable value to the priority queue.
     *
     * @pre value is non-null
     * @post inserts value in priority queue
     *       leaves elements in order
     * 
     * @param value The comparable value to be added.
     */
    public void add(Comparable value)
    {
        int position = indexOf(value);
        data.add(position,value);
    }

    protected int indexOf(Comparable target)
    {
        Comparable midValue;
        int low = 0;  // lowest possible location
        int high = data.size(); // highest possible location
        int mid = (low + high)/2; // low <= mid <= high
        // mid == high iff low == high
        while (low < high) {
            Assert.condition(mid < high,"Middle element exists.");
            midValue = (Comparable)data.get(mid);
            if (midValue.compareTo(target) < 0) {
                low = mid+1;
            } else {
                high = mid;
            }
            mid = (low+high)/2;
        }
        return low;
    }

    /**
     * Determine if the priority queue is empty.
     *
     * @post returns true iff the priority queue is empty
     * 
     * @return True iff there are no elements in the priority queue.
     */
    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     * Determine the size of the priority queue.
     *
     * @post returns number of elements in priority queue
     * 
     * @return The number of elements in the priority queue.
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Remove all the values from the priority queue.
     *
     * @post removes all elements from priority queue
     */
    public void clear()
    {
        data.clear();
    }

    /**
     * Construct a string representation of the priority vector.
     *
     * @post returns string representation of priority vector
     * 
     * @return String describing priority vector.
     */
    public String toString()
    {
        return "<PriorityVector: "+data+">";
    }
}
