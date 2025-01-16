package com.inEffigo.learn_spring_framework.game;

public class GameRunner {

//    MarioGame game;

    private GamingConsole game;

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        System.out.println("Running game" + game);
        game.upButton();
        game.downButton();
        game.leftButton();
        game.rightButton();
    }
}
