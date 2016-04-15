package com.notification.generate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service("amendGenerate")
public class AmendGenerate extends BaseGenerate  implements IGenerate {
	public void scan() {
		Map<String,String> generate = new HashMap<String,String>();
		generate.put("file", "amendgenerate.txt");
		generate.put("subject", "subject_amend");
		generate.put("template", "template_amend");
		generate.put("mailType", "Amend");
		Generate(generate);
	}
}
