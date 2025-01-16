package com.inEffigo.learn_spring_framework;

import com.inEffigo.learn_spring_framework.game.GameRunner;
import com.inEffigo.learn_spring_framework.game.GamingConsole;
import com.inEffigo.learn_spring_framework.game.PacManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

        context.getBean(GamingConsole.class).upButton();

        context.getBean(GameRunner.class).run();
    }
}