package net.thequester.utility;

import net.thequester.model.QuestLocation;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author tdubravcevic
 */
public class Utility {

    public static Connection getLocalConnection(PrintWriter out){

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch(Exception e) {
            out.println("Exception: " + e.getMessage());
            return null;
        }

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/quester", "root", "root");

        } catch(Exception e) {
            //TODO throw exception
            out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static double distanceInMeters(QuestLocation to, QuestLocation from) {

        double a1 = to.getLatitude() * Math.PI / 180;
        double a2 = to.getLongitude() * Math.PI / 180;
        double b1 = from.getLatitude() * Math.PI / 180;
        double b2 = from.getLongitude() * Math.PI / 180;

        double t = Math.sin(a1)*Math.sin(b1) + Math.cos(a1)*Math.cos(b1)*Math.cos(a2 - b2);
        double tt = Math.acos(t);

        return 6366000 * tt;
    }
}
