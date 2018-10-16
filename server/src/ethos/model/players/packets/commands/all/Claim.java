package ethos.model.players.packets.commands.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ethos.Config;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.packets.commands.Command;


import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

/**
 * Auto Donation System 
 * @author Celtech
 *
 */

public class Claim extends Command {
	
    private Connection conn;
    private Statement stmt;
	
	@Override
	public void execute(Player player, String input) {
		new java.lang.Thread() {
			public void run() {
				try {
		            if (!connect(Config.HOST, Config.DATABASE, Config.USER, Config.PASS)) {
		                return;
		            }

		            String name = player.playerName;
		            ResultSet rs = executeQuery("SELECT * FROM game_payments WHERE player_name='" + name + "' AND payment_status='Completed' AND claimed=0");
		            int itemsRedeemed = 0;
		            while (rs.next()) {
		                int item_number = 0;

		                item_number = rs.getInt("item_id");
		                int quantity = rs.getInt("quantity");

		                switch (item_number) {
		                    case 2697:
		                    	player.getItems().addItem(2697, 1);//10
		                        player.getItems().addItem(1464, 10);
		                        break;
		            		case 2698:
		            			player.getItems().addItem(2698, 1);//50
		                        player.getItems().addItem(1464, 50);
		            			break;
		            		case 2699:
		            			player.getItems().addItem(2699, 1);//150
		                        player.getItems().addItem(1464, 150);
		            			break;
		            		case 2700:
		            			player.getItems().addItem(2700, 1);//300
		                        player.getItems().addItem(1464, 300);
		            			break;
		                }

		                rs.updateInt("claimed", 1); 
		                rs.updateRow();
		                itemsRedeemed++;
		            }
		            
		            if(itemsRedeemed == 0) {
		            	player.sendMessage("You currently don't have any items waiting. You must donate first!");
		            } else {
		            	player.sendMessage("Thank you for your donation!");
		            }
		            
		            destroyCon();
		            return;
		        }catch (SQLException e) {
		            e.printStackTrace();
		        }
			}
		}.start();
	}

	
	/**
    *
    * @param host the host ip address or url
    * @param database the name of the database
    * @param user the user attached to the database
    * @param pass the users password
    * @return true if connected
    */
   public boolean connect(String host, String database, String user, String pass) {
       try {
           this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, user, pass);
           System.out.print("Connected");
           return true;
       } catch (SQLException e) {
           System.out.println("Failing connecting to database!");
           return false;
       }
   }

   /**
    * Disconnects from the MySQL server and destroy the connection
    * and statement instances
    */
   public void destroyCon() {
       try {
           conn.close();
           conn = null;
           if (stmt != null) {
               stmt.close();
               stmt = null;
           }
       } catch(Exception e) {
           e.printStackTrace();
       }
   }

   /**
    * Executes an update query on the database
    * @param query
    * @see {@link Statement#executeUpdate}
    */
   public int executeUpdate(String query) {
       try {
           this.stmt = this.conn.createStatement(1005, 1008);
           int results = stmt.executeUpdate(query);
           return results;
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return -1;
   }

   /**
    * Executres a query on the database
    * @param query
    * @see {@link Statement#executeQuery(String)}
    * @return the results, never null
    */
   public ResultSet executeQuery(String query) {
       try {
           this.stmt = this.conn.createStatement(1005, 1008);
           ResultSet results = stmt.executeQuery(query);
           return results;
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return null;
   }
}
