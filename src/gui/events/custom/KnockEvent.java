package gui.events.custom;

import java.util.EventObject;

public class KnockEvent extends EventObject {
	
    private String doorState = "closed";//表示门的状态，有“开”和“关”两种

    public KnockEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getDoorState() {
        return this.doorState;
    }
}