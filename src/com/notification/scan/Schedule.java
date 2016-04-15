package com.notification.scan;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.notification.entity.mail.IMail;
import com.notification.generate.IGenerate;
import com.notification.util.Logger;

@Component
public class Schedule {
	Logger logger =Logger.getLogger(Schedule.class);

	@Resource(name = "mail")
	IMail mail;
	@Resource(name = "amendGenerate")
	IGenerate amendGenerate;
	@Resource(name = "errorGenerate")
	IGenerate errorGenerate;
	@Resource(name = "newBookingGenerate")
	IGenerate newBookingGenerate;
	@Resource(name = "pendingGenerate")
	IGenerate pendingGenerate;
	@Resource(name = "confirmationGenerate")
	IGenerate confirmationGenerate;
	
	/**
	 * 扫描邮件表
	 * @throws Exception
	 */
	public void scanSend() throws Exception {
		logger.info("Sending: Start");
		mail.send();
		logger.info("Sending: End");
	}
	
	/**
	 * 扫描NewBooking
	 * @throws InterruptedException
	 */
	public void scanNewBooking() throws InterruptedException {
		logger.info("NewBooking Scan: Start");
		newBookingGenerate.scan();
		logger.info("NewBooking Scan: End");
	}
	
	/**
	 * 扫描AmendBooking
	 * @throws InterruptedException
	 */
	public void scanAmend() throws InterruptedException {
		logger.info("AmendBooking Scan: Start");
		amendGenerate.scan();
		logger.info("AmendBooking Scan: End");
	}
	
	/**
	 * 
	 */
	public void scanPending() {
		logger.info("Pending Scan: Start");
		pendingGenerate.scan();
		logger.info("Pending Scan: End");
	}

	public void scanConfirmation() {
		logger.info("Confirmation Scan: Start");
		confirmationGenerate.scan();
		logger.info("Confirmation Scan: End");
	}

	public void scanError() {
		logger.info("Traffic Error Scan: Start");
		errorGenerate.scan();
		logger.info("Traffic Error Scan: End");
	}

}
