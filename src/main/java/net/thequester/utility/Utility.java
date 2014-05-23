package net.thequester.utility;

import net.thequester.model.QuestLocation;

import static java.lang.Math.*;

/**
 * @author tdubravcevic
 */
public class Utility {

	public static double distanceInMeters(QuestLocation to, QuestLocation from) {

		double toLat = to.getLatitude();
		double toLon = to.getLongitude();
		double fromLat = from.getLatitude();
		double fromLon = from.getLongitude();

		return 6373000 * acos((sin(toLat) * sin(fromLat)) + (cos(toLat) * cos(fromLat) * cos(toLon - fromLon)));
	}
}
