package com.realworld.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CricketCoach")
public class CricketCoach implements Coach {
  private Person person;

  CricketCoach() {
    System.out.println("Coach initialized");
  }

  @Autowired
  public void setPerson(Person person) {
    System.out.println("Setter called");
    this.person = person;
  }

  public String coachMe() {
    return "Cricket Coach";
  }
}
