package net.thequester.processor;

import net.thequester.database.IGameProvider;
import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

import java.util.List;

/**
 * @author tdubravcevic
 */
public class GameProcessor {

    private QuestProcessor questProcessor;
    private IGameProvider gameProvider;

    private Game game;

    /**
     * processes the location and sets new current node
     * @param location given by the locationClient
     */
    public void processLocation(QuestLocation location){

        Node node = questProcessor.processLocation(game.getCurrentNode(), location);
        if(node!=null){
            game.setCurrentNode(node);
        }
    }

    public void startQuest(Quest quest){

        questProcessor = new QuestProcessor(quest);
        game = gameProvider.getGame(quest);
    }

    public List<Node> getVisitedNodes(){
         return game.getVisitedNodes();
    }

}
