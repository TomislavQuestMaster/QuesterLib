package net.thequester.processor;

import net.thequester.model.Event.Event;
import net.thequester.model.Event.State;
import net.thequester.model.Game;

/**
 * Created by Tomo.
 */
public class EventProcessor {

    private Event event;

    public EventProcessor(Event event) {
        this.event = event;
    }

    public boolean isCauseFulfilled(Game game){

        for(Integer nodeId : event.getCauses().keySet()){

            State state = game.getVisitedNodesMap().get(nodeId);

            if(state == null){
                return false;
            }

            if(!state.equals(event.getCauses().get(nodeId))){
                return false;
            }

        }

        return true;
    }
}
