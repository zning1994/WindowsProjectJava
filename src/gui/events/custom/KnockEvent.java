package gui.events.custom;

import java.util.EventObject;

public class KnockEvent extends EventObject {
	
    private String doorState = "closed";//��ʾ�ŵ�״̬���С������͡��ء�����

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