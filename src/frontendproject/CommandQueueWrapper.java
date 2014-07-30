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
public class CommandQueueWrapper
{

    private static CommandQueueWrapper cw = null;

    public static CommandQueueWrapper getInstance()
    {
        if (cw == null)
        {
            cw = new CommandQueueWrapper();
        }
        return cw;
    }

    private CommandQueueWrapper()
    {
        for (int i = 0; i < queues.length; i++)
        {
            queues[i] = new CommandQueue();
        }
    }
    
    

    private CommandQueue[] queues = new CommandQueue[3];

    /**
     * Clear the command queue of the given num
     */
    public void clear(int num)
    {
        queues[num].clear();
    }

    /**
     * Adds an element to the given queue
     *
     * @param queueIndex index of the queue to add to
     * @param id element id
     * @param s element content
     */
    public void add(int queueIndex, long id, String s)
    {
        queues[queueIndex].add(id, s);
    }

    /**
     * Gets the first command in the list
     *
     * @return First command in list or null if none found
     */
    public QueueableItem getFirst(int index)
    {
        return queues[index].getFirst();
    }
}

