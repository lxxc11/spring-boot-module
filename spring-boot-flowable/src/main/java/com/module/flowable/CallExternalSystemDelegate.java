package com.module.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/11/29 20:17
 **/
public class CallExternalSystemDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("calling the external system for employee" + execution.getVariable("employee"));
  }
}
