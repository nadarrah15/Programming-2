// Level-order iterator for binary trees.
// (c) 1998, 2001 duane a. bailey
package structure;

/**
 * An iterator for traversing binary trees constructed from
 * BinaryTrees.  The iterator performs minimal work before
 * traversal.  Every node is considered after every non-trivial
 * ancestor or left cousin, and before any non-trivial descendant or
 * right cousin.
 * AbstractIterator finishes when
 * all descendants of the start node have been considered.
 * 
 * @version $Id: BTLevelorderIterator.java 19 2006-08-10 04:52:00Z bailey $
 * @author, 2001 duane a. bailey
 */
class BTLevelorderIterator extends AbstractIterator
{
    /**
     * The root of the subtree being traversed.
     */
    protected BinaryTree root; // root of traversed subtree
    /** 
     * Queue of nodes that maintain the state of the iterator.
     */
    protected Queue todo;  // queue of unvisited relatives

    /**
     * Construct a new level-order iterator of a tree.
     *
     * @post Constructs an iterator to traverse in level order
     * 
     * @param root The root of the subtree to be traversed.
     */
    public BTLevelorderIterator(BinaryTree root)
    {
        todo = new QueueList();
        this.root = root;
        reset();
    }   

    /**
     * Reset iterator to beginning of traversal.
     *
     * @post Resets the iterator to root node
     */
    public void reset()
    {
        todo.clear();
        // empty queue, add root
        if (!root.isEmpty()) todo.enqueue(root);
    }

    /**
     * Return true if more nodes are to be considered.
     *
     * @post Returns true iff iterator is not finished
     * 
     * @return True if more nodes are to be considered.
     */
    public boolean hasNext()
    {
        return !todo.isEmpty();
    }

    /**
     * Returns the value of the currently considered node.
     *
     * @pre hasNext()
     * @post Returns reference to current value
     * 
     * @return The value of the node currently referenced by iterator.
     */
    public Object get()
    {   
        return ((BinaryTree)todo.get()).value();
    }

    /**
     * Returns currently considered value and increments iterator.
     *
     * @pre hasNext();
     * @post Returns current value, increments iterator
     * 
     * @return Value considered before iterator is incremented.
     */
    public Object next()
    {
        BinaryTree current = (BinaryTree)todo.dequeue();
        Object result = current.value();
        if (!current.left().isEmpty())
            todo.enqueue(current.left());
        if (!current.right().isEmpty())
            todo.enqueue(current.right());
        return result;
    }
}

