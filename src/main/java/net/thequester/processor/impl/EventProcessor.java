package net.thequester.processor.impl;

import net.thequester.model.Event;
import net.thequester.model.Quest;
import net.thequester.processor.IEventProcessor;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Tomo.
 */
public class EventProcessor implements IEventProcessor{

    private final Map<Integer, Event> events;

    public EventProcessor(Quest quest) {
        this.events = quest.getEvents();
    }

    public boolean isCauseFulfilled(Integer newNode, Map<Integer, Integer> nodeStates){

        if(events.size() == 0){
            return true;
        }

        Event event = events.get(newNode);

        for(Entry<Integer, Integer> cause : event.getCauses().entrySet()){

            if(!cause.getValue().equals(nodeStates.get(cause.getKey()))){
                return false;
            }
        }

        return true;
    }
}
