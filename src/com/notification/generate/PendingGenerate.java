package com.notification.generate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service("pendingGenerate")
public class PendingGenerate extends BaseGenerate implements IGenerate {

	public void scan() {
		Map<String,String> generate = new HashMap<String,String>();
		generate.put("file", "pendinggenerate.txt");
		generate.put("subject", "subject_pending");
		generate.put("template", "template_pending");
		generate.put("mailType", "Pending");
		Generate(generate);
	}
}
