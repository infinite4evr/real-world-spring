package com.udemy1.demo.common;

import org.springframework.stereotype.Component;

@Component
public class Person {
  public String name = "Sudhanshu";

  Person() {
    this.name = "Sudhanshu Constructor";
  }

}
