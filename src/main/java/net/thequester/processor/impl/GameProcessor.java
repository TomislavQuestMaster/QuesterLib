package net.thequester.processor.impl;

import net.thequester.database.IGameProvider;
import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IEventProcessor;
import net.thequester.processor.IGameProcessor;
import net.thequester.processor.impl.EventProcessor;
import net.thequester.processor.impl.QuestProcessor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tdubravcevic
 */
public class GameProcessor implements IGameProcessor{

    private QuestProcessor questProcessor;
    private IGameProvider gameProvider;
    private IEventProcessor eventProcessor;

    private Game game;

    public void startQuest(Quest quest) {

        questProcessor = new QuestProcessor(quest);
        eventProcessor = new EventProcessor(quest);
        //autowire elements
        game = gameProvider.getGame(quest);
    }

    public void processLocation(QuestLocation location) {

        Node node = questProcessor.processLocation(game.currentNode(), location);
        if (node == null) {
            return;
        }

        if(!eventProcessor.isCauseFulfilled(node.getId(), getNodeStates())){
            return;
        }

        game.getVisitedNodes().add(node.getId());
    }

    private Map<Integer, Integer> getNodeStates() {
        Map<Integer, Integer> states = new HashMap<Integer, Integer>();

        List<Integer> visited = game.getVisitedNodes();

        for(Integer node : visited){
            states.put(node, Collections.frequency(visited, node));
        }

        return states;
    }

    public List<Integer> getGamePath() {
        //return node aspects
        return game.getVisitedNodes();
    }

}
