package com.altimetrik.rulesmanager.drool.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rule {
  
  private String ruleName;
  private String dialect = "mvel";
  private String when;
  private String then;

}
