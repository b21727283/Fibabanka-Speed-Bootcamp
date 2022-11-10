package com.example.springbootfirst.presentation.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.data.entity.Player;
import com.example.springbootfirst.data.entity.Team;
import com.example.springbootfirst.data.repository.TeamRepository;

@Controller
@RequestMapping("/sports")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	/*public TeamController(TeamRepository teamRepository) {
		
		this.teamRepository = teamRepository;
	}*/
	
	@GetMapping("/team/insert")
	@ResponseBody
	public String insertTeam() {
		
		
		Team teamA = new Team(0, "Godoro Spor");
		teamA.setPlayers(new ArrayList<>());
		
		
		Player player1 = new Player(0, "Barış Manço", 76.12);
		player1.setTeam(teamA);
		teamA.getPlayers().add(player1);
		
		Player player2 = new Player(0, "Fikret Kızılok", 34.55);
		player2.setTeam(teamA);
		teamA.getPlayers().add(player2);
		
		Player player3 = new Player(0, "Cem Karaca", 54.21);
		player3.setTeam(teamA);
		teamA.getPlayers().add(player3);
		
		
		teamRepository.save(teamA);
		
		
		
		return "Sokuldu: " + teamA.getTeamId();
		

		
	}

}
