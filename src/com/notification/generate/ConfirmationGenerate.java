package com.notification.generate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service("confirmationGenerate")
public class ConfirmationGenerate extends BaseGenerate implements IGenerate {
	public void scan() {
		Map<String,String> generate = new HashMap<String,String>();
		generate.put("file", "confirmationgenerate.txt");
		generate.put("subject", "subject_confirmation");
		generate.put("template", "template_confirmation");
		generate.put("mailType", "Confirmation");
		Generate(generate);
	}

}
