package com.mindtree.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.service.PlayerService;
import com.mindtree.service.TeamService;
import com.mindtree.service.serviceImpl.PlayerServiceImpl;
import com.mindtree.service.serviceImpl.TeamServiceImpl;

@Controller
public class MainController {

	PlayerService playerService = new PlayerServiceImpl();
	TeamService teamService = new TeamServiceImpl();
	
	@RequestMapping("index")
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}

	@RequestMapping("addPlayer")
	public ModelAndView addPlayerPage() {
		return new ModelAndView("addPlayer");
	}

	@RequestMapping(value = "addPlayer", method = RequestMethod.POST)
	public ModelAndView addPlayer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showPlayers");

		Player player = new Player();
		player.setId(Integer.parseInt(request.getParameter("id")));
		player.setName(request.getParameter("name"));
		player.setType(request.getParameter("type"));
		player.setAge(Integer.parseInt(request.getParameter("age")));
		player.setBattingAvg(Double.parseDouble(request.getParameter("battingAvg")));
		player.setBowlingAvg(Double.parseDouble(request.getParameter("bowlingAvg")));

		String result = playerService.addPlayer(player);
		modelAndView.addObject("list", playerService.getAllPlayers());
		modelAndView.addObject("message", result);

		return modelAndView;
	}

	@RequestMapping("getAllPlayers")
	public ModelAndView getAllPlayers() {
		List<Player> players = new ArrayList<>();
		players = playerService.getAllPlayers();
		return new ModelAndView("showPlayers", "list", players);
	}

	@RequestMapping("addTeam")
	public ModelAndView addTeamPage() {
		List<Player> availablePlayers = new ArrayList<>();
		availablePlayers = playerService.getAllPlayers().stream().filter(ap -> ap.isBookingStatus() == false)
				.collect(Collectors.toList());
		return new ModelAndView("addTeam", "list", availablePlayers);
	}

	@RequestMapping(value = "addTeam", method = RequestMethod.POST)
	public ModelAndView addTeam(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showTeams");

		List<String> playersName = Arrays.asList(request.getParameterValues("teamPlayers"));
		List<Player> players = new ArrayList<>();
		
		Team team = new Team();
		team.setId(Integer.parseInt(request.getParameter("id")));
		team.setName(request.getParameter("name"));
		team.setCountry(request.getParameter("country"));
		
		
		for (int i = 0; i < playersName.size(); i++) {
			Player player = playerService.getPlayerById(Integer.parseInt(playersName.get(i)));
			player.setBookingStatus(true);
			players.add(player);
			player.setTeam(team);
			playerService.updatePlayer(player);
		}

		team.setPlayers(players);

		String result = teamService.addTeam(team);
		modelAndView.addObject("message", result);
		modelAndView.addObject("list", teamService.getAllTeams());
		
		return modelAndView;
	}
	
	@RequestMapping("getAllTeams")
	public ModelAndView getAllTeams() {
		List<Team> teams = new ArrayList<>();
		teams = teamService.getAllTeams();
		return new ModelAndView("showTeams", "list", teams);
	}
}