/* 
 * Email
 * 邮件信息实体表
 * @version 0.01
 * @author young (young.ma@solidinfo.com)
 */
package com.notification.entity;

import org.springframework.stereotype.Component;

@Component("email")
public class Email {
	private String id;
	private String title;
	private String content;
	private String address;
	private String status;
	private String createdate;
	private String startdate;
	private String stopdate;
	private String mail_type;
	private String sendinfo;
	private String[] IDS;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getStopdate() {
		return stopdate;
	}
	public void setStopdate(String stopdate) {
		this.stopdate = stopdate;
	}
	public String[] getIDS() {
		return IDS;
	}
	public void setIDS(String[] iDS) {
		IDS = iDS;
	}
	public String getSendinfo() {
		return sendinfo;
	}
	public void setSendinfo(String sendinfo) {
		this.sendinfo = sendinfo;
	}
	public String getMail_type() {
		return mail_type;
	}
	public void setMail_type(String mail_type) {
		this.mail_type = mail_type;
	}
}
