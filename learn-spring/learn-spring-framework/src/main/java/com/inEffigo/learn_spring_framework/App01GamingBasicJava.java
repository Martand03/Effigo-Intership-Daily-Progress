package com.inEffigo.learn_spring_framework;

import com.inEffigo.learn_spring_framework.game.GameRunner;
import com.inEffigo.learn_spring_framework.game.MarioGame;
import com.inEffigo.learn_spring_framework.game.PacManGame;
import com.inEffigo.learn_spring_framework.game.SuperContractGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        // var: allows the compiler to infer the type of the variable based on value assigned

        // here var = MarioGame
//        var game = new MarioGame();

//        var game = new SuperContractGame();

        // here pacman game
        var game = new PacManGame();

        // here var = GameRunner
        var gameRunner = new GameRunner(game); //2: Object Creation + wiring dependencies
        // Game is a dependency of GameRunner
        gameRunner.run();
    }
}