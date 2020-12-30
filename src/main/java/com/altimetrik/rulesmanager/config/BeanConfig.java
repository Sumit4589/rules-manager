package com.altimetrik.rulesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

@Configuration
public class BeanConfig {
  
  @Bean
  public XmlMapper xmlMapper() {
    XmlMapper mapper = new XmlMapper();
    mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    return mapper;
  }
  
  @Bean
  public ObjectMapper objectMapper() {
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

      return mapper;
  }

}
