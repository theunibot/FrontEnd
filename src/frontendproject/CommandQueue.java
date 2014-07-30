/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontendproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kyle
 */
public class CommandQueue
{

    private List<QueueableItem> queue = Collections.synchronizedList(new ArrayList<QueueableItem>());

    /**
     * Clear the command queue
     */
    public void clear()
    {
        queue.clear();
    }

    /**
     * Add a Command String to the Queue
     *
     * @param s Command String
     */
    public void add(int id, String s)
    {
        queue.add(new QueueableItem(id, s));
    }

    /**
     * Gets the first command in the list
     *
     * @return First command in list or null if none found
     */
    public QueueableItem getFirst()
    {
        if (queue.size() > 0)
        {
            return queue.get(0);
        }
        return null;
    }

    public QueueableItem getElement(int id)
    {
        return null;
    }

}