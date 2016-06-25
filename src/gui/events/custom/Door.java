package gui.events.custom;

import java.util.*;


public class Door {
	
    private Collection listeners; //?????§Ó???????listener
    /**
     * ??????
     * @param listener DoorListener
     */
    public void addKnockListener(KnockListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * ??????
     * @param listener DoorListener
     */
    public void removeDoorListener(KnockListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * ???????????
     */
    protected void fireDoorOpened() {
        if (listeners == null)
            return;
        KnockEvent event = new KnockEvent(this, "closed");
        notifyListeners(event);
    }

    /**
     * ?????§Ö?DoorListener
     */
    private void notifyListeners(KnockEvent event) {
        Iterator iter = listeners.iterator();
        while (iter.hasNext()) {
            KnockListener listener = (KnockListener) iter.next();
            listener.doorKnocked(event);
        }
    }
    
    
    public static void main(String []args)
    {
        Door door = new Door();
        door.addKnockListener(new KnockListenerImpl());//????1?????????
        door.fireDoorOpened();
    }

}