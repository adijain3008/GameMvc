package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Team;

public interface TeamDao {
	
	String addTeam(Team team);

	Team getTeamById(int id);

	List<Team> getAllTeams();
}
