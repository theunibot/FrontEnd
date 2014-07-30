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
public class ServerHooksUtils
{

    private static long idItr = 0;

    /**
     * Get 64 bit ID
     *
     * @return 64 bit ID
     */
    public static String getID()
    {
        if (idItr == Long.MAX_VALUE - 1)//roll over instead of overflow
        {
            idItr = 0;
        }
        idItr++;
        return String.valueOf(idItr - 1);
    }

    /**
     * Converts the CommandQueueStatus enum to a string for output.
     *
     * @param enum Enum to convert to String
     * @return String version
     */
    public static String commandQueueStatusEnumToString(CommandQueueStatus enm)
    {
        if (enm == CommandQueueStatus.COMPLETE)
        {
            return "complete";
        }
        else if (enm == CommandQueueStatus.EXECUTING)
        {
            return "executing";
        }
        else if (enm == CommandQueueStatus.PENDING)
        {
            return "pending";
        }
        else if (enm == CommandQueueStatus.UNKNOWN)
        {
            return "unknown";
        }
        else
        {
            return null;
        }
    }

    private static ArrayList<KVObj> response;

    public static String genericEnqueueFail()
    {
        return ServerHooksUtils.genericEnqueueFail("Generic Enqueue Fail");
    }

    public static String genericEnqueueFail(String error)
    {
        response = new ArrayList<KVObj>();
        response.add(new KVObj("id", ServerHooksUtils.getID()));
        response.add(new KVObj("error", error));
        return ServerHooksUtils.buildJSON(response);
    }

    public static String genericStatusFail()
    {
        response = new ArrayList<KVObj>();
        response.add(new KVObj("status", "unknown"));
        return ServerHooksUtils.buildJSON(response);
    }

    public static String buildJSON(ArrayList<KVObj> kvObjs)
    {
        StringBuilder b = new StringBuilder();
        KVObj kvObj;
        b.append("{");
        for (int i = 0; i < kvObjs.size() - 1; i++)//all but last set of vals
        {
            kvObj = kvObjs.get(i);
            b.append(kvObj.getKey() + ":" + kvObj.getValue() + ",");
        }
        kvObj = kvObjs.get(kvObjs.size() - 1);
        b.append(kvObj.getKey() + ":" + kvObj.getValue() + "}");
        return b.toString();
    }

}