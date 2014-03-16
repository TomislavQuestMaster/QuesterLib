package net.thequester.model;

import net.thequester.model.Node;

import java.util.Map;

/**
 * Created by Tomo.
 */
public class Event {

    /**
     * mapping of node to number of visits
     */
    private Map<Integer,Integer> causes;

    public Map<Integer, Integer> getCauses() {
        return causes;
    }

    public void setCauses(Map<Integer, Integer> causes) {
        this.causes = causes;
    }

}
