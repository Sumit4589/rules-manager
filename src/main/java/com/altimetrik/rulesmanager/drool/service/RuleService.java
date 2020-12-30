package com.altimetrik.rulesmanager.drool.service;

import com.altimetrik.rulesmanager.drool.model.ResponsePayload;
import com.altimetrik.rulesmanager.drool.model.RulesRequest;

public interface RuleService {

  ResponsePayload createRule(RulesRequest rulesRequest) throws Exception;

}
