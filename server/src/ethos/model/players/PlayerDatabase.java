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
import ethos.util.Misc;

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
			
			//@TODO
			
			
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
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM  `smf_members` WHERE member_name=? AND passwd=?");
			stmt.setString(1, username);
			stmt.setString(2, Misc.sha1(username.toLowerCase()+password));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}

			System.out.println("Loading Player from DB.");
			stmt.close();
			destroyCon();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
}
