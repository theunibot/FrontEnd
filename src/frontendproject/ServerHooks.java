/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author kyle
 */
public class ServerHooks
{

    //Objects
    private static ServerHooks s = null;

    //used in get/set vars calls
    private Map<String, String> vars = Collections.synchronizedMap(new LinkedHashMap<String, String>());

    private CommandQueueWrapper cmdq = CommandQueueWrapper.getInstance();

    //used in JSON response
    ArrayList<KVObj> response = new ArrayList<KVObj>();

    public static ServerHooks getInstance()
    {
        if (s == null)
        {
            s = new ServerHooks();
        }
        return s;
    }

    //enqueue stuff
    private final String ENQUEUE_COMMAND = "command";
    private final String[] ENQUEUE_COMMANDS =
    {
        "mount-layer", "replace-layer", "show-layer", "empty-desktop", "show-sign", "arm-home", "arm-calibrate"
    };

    public String enqueue(Map<String, String> params)
    {
        response.clear();
        String command = "";
        if ((command = params.get(ENQUEUE_COMMAND)) != null)
        {
            if (command.equals(ENQUEUE_COMMANDS[0]))//mnt lyr
            {
                String queue, status, layer, shelf, desktop, effect = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((layer = params.get("layer")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((shelf = params.get("shelf")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((desktop = params.get("desktop")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((effect = params.get("effect")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails
                int desktopInt = Integer.parseInt(desktop);
                long id = Utils.getID();
                cmdq.add(desktopInt, id, shelf);
                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(id)));
                return Utils.buildJSON(response);

            }
            else if (command.equals(ENQUEUE_COMMANDS[1]))//rep lyr
            {
                String queue, status, layer, shelf, desktop, effect = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((layer = params.get("layer")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((shelf = params.get("shelf")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((desktop = params.get("desktop")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((effect = params.get("effect")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else if (command.equals(ENQUEUE_COMMANDS[2]))//shw lyr
            {
                String queue, status, shelf, desktop, effect = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((shelf = params.get("shelf")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((desktop = params.get("desktop")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((effect = params.get("effect")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else if (command.equals(ENQUEUE_COMMANDS[3]))//emty dsktp
            {
                String queue, status, desktop = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((desktop = params.get("desktop")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else if (command.equals(ENQUEUE_COMMANDS[4]))//shw sign
            {
                String queue, status, layer, effect = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((layer = params.get("layer")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((effect = params.get("effect")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else if (command.equals(ENQUEUE_COMMANDS[5]))//arm home
            {
                String queue, status = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else if (command.equals(ENQUEUE_COMMANDS[6]))//arm calibr
            {
                String queue, status = "";
                if ((queue = params.get("queue")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                if ((status = params.get("status")) == null)
                {
                    return Utils.genericEnqueueFail();
                }
                //no fails

                //TODO - work
                //response
                response.add(new KVObj("id", String.valueOf(Utils.getID())));
                return Utils.buildJSON(response);
            }
            else//unknown command type
            {
                return Utils.genericEnqueueFail();
            }
        }
        else
        {
            return Utils.genericEnqueueFail();
        }
    }

    private final String STATUS_ID = "id";
    private final String STATUS_STATUS = "status";

    public String status(Map<String, String> params)
    {
        response.clear();
        String id;

        CommandQueueStatus status = CommandQueueStatus.UNKNOWN;

        //TODO - work
        if ((id = params.get(STATUS_ID)) != null)
        {
            response.add(new KVObj(STATUS_STATUS, Utils.commandQueueStatusEnumToString(status)));
            return Utils.buildJSON(response);
        }
        else
        {
            return Utils.genericStatusFail();
        }
    }

    private final String CLEAR_QUEUE_VALUE = "queue";

    public String clearQueue(Map<String, String> params)
    {
        response.clear();
        String strVal = null;
        if ((strVal = params.get(CLEAR_QUEUE_VALUE)) == null)
        {
            int intVal = -1;
            try
            {
                intVal = Integer.parseInt(strVal);
            }
            catch (NumberFormatException ignored)
            {
                return "";//fail, return nothing
            }
            cmdq.clear(intVal);
        }
        return "";//returns nothing
    }

    private final String GET_VAR_VALUE = "value";

    public String getVar(Map<String, String> params)
    {
        response.clear();
        String val = null;

        if ((val = params.get(SET_VAR_KEY)) == null)
        {
            val = "";
        }

        response.add(new KVObj(GET_VAR_VALUE, val));
        return Utils.buildJSON(response);
    }

    private final String SET_VAR_VALUE = "value";
    private final String SET_VAR_KEY = "key";

    public String setVar(Map<String, String> params)
    {
        response.clear();
        String keyVal;
        String valVal;

        if ((keyVal = params.get(SET_VAR_KEY)) == null)
        {
            return "";
        }
        if ((valVal = params.get(SET_VAR_VALUE)) == null)
        {
            return "";
        }

        vars.put(keyVal, valVal);

        return "";//returns nothing
    }
}
