package com.altimetrik.rulesmanager.drool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altimetrik.rulesmanager.drool.adapter.KbaseAdapter;
import com.altimetrik.rulesmanager.drool.model.Kbase;
import com.altimetrik.rulesmanager.drool.model.ResponsePayload;
import com.altimetrik.rulesmanager.drool.model.RulesRequest;

@Service
public class RuleServiceImpl implements RuleService {

  @Autowired
  private KbaseAdapter kbaseAdapter;

  @Autowired
  private KmoduleService kmoduleService;

  @Override
  public ResponsePayload createRule(RulesRequest rulesRequest) throws Exception {

    Kbase kbase = kbaseAdapter.transform(rulesRequest);
    boolean recUpdated = kmoduleService.createOrUpdate(kbase);
    ResponsePayload payload = ResponsePayload.builder().message("Rule created").build();
    return payload;
  }

}
