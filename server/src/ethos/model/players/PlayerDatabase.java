package ethos.model.players;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ethos.Config;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;

/**
 * 
 * @author Celtech
 *
 */
public class PlayerDatabase {
	public static Connection con = null;
	public static Statement stm;

	public static boolean createCon() {
		if (Config.BLOCK_SQL) {
			return false;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://"+Config.HOST+":3306/"+Config.DATABASE+"", Config.USER, Config.PASS);
			stm = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void destroyCon() {
		try {
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public static boolean addPlayerToDataBase(String username, String password) {
		try {
			if (Config.BLOCK_SQL || !createCon()) {
				return false;
			}
			
			PreparedStatement stmt2 = con.prepareStatement("REPLACE INTO users (username, password, email, rights) VALUES (?, ?, ?, ?)");
			stmt2.setString(1, username);
			stmt2.setString(2, password);
			stmt2.setString(3, "dummyemail@lol.com");
			stmt2.setInt(4, 0);
			stmt2.execute();
			
			System.out.println("Saving Player to DB.");
			destroyCon();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean loadPlayerFromDataBase(String username, String password) {
		try {
			if (Config.BLOCK_SQL || !createCon()) {
				return false;
			}
			
			PreparedStatement stmt2 = con.prepareStatement("REPLACE INTO users (username, password, email, rights) VALUES (?, ?, ?, ?)");
			stmt2.setString(1, username);
			stmt2.setString(2, password);
			stmt2.setString(3, "dummyemail@lol.com");
			stmt2.setInt(4, 0);
			stmt2.execute();
			
			System.out.println("Saving Player to DB.");
			destroyCon();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
