package com.notification.generate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service("newBookingGenerate")
public class NewBookingGenerate extends BaseGenerate implements IGenerate {
	
	public void scan() {
		Map<String, String> generate = new HashMap<String, String>();
		generate.put("file", "newbooking.txt");
		generate.put("subject", "subject_newbooking");
		generate.put("template", "template_newbooking");
		generate.put("mailType", "NewBooking");
		Generate(generate);
	}
}
