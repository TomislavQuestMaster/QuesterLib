package net.thequester.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tdubravcevic
 */
public class QuestArchive {

    private String location;
    private List<Quest> quests;

    public QuestArchive(String location) {
        this.location = location;
        this.quests = new ArrayList<Quest>();
    }

    public QuestArchive(String location, List<Quest> quests) {
        this.location = location;
        this.quests = quests;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
