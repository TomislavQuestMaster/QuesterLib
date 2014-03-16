package net.thequester.processor;

import net.thequester.model.QuestLocation;

/**
 * Created by Tomo.
 */
public interface IGameEngine {

    /**
     * processes the location and sets new current node
     * @param location given by the locationClient
     */
    void processLocation(QuestLocation location);
}
