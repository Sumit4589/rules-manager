package com.altimetrik.rulesmanager.drool.service;

import com.altimetrik.rulesmanager.drool.model.Kbase;

public interface KmoduleService {

  public boolean createOrUpdate(Kbase kbase) throws Exception;
  
}
