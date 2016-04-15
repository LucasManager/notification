package com.notification.entity.mail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.notification.entity.Email;
import com.notification.generate.MailTemplate;
import com.notification.service.EmailService;
import com.notification.util.Logger;
import com.notification.util.SimpleMailSender;

import net.sf.json.JSONObject;

/*
 * 邮件发送接口实现类
 */
@Service("mail")
public class Mail implements IMail {
	@Resource(name = "email")
	private Email email;

	@Resource(name = "mailsend")
	private MailSenderInfo sendmail;

	@Resource(name = "emailService")
	private EmailService emailService;

	@Value("#{propertiesBase}")
	Properties prop;
	protected Logger logger = Logger.getLogger(this.getClass());

	public void send() {
		email.setStatus("wait");
		List<Email> sendlist;
		try {
			sendlist = emailService.getSendEmailList(email);
			List<String> suclist = new ArrayList<String>();
			if (sendlist != null) {
				A: for (int i = 0; i < sendlist.size(); i++) {
					int temp = i;
					Email send = sendlist.get(i);
					sendmail.setToAddress(send.getAddress());// 发送地址
					sendmail.setSubject(send.getTitle());// 邮件主题
					sendmail.setContent(send.getContent());// 邮件内容
					String id = send.getId();
					for (int k = 1; k < 3; k++) {// 相同主题以及收件人邮件追加发送
						if (temp + k == sendlist.size())
							break;
						Email nextsend = sendlist.get(temp + k);
						if (!sendmail.getToAddress().equals(nextsend.getAddress())
								|| !sendmail.getSubject().equals(nextsend.getTitle())
								|| send.getMail_type().equals("Amend")) {
							break;
						}
						i++;
						id += "," + nextsend.getId();
						sendmail.setContent(sendmail.getContent() + nextsend.getContent());// 邮件内容
					}
//					MailTemplate mailtemp = new MailTemplate();
//					JSONObject json = new JSONObject();
//					json.put("content", sendmail.getContent());
					//String content = mailtemp.generateMail(prop, json, prop.getProperty("template_base"));// 得到邮件正文内容
					//sendmail.setContent(content);
					for (int j = 0; j < 3; j++) {// 发送失败后尝试发送三次
						String sendinfo = SimpleMailSender.sendHtmlMail(sendmail);
						send.setSendinfo(sendinfo);
						if ("".equals(sendinfo)) {// 判断是否发送成功，成功直接退出
							logger.info("send success");
							Collections.addAll(suclist, id.split(","));
							if (suclist.size() >= 20) {
								logger.info("update state");
								emailService.updateSendEmailStatusSent(suclist);
								suclist.clear();
							}
							continue A;
						}
					}
					send.setStatus("error");// 发送失败状态
					send.setIDS(id.split(","));
					emailService.updateSendEmailStatusError(send);// 修改发送邮件状态
				}
				if (suclist.size() > 0) {
					emailService.updateSendEmailStatusSent(suclist);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
