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

	private Event(Map<Integer, Integer> causes) {
		this.causes = causes;
	}

    public Map<Integer, Integer> getCauses() {
        return causes;
    }

    public void setCauses(Map<Integer, Integer> causes) {
        this.causes = causes;
    }


	public static class EventBuilder{

		private Map<Integer,Integer> causes;

		public EventBuilder(){
			causes = new HashMap<Integer, Integer>();
		}

		public EventBuilder cause(Integer visited, Integer times){

			causes.put(visited, times);
			return this;
		}

		public Event build(){
			return new Event(causes);
		}

	}
}
