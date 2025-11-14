package com.controller;

import com.mapper.ScoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scores")
public class ScoresController {
    @Autowired
    private ScoresMapper scoresMapper;




}
