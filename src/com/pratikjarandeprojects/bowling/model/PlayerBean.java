package com.pratikjarandeprojects.bowling.model;

import java.util.List;


public class PlayerBean implements Comparable<PlayerBean>{
	private String playerName;
	private List<FrameBean> frameBeans;
	private int totalScore;
	public PlayerBean() {
		super();
	}
	public PlayerBean(String playerName) {
		super();
		this.playerName = playerName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<FrameBean> getFrameBeans() {
		return frameBeans;
	}
	public void setFrameBeans(List<FrameBean> frameBeans) {
		this.frameBeans = frameBeans;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	@Override
	public String toString() {
		return "PlayerBean [playerName=" + playerName + ", frameBeans="
				+ frameBeans + ", totalScore=" + totalScore + "]";
	}
	@Override
	public int compareTo(PlayerBean o) {
		if(this.totalScore>o.getTotalScore())
			return -1;
		else if(this.totalScore<o.getTotalScore())
			return 1;
		else
			return 0;
	}
}
