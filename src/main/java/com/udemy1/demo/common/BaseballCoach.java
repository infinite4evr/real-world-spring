package com.udemy1.demo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Primary
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Qualifier("BaseballCoach")
public class BaseballCoach implements Coach {

  @Override
  public String coachMe() {
    return "Baseball Coach";
  }

  @PostConstruct
  public void initializingAfterPOst() {
    System.out.println("post constructor");
  }

  @PreDestroy
  public void destroying() {
    System.out.println("Pre Destory");
  }

}
