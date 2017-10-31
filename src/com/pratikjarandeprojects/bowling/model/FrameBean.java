package com.pratikjarandeprojects.bowling.model;

public class FrameBean {
	private int frameNo;
	private int firstScore;
	private int secondScore;
	private int thirdScore;
	private boolean spare;
	private boolean strike;
	private int frameScore;
	public int getFrameNo() {
		return frameNo;
	}
	public void setFrameNo(int frameNo) {
		this.frameNo = frameNo;
	}
	public int getFirstScore() {
		return firstScore;
	}
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}
	public int getSecondScore() {
		return secondScore;
	}
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}
	public int getThirdScore() {
		return thirdScore;
	}
	public void setThirdScore(int thirdScore) {
		this.thirdScore = thirdScore;
	}
	public int getFrameScore() {
		return frameScore;
	}
	public void setFrameScore(int frameScore) {
		this.frameScore = frameScore;
	}
	public boolean isSpare() {
		return spare;
	}
	public void setSpare(boolean spare) {
		this.spare = spare;
	}
	public boolean isStrike() {
		return strike;
	}
	public void setStrike(boolean strike) {
		this.strike = strike;
	}
	@Override
	public String toString() {
		return "FrameBean [frameNo=" + frameNo + ", firstScore=" + firstScore
				+ ", secondScore=" + secondScore + ", thirdScore=" + thirdScore
				+ ", spare=" + spare + ", strike=" + strike + ", frameScore="
				+ frameScore + "]";
	}
}
