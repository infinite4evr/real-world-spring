package com.realworld.controller;

import com.realworld.service.MailClientService;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/orders")
@AllArgsConstructor
public class OrderController {
  private final MailClientService mailClientService;

  @PostMapping("send-email")
  public ResponseEntity<?> sendMail() throws Exception {

    String templatePath = "templates/email/welcome-email.html";

    System.out.println("Order controller called");

    mailClientService.send(
        "rss@sudhanshukumar.dev",
        "ggs.sudhanshu@gmail.com",
        "hello",
        new String(Files.readAllBytes(Paths.get(new ClassPathResource(templatePath).getURI())))
            .replace("{{name}}", "Sudhanshu"));

    System.out.println("Order controller returning");

    return ResponseEntity.ok().body("Mail triggered");
  }
}
