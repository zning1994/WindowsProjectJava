package gui.events.custom;

public class KnockListenerImpl implements KnockListener {
	
    public void doorKnocked(KnockEvent event) {
    	
        if(event.getDoorState().equals("closed"))
        {
             System.out.println("ȥ����");
        }
        else 
        {
              System.out.println("�ſ�����");
        }
    }
}