package com.notification.generate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service("errorGenerate")
public class ErrorGenerate extends BaseGenerate implements IGenerate {
	public void scan() {
		Map<String,String> generate = new HashMap<String,String>();
		generate.put("file", "errorgenerate.txt");
		generate.put("subject", "subject_error");
		generate.put("template", "template_error");
		generate.put("mailType", "error");
		Generate(generate);
	}
}
