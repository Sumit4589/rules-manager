package com.altimetrik.rulesmanager.drool.adapter;

import org.springframework.stereotype.Component;
import com.altimetrik.rulesmanager.drool.model.Kbase;
import com.altimetrik.rulesmanager.drool.model.Ksession;
import com.altimetrik.rulesmanager.drool.model.RulesRequest;

@Component
public class KbaseAdapter {

  public Kbase transform(RulesRequest rulesRequest) throws Exception {
    Kbase kbase = new Kbase();
    kbase.setPackages(rulesRequest.getRulePackage());
    Ksession ksession = new Ksession();
    ksession.setName(rulesRequest.getSessionName());
    ksession.setType(rulesRequest.getSessionType().toString());
    kbase.setKsession(ksession);
    return kbase;
  }

}
