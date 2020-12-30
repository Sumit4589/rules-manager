package com.altimetrik.rulesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class RulesManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RulesManagerApplication.class, args);
  }

}
