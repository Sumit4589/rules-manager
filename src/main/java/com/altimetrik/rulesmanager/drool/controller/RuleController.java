package com.altimetrik.rulesmanager.drool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.altimetrik.rulesmanager.drool.model.ResponsePayload;
import com.altimetrik.rulesmanager.drool.model.RulesRequest;
import com.altimetrik.rulesmanager.drool.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("rule")
@Api(value = "Rules Controller", description = "Rules managing Apis")
public class RuleController {

  @Autowired
  private RuleService ruleService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a new Rules")
  public ResponseEntity<ResponsePayload> createRule(@RequestBody RulesRequest rulesRequest)
      throws Exception {

    ResponsePayload payload = ruleService.createRule(rulesRequest);
    return new ResponseEntity<ResponsePayload>(payload, HttpStatus.OK);
  }

}
