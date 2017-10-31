package com.pratikjarandeprojects.bowling.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.pratikjarandeprojects.bowling.exceptions.ServicesNotFoundException;
import com.pratikjarandeprojects.bowling.model.FrameBean;
import com.pratikjarandeprojects.bowling.model.PlayerBean;
import com.pratikjarandeprojects.bowling.providers.BowlingServiceProvider;
import com.pratikjarandeprojects.bowling.services.BowlingService;

public class Client {
	public static void main(String args[]){ 
		Scanner scanner=new Scanner(System.in);
		try {
			BowlingService bowlingService = BowlingServiceProvider.BowlingServProvider();
			try{
				System.out.println("\n-------Bowling-------\nNumber of players: ");
				String playerCountStr=scanner.next();
				int playerCount=0;
				playerCount=Integer.parseInt(playerCountStr);
				System.out.println("---------Player Profile--------");
				for (int i = 0; i < playerCount; i++) {
					System.out.println("What is the name of player"+(i+1)+"?");
					String playerName=scanner.next();
					bowlingService.addPlayer(playerName);
				}
				System.out.println("---------Let The Game Start--------");
				List<PlayerBean> playerBeans=bowlingService.getPlayers();
				for(int i=0;i<10;i++){
					System.out.println("---------Frame "+(i+1)+"--------");
					for (PlayerBean playerBean : playerBeans) {
						List<FrameBean> frameBeans= playerBean.getFrameBeans();
						if(frameBeans==null)	frameBeans=new ArrayList<FrameBean>();
						FrameBean frameBean=new FrameBean();
						frameBean.setFrameNo(i+1);
						System.out.println("Enter first throw for "+playerBean.getPlayerName()+": ");
						int firstThrow=scanner.nextInt();
						while(firstThrow<0 || firstThrow>10){
							System.out.println("Please hit pins in the range 0-10");
							System.out.println("Enter first throw for "+playerBean.getPlayerName()+": ");
							firstThrow=scanner.nextInt();
						}
						frameBean.setFirstScore(firstThrow);
						if(firstThrow==10 && i!=9){
							frameBean.setStrike(true);
							frameBeans.add(frameBean);
							playerBean.setFrameBeans(frameBeans);
							continue;
						}
						else if(i==9)
							frameBean.setStrike(true);
						else
							frameBean.setStrike(false);
						frameBean.setStrike(false);
						System.out.println("Enter second throw for "+playerBean.getPlayerName()+": ");
						int secondThrow=scanner.nextInt();
						while(secondThrow<0 || secondThrow>(10-firstThrow)){
							System.out.println("Please hit pins in the range 0-"+(10-firstThrow));
							System.out.println("Enter second throw for "+playerBean.getPlayerName()+": ");
							secondThrow=scanner.nextInt();
						}
						frameBean.setSecondScore(secondThrow);
						if((frameBean.getFirstScore()+frameBean.getSecondScore())==10)
							frameBean.setSpare(true);
						else
							frameBean.setSpare(false);
						if(i==9){
							System.out.println("Enter third throw for "+playerBean.getPlayerName()+": ");
							int thirdThrow=scanner.nextInt();
							while(thirdThrow<0 || thirdThrow>10){
								System.out.println("Please hit pins in the range 0-10");
								System.out.println("Enter third throw for "+playerBean.getPlayerName()+": ");
								thirdThrow=scanner.nextInt();
							}
							frameBean.setThirdScore(thirdThrow);
						}
						frameBeans.add(frameBean);
						playerBean.setFrameBeans(frameBeans);
					}
					createGrid(playerBeans,i+1);
				}
				System.out.println("Winner is: "+getWinner(playerBeans));
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("TRY AGAIN LATER");
			}
		} catch (ServicesNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		scanner.close();
	}
	private static String getWinner(List<PlayerBean> playerBeans) {
		Collections.sort(playerBeans);
		return playerBeans.get(0).getPlayerName();
	}
	private static void createGrid(List<PlayerBean> playerBeans,int frameNo) {
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|Name\t\t|\t1\t|\t2\t|\t3\t|\t4\t|\t5\t|\t6\t|\t7\t|\t8\t|\t9\t|\t10\t|\tFinal Score\t|");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (PlayerBean playerBean : playerBeans) {
			List<FrameBean> frameBeans=playerBean.getFrameBeans();
			playerBean.setTotalScore(0);
			StringBuilder builder1=new StringBuilder("|"+playerBean.getPlayerName()+"\t\t|");
			StringBuilder builder2=new StringBuilder("|\t\t|");
			for (int i=0;i<10;i++){
				FrameBean frameBean=null;
				try {
					frameBean = frameBeans.get(i);
				} catch (Exception e) {
					frameBean=null;
				}
				builder1.append("\t"+(frameBean!=null ?frameBean.getFirstScore()==10?"X":frameBean.getFirstScore()==0?"-":frameBean.getFirstScore():" ")+"|"+(frameBean!=null?frameBean.getFirstScore()!=10 && frameBean.getFirstScore()+frameBean.getSecondScore()==10?"/":frameBean.getSecondScore()==0?"-":frameBean.getSecondScore():" ")+(i==9?"|":"")+(frameBean!=null && i==9?frameBean.getThirdScore():" ")+"\t|");
				if(frameBean!=null){
					playerBean.setTotalScore(frameBean.getFirstScore()+frameBean.getSecondScore()+playerBean.getTotalScore());
				}
				builder2.append("\t"+(frameBean!=null?playerBean.getTotalScore():" ")+"\t|");
			}
			System.out.println(builder1.toString());
			System.out.println(builder2.toString());
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

	}
}
