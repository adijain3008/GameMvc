package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Team;

public interface TeamService {
	
	String addTeam(Team team);

	Team getTeamById(int id);

	List<Team> getAllTeams();
}
