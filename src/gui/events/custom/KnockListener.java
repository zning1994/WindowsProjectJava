package gui.events.custom;

import java.util.EventListener;


public interface KnockListener extends EventListener {
    public void doorKnocked(KnockEvent event);
}