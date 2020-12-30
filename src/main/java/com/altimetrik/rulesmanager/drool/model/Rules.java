package com.altimetrik.rulesmanager.drool.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rules {
  
  private String ruleFile;
  private String packageName;
  private List<String> imports;
  private List<String> globals;
  private List<Rule> rules;

}
