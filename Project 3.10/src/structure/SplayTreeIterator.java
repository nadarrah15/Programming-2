// An implementation of an iterator for SplayTrees
// (c) 1998, 2001 duane a. bailey

package structure;
/**
 * An iterator to traverse a splay tree.
 * 
 * @version $Id: SplayTreeIterator.java 8 2006-08-02 19:03:11Z bailey $
 * @author, 2001 duane a. bailey
 */
class SplayTreeIterator extends AbstractIterator
{
    /**
     * A reference to the root of a splay tree.
     */
    protected BinaryTree tree; // node of splay tree, root computed
    /**
     * The current node being considered in tree.
     */
    protected BinaryTree current; // current node
    // In this iterator, the "stack" normally used is implied by 
    // looking back up the path from the current node.  Those nodes
    // for which the path goes left are on the stack

    /**
     * Construct an iterator that traverses the binary search 
     * tree based at the root.
     *
     * @pre root is the root of the tree to be traversed
     * @post constructs a new iterator to traverse splay tree
     * 
     * @param root The root of the subtree to be traversed.
     */
    public SplayTreeIterator(BinaryTree root)
    {
        tree = root;
        reset();
    }

    /**
     * Reset the iterator to reference the root of the tree.
     *
     * @post resets iterator to smallest node in tree
     */
    public void reset()
    {
        current = tree;
        if (!current.isEmpty()) {
            current = current.root();
            while (!current.left().isEmpty()) current = current.left();
        }
    }

    /**
     * Determine if the iterator has more nodes to be considered.
     *
     * @post returns true if there are unvisited nodes
     * 
     * @return True iff the iterator has more nodes to be considered.
     */
    public boolean hasNext()
    {
        return !current.isEmpty();
    }

    /**
     * Returns reference to the current element, and increments iterator.
     *
     * @pre hasNext()
     * @post returns current element and increments iterator
     * 
     * @return The reference to the current element before incrementing.
     */
    public Object next()
    {
        Object result = current.value();
        if (!current.right().isEmpty()) {
            current = current.right();
            while (!current.left().isEmpty())
            {
                current = current.left();
            }
        } else {
            // we're finished with current's subtree.  We now pop off
            // nodes until we come to the parent of a leftchild ancestor
            // of current
            boolean lefty;
            do
            {
                lefty = current.isLeftChild();
                current = current.parent();
            } while (current != null && !lefty);
            if (current == null) current = BinaryTree.EMPTY;
        }
        return result;
    }
    
    /**
     * Return a reference to the current value.
     *
     * @pre hasNext()
     * @post returns current value
     * 
     * @return A reference to the current value.
     */
    public Object get()
    {
        return current.value();
    }
}
