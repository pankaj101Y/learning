package com.example.learnings.validation.demo04;

import javax.validation.constraints.NotNull;
import java.util.Date;


public class ServerConnection {

  // ======================================
  // =             Attributes             =
  // ======================================

  @URL
  private String resourceURL;
  @NotNull
  @URL(protocol = "https", host = "www.cdbookstore.com")
  private String itemURL;
  @URL(protocol = "ftp", port = 21)
  private String ftpURL;
  private Date lastConnectionDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public ServerConnection() {
  }

  public ServerConnection(String resourceURL, String itemURL) {
    this.resourceURL = resourceURL;
    this.itemURL = itemURL;
  }

  public ServerConnection(String resourceURL, String itemURL, String ftpURL) {
    this.resourceURL = resourceURL;
    this.itemURL = itemURL;
    this.ftpURL = ftpURL;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getResourceURL() {
    return resourceURL;
  }

  public void setResourceURL(String resourceURL) {
    this.resourceURL = resourceURL;
  }

  public String getItemURL() {
    return itemURL;
  }

  public void setItemURL(String itemURL) {
    this.itemURL = itemURL;
  }

  public String getFtpURL() {
    return ftpURL;
  }

  public void setFtpURL(String ftpURL) {
    this.ftpURL = ftpURL;
  }

  public Date getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(Date lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
}
