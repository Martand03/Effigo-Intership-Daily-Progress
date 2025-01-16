package com.inEffigo.learn_spring_framework.game.examples.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService{

    @Override
    public int[] retreiveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
