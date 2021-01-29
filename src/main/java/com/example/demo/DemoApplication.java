package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@ImportResource({"classpath:applicationContext-mvc.xml"})
@Api(tags = "echo controller")
@Controller
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }




  @GetMapping("/echo/{str}")
  @ApiOperation(value = "echo str", notes = "echo str")
  public ResponseEntity<String> echo(@PathVariable String str){
    return ResponseEntity.ok(str);
  }
}
