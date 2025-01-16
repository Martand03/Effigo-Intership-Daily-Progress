package com.inEffigo.learn_spring_framework.game.examples.exercise;

import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;

@ComponentScan
public class BusinessCalculationService {


    private DataService dataService;

    public BusinessCalculationService(DataService dataService){
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retreiveData()).max().orElse(0);
    }

}
