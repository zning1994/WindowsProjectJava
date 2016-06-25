package gui.events.custom;

public class KnockListenerImpl implements KnockListener {
	
    public void doorKnocked(KnockEvent event) {
    	
        if(event.getDoorState().equals("closed"))
        {
             System.out.println("去开门");
        }
        else 
        {
              System.out.println("门开着呢");
        }
    }
}