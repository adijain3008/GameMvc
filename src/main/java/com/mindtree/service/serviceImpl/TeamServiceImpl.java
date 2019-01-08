package com.mindtree.service.serviceImpl;

import java.util.List;

import com.mindtree.dao.TeamDao;
import com.mindtree.dao.daoImpl.TeamDaoImpl;
import com.mindtree.entity.Team;
import com.mindtree.service.TeamService;

public class TeamServiceImpl implements TeamService {
	
	private TeamDao teamDao = new TeamDaoImpl();

	@Override
	public String addTeam(Team team) {
		return teamDao.addTeam(team);
	}

	@Override
	public Team getTeamById(int id) {
		return teamDao.getTeamById(id);
	}

	@Override
	public List<Team> getAllTeams() {
		return teamDao.getAllTeams();
	}
}