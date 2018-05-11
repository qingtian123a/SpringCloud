package com.kay.api;

public class RespData {

  /** The msg. */
  public String msg = "";

  /** The ret code. */
  public Integer code;

  public RespData ok() {
    return ok("ok");
  }

  /**
   * 返回成功.
   * 
   * @param msg 消息
   * @return RespData
   */
  public RespData ok(String msg) {
    this.code = 0;
    this.msg = msg;
    return this;
  }

  public RespData fail(String msg) {
    this.msg = msg;
    return this;
  }

  /**
   * 返回错误码和消息.
   * 
   * @param code 错误码
   * @param msg 消息
   * @return RespData
   */
  public RespData codeAndMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
    return this;
  }

}
