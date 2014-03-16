package net.thequester.database;

import net.thequester.model.Game;
import net.thequester.model.Quest;

/**
 * Created by Tomo.
 */
public interface IGameProvider {

    Game getGame(Quest quest);

}
