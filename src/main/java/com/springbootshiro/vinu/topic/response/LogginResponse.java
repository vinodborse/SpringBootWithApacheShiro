package com.springbootshiro.vinu.topic.response;

/**
 * @author Vinod Borse
 * 19-Sep-2019
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
