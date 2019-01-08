package com.mindtree.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.TeamDao;
import com.mindtree.entity.Team;
import com.mindtree.util.DbUtils;

@Repository
public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeam(Team team) {
		Session session = DbUtils.createConnection();
		Transaction txn = session.beginTransaction();
		session.merge(team);
		txn.commit();
		return "team added";
	}

	@Override
	public Team getTeamById(int id) {
		Session session = DbUtils.createConnection();
		session.beginTransaction();
		return session.get(Team.class, id);
	}

	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = new ArrayList<>();
		Session session = DbUtils.createConnection();
		session.beginTransaction();
		Query query = session.createQuery("from Team");
		teams = query.getResultList();
		System.out.println(teams);
		return teams;
	}
}