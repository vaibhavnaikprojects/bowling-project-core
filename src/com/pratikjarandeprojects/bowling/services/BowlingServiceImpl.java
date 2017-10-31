package com.pratikjarandeprojects.bowling.services;

import java.util.ArrayList;
import java.util.List;

import com.pratikjarandeprojects.bowling.model.PlayerBean;

public class BowlingServiceImpl implements BowlingService{

	private static List<PlayerBean> playerBeans=new ArrayList<PlayerBean>();
	
	@Override
	public List<PlayerBean> getPlayers() {
		return playerBeans;
	}

	@Override
	public void addPlayer(String playerName) {
		PlayerBean bean=new PlayerBean(playerName);
		playerBeans.add(bean);
	}
	
}
