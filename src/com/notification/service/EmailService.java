/* 
 * UserService
 * 用户服务�?
 * @version 0.01
 * @author young (young.ma@solidinfo.com)
 */
package com.notification.service;



import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.notification.dao.DaoSupport;
import com.notification.entity.Email;

@Service("emailService")
public class EmailService {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/*
	 * 返回所有Email列表不带分页
	 */
	public List<Email> getSendEmailList(Email email) throws Exception {
		return (List<Email>) dao.findForList("EmailMap.getSendEmailList", email);
	}
	
	/*
	 * 返回所有Email列表不带分页
	 */
	public List<Email> getEmailStatusList(Email email) throws Exception {
		return (List<Email>) dao.findForList("EmailMap.getEmailstatusList", email);
	}
	
	/*
	 * 修改email发送状态
	 */
	public void addEmail(Email email) throws Exception {
		dao.save("EmailMap.AddEmail", email);
	}
	
	/*
	 * 修改email发送状态
	 */
	public void updateSendEmail(Email email) throws Exception {
		dao.update("EmailMap.updateEmail", email);
	}
	
	/*
	 * 修改email发送状态
	 */
	public void updateSendEmailStatusError(Email email) throws Exception {
		dao.update("EmailMap.updateEmailStatus", email);
	}
	
	/*
	 * 修改email发送状态
	 */
	public void updateSendEmailStatusSent(List<String> id) throws Exception {
		dao.update("EmailMap.updateSendEmailStatusSent", id);
	}
}
