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

        Optional<Node> nodeOptional = questProcessor.processLocation(game.currentNode(), location);
        if (!nodeOptional.isPresent()) {
            return;
        }
		Node node = nodeOptional.get();

        if(!eventProcessor.isCauseFulfilled(node.getId(), getNodeStates())){
            return;
        }

        game.getVisitedNodes().add(node.getId());
    }

    private Map<Integer, Integer> getNodeStates() {
        Map<Integer, Integer> states = new HashMap<>();

        List<Integer> visited = game.getVisitedNodes();

        for(Integer node : visited){
            states.put(node, Collections.frequency(visited, node));
        }

        return states;
    }

    public List<Integer> getGamePath() {
        //TODO return node aspects
        return game.getVisitedNodes();
    }

}
