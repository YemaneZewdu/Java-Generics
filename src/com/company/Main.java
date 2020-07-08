package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        League<Team<SoccerPlayer>> soccerLeague = new League<>("EPL");
        Team<SoccerPlayer> united = new Team<>("United");
        Team<SoccerPlayer> liverpool = new Team<>("Liverpool");

        soccerLeague.add(united);
        soccerLeague.add(liverpool);

        united.matchResult(liverpool, 5,0);
        liverpool.matchResult(united, 0, 5);

        soccerLeague.showLeagueTable();
    }
}
