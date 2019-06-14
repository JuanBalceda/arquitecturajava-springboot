package com.balceda;

import com.balceda.config.SpringConfig;
import com.balceda.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SpringConfig.class);
		context.refresh();

		MessageService messageService = context.getBean(MessageService.class);
		System.out.println(messageService.message());
		context.close();
	}
}
