package net.thequester.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "event")
public class Event {

    /**
     * mapping of node to number of visits
     */
    private Map<Integer,Integer> causes;

    public Event() {
        causes = new HashMap<Integer, Integer>();
    }

    public Map<Integer, Integer> getCauses() {
        return causes;
    }

    public void setCauses(Map<Integer, Integer> causes) {
        this.causes = causes;
    }

}
