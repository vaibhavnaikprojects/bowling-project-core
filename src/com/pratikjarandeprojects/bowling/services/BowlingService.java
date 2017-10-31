package com.pratikjarandeprojects.bowling.services;

import java.util.List;

import com.pratikjarandeprojects.bowling.model.PlayerBean;

public interface BowlingService {
	public List<PlayerBean> getPlayers();
	public void addPlayer(String playerName);

}
