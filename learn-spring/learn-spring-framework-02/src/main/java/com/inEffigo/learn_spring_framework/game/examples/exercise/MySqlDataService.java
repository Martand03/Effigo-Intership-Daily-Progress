package com.inEffigo.learn_spring_framework.game.examples.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataService {

    @Override
    public int[] retreiveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
