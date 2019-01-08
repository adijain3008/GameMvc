package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Player;

public interface PlayerDao {

	String addPlayer(Player player);

	Player getPlayerById(int id);

	List<Player> getAllPlayers();

	String updatePlayer(Player player);
}
