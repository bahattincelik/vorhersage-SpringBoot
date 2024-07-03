package com.example.vorhersageSpringBoot.service;

import com.example.vorhersageSpringBoot.repository.HailoRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HailoService implements HailoRepository {

    final Random random = new Random();

    @Override
    public int createRandom(){
        int rand = random.nextInt(51);
        return rand;
    }
}
