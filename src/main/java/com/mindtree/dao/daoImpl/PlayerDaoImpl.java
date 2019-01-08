package com.mindtree.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.PlayerDao;
import com.mindtree.entity.Player;
import com.mindtree.util.DbUtils;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayer(Player player) {
		Session session = DbUtils.createConnection();
		Transaction txn = session.beginTransaction();
		session.merge(player);
		txn.commit();
		return "player added";
	}

	@Override
	public Player getPlayerById(int id) {
		Session session = DbUtils.createConnection();
		session.beginTransaction();
		return session.get(Player.class, id);
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		Session session = DbUtils.createConnection();
		session.beginTransaction();
		Query query = session.createQuery("from Player");
		players = query.getResultList();
		System.out.println(players);
		return players;
	}
	
	@Override
	public String updatePlayer(Player player) {
		Session session = DbUtils.createConnection();
		Transaction txn = session.beginTransaction();
		session.update(player);
		txn.commit();
		return "player updated";
	}

	
}
