package ethos.database;


import java.sql.*;
import java.util.Optional;

import ethos.Config;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class DonationHandler implements Runnable {

    private Player player;
    private Connection conn;
    private Statement stmt;


    public DonationHandler(Player player) {
        this.player = player;
    }

    @Override
    public void run(){
        
    }

}
