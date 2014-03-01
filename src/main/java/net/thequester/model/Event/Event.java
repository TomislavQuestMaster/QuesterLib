package net.thequester.model.Event;

import net.thequester.model.Node;

import java.util.Map;

/**
 * Created by Tomo.
 */
public class Event {

    private Map<Integer,State> causes;
    private Map<Node,State> effects;

    public Map<Integer, State> getCauses() {
        return causes;
    }

    public void setCauses(Map<Integer, State> causes) {
        this.causes = causes;
    }

    public Map<Node, State> getEffects() {
        return effects;
    }

    public void setEffects(Map<Node, State> effects) {
        this.effects = effects;
    }
}
