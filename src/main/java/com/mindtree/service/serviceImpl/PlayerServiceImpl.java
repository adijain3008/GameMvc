package com.mindtree.service.serviceImpl;

import java.util.List;

import com.mindtree.dao.PlayerDao;
import com.mindtree.dao.daoImpl.PlayerDaoImpl;
import com.mindtree.entity.Player;
import com.mindtree.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
	
	private PlayerDao playerDao = new PlayerDaoImpl();

	@Override
	public String addPlayer(Player player) {
		return playerDao.addPlayer(player);
	}

	@Override
	public Player getPlayerById(int id) {
		return playerDao.getPlayerById(id);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

	@Override
	public String updatePlayer(Player player) {
		return playerDao.updatePlayer(player);
	}
}