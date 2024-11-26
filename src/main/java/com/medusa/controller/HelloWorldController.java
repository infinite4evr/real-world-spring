package com.medusa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medusa.common.Coach;

@RestController
public class HelloWorldController {

  private Coach coach;

  @Autowired
  @Qualifier("BaseballCoach")
  public void setCoach(Coach coach) {
    this.coach = coach;
  }

  @GetMapping("/")
  public String sayHello() {
    return "hello world";
  }

  @GetMapping("/workout")
  public String getWorkout() {
    return this.coach.coachMe();
  }

}
