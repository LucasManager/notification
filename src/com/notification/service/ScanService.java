/* 
 * UserService
 * 用户服务�?
 * @version 0.01
 * @author young (young.ma@solidinfo.com)
 */
package com.notification.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.notification.dao.DaoSupport;

@Service("scanService")
public class ScanService {
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 获取数据
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> getGenerateList(String sql) throws Exception {
		return (List<Map<String,String>>) dao.findForList("GenerateMap.getGenerateList", sql);
	}
	
	/**
	 * 获取邮件取值时间
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getMailTime(String type) throws Exception {
		return (Map<String,String>)dao.findForObject("GenerateMap.getMailTime", type);
	}
	
	/**
	 * 更新邮件取值时间
	 * @param mailTime
	 * @throws Exception
	 */
	public void addMailTime(Map<String,String> mailTime) throws Exception {
		dao.update("GenerateMap.addMailTime", mailTime);
	}
	
	/**
	 * 更新扫面的数据量
	 * @param updatacount
	 * @throws Exception
	 */
	public void updateDatacount(Map<String,String> updatacount) throws Exception {
		dao.update("GenerateMap.updateDatacount", updatacount);
	}
	
}
