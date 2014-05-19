package net.thequester.processor.impl;

import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IEventProcessor;
import net.thequester.processor.IGameEngine;

import java.util.*;

/**
 * @author tdubravcevic
 */
public class GameEngine implements IGameEngine {

    private QuestProcessor questProcessor;
    private IEventProcessor eventProcessor;

    private Game game;

	public GameEngine(QuestProcessor questProcessor, IEventProcessor eventProcessor) {

		this.questProcessor = questProcessor;
		this.eventProcessor = eventProcessor;
		this.game = new Game();
	}

	public void startQuest(Quest quest) {

        questProcessor = new QuestProcessor(quest);
        eventProcessor = new EventProcessor(quest.getEvents());
        //autowire elements
        //game = gameProvider.getGame(quest);
        game = new Game();
        game.getVisitedNodes().add(quest.getNodes().get(0).getId());
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
