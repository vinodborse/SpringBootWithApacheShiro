/*
 * Copyright (c) 2016 Project Vision Inc.
 * All Rights Reserved
 *
 * This software contains the intellectual property of Project Vision Inc.
 * or is licensed to  Project Vision Inc. from third parties. Use of this
 * software and the intellectual property contained therein is expressly limited
 * to the terms and conditions of the License Agreement under which it is
 * provided by or on behalf of Project Vision Inc.
 */
package com.springbootshiro.vinu.topic.response;

/**
 * @version 1.0 17-Mar-2016
 */
public class LogginResponse {

  private String jsessionid;

  public LogginResponse() {
    super();
  }

  public LogginResponse(String jsessionid) {
    this.jsessionid = jsessionid;
  }

  public String getJsessionid() {
    return jsessionid;
  }

  public void setJsessionid(String jsessionid) {
    this.jsessionid = jsessionid;
  }  
}
