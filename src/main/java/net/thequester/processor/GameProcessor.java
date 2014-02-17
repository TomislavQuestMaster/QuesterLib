package net.thequester.processor;

import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

import java.util.List;

/**
 * @author tdubravcevic
 */
public class GameProcessor {

    private Game game;
    private QuestProcessor questProcessor;

    public void startQuest(Quest quest){

        questProcessor = new QuestProcessor(quest);
        game = new Game();
        //TODO who loads the game
    }

    /**
     * goes trough visitable nodes and sets new current node
     * @param location given by the locationClient
     * @return true if a child of the current node is at location, false otherwise
     */
    public boolean checkLocation(QuestLocation location){

        for(Node child : questProcessor.getChildren(game.getCurrentNode())){

            if(questProcessor.isNodeAtLocation(child,location)){
                 game.setCurrentNode(child);
                    return true;
            }
        }

        return false;
    }

    public List<Node> getVisitedNodes(){
         return game.getVisitedNodes();
    }

}
