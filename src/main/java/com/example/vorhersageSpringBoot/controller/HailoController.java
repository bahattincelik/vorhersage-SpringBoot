package com.example.vorhersageSpringBoot.controller;

import com.example.vorhersageSpringBoot.model.Hailo;
import com.example.vorhersageSpringBoot.service.HailoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class HailoController {

    @Autowired
    HailoService hailoService;


    @PostMapping("/number")
    public String number(@RequestBody Hailo hailo){
        ArrayList<Integer> numbers = hailo.getNumbers();
        Integer frequency=numbers.stream().
                filter(number -> Collections.frequency(numbers, number)>1).
                findFirst().orElse(0);

        if(frequency==0){
            int random = hailoService.createRandom();
            int temp = 50;
            for (int number : numbers) {
                if (Math.abs(random-number)<temp) {
                    temp=Math.abs(random-number);
                }
            }
            int percent=100-(temp*2);
            return "Percent: " + percent+"  -  "+ "Vorhersage: "+ random;
        }
        else{
            return "Es gibt wiederkehrende Nummer";
        }
    }
}
