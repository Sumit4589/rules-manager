package com.altimetrik.rulesmanager.drool.model;

import java.util.List;
import com.altimetrik.rulesmanager.drool.constant.SessionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class RulesRequest {

  private String rulePackage;
  private String ruleFileName;
  private SessionType sessionType;
  private String sessionName;
  private List<String> globals;
  private List<RuleRequest> rules;

}
