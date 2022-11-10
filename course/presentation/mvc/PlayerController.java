package com.example.springbootfirst.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.configuration.MyBean;
import com.example.springbootfirst.data.entity.Player;
import com.example.springbootfirst.data.repository.PlayerRepository;


@Controller
@RequestMapping("/sports")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MyBean myBean;
	
	
	
	@GetMapping("/player/byteam")
	@ResponseBody
	public String getPlayersByTeam() {
		
		System.out.println("Çekirdek " + myBean.getMyLong() + " " + myBean.getMyDouble() +" " + myBean.getMyString());
		
		int teamId = 1;
		
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		double totalScore=0;
	
		
		for(Player p: players) {
			
			System.out.println(p.getPlayerId() + " " + p.getPlayerName() + " " + p.getAvarageScore());
			
			totalScore += p.getAvarageScore();
		}
		
		double result = totalScore / players.size();
		
		System.out.println(result);
		//productRepository.findById(productId);
		return "Average Total Score: " + result;
		

		
	}

}
