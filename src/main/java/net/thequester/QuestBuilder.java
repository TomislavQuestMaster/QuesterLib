package net.thequester;

import net.thequester.model.Event;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

/**
 * Created by Tomo.
 */
public class QuestBuilder {

    private Quest quest;

    public QuestBuilder() {
        this.quest = new Quest();
    }

    public QuestBuilder node(Double x, Double y){
        Node node = new Node();
        node.setRadius(0.1);
        node.setQuestLocation(new QuestLocation(x,y));
        quest.getNodes().add(node);
        node.setId(quest.getNodes().size()-1);
        return this;
    }

    public QuestBuilder event(Integer node, Event event){

        quest.getEvents().put(node, event);

        return this;
    }

    public Quest build(){
        return quest;
    }
}
