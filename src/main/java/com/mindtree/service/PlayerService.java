package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Player;

public interface PlayerService {

	String addPlayer(Player player);

	Player getPlayerById(int id);

	List<Player> getAllPlayers();

	String updatePlayer(Player player);
}
