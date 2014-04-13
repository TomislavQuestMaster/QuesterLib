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

        if(event == null){
            return true;
        }

        for(Entry<Integer, Integer> cause : event.getCauses().entrySet()){

            Integer visited = nodeStates.get(cause.getKey());
            if(visited == null){
                visited = 0;
            }

            if(!cause.getValue().equals(visited)){
                return false;
            }
        }

        return true;
    }
}
