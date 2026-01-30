package com.luv2code.springboot.thymeleafdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ThymeleafDemoApplication {

	private static final Logger log =
			LoggerFactory.getLogger(ThymeleafDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(ThymeleafDemoApplication.class);

		// Disable Spring banner (clean startup)
		app.setBannerMode(Banner.Mode.OFF);

		// Enable graceful shutdown support
		app.setRegisterShutdownHook(true);

		app.run(args);
	}

	/**
	 * Triggered once the application is fully started.
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		log.info("🚀 Thymeleaf Demo Application started successfully");
	}
}
