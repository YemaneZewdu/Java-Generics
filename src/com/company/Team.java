package com.company;

import java.util.ArrayList;

// base class
// <T> generic type public class Team<T>
// <T extends Player> restricting the type parameter
// this class accepts when using Generics,
// will be any tpe that extends Player or subclass of Player
// ' extends Player' Player is called Upper bound of Team
// implements Comparable<Team>
public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    // <T> generic type
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            // ugly casting
           // System.out.println(((Player) player).getName() + " is already on the team" + this.name);
            System.out.println( player.getName() + " is already on the team" + this.name);            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " is picked for " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return members.size();
    }

    public void matchResult (Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            won++;
            message = " beat ";

        } else if (ourScore == theirScore){
            tied++;
            message = " drew with ";
        }
        else {
            lost++;
            message = " lost to ";
        }
        played++;
        // getting the result for the opponents team,
        // passing null so that this code won't run again
        if (opponent !=null){
            System.out.println(getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }
        // just keeping it simple
    public  int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (ranking() > team.ranking()){
            return  -1;
        }else if (ranking() < team.ranking()){
            return  1;
        }
        else {
            return 0;
        }
    }
}
