package com.altimetrik.rulesmanager.drool.model;

import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JacksonXmlRootElement(localName = "kmodule")
public class Kmodule {
  @JacksonXmlProperty(isAttribute = true)
  private String xmlns;
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Kbase> kbase;
}
