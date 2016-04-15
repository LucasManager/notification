package com.notification.generate;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import net.sf.json.JSONObject;

/*
 * 邮件模板类用于生成邮件正文内容
 */
public class MailTemplate {

	public String generateMail(Properties prop,JSONObject templateParam, String templatePath) {
		VelocityEngine velocityEngine = new VelocityEngine();
		// 初始化
		velocityEngine.init(prop);
		// 根据文件名得到一个模板实例
		Template t = velocityEngine.getTemplate(templatePath, "UTF-8");
		// 模板上下文环境
		VelocityContext context = new VelocityContext();
		// 把模板中的参数放入上下文环境实例中,模板会根据context中的参数(变量),自动匹配,然后设置
		Set set = templateParam.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			context.put(key, templateParam.getString(key));
		}

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		return writer.toString();
	}
}
