package com.inEffigo.learn_spring_framework;

import com.inEffigo.learn_spring_framework.game.GameRunner;
import com.inEffigo.learn_spring_framework.game.GamingConsole;
import com.inEffigo.learn_spring_framework.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        return new PacManGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole gamingConsole){
        return new GameRunner(gamingConsole);
    }

}
