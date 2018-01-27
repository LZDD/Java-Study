package com.lzdd;

import com.lzdd.annotation.DispatcherServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.WebEndpoint;

@SpringBootApplication
public class JavaAnnotationApplication {

	@Bean
	public ServletRegistrationBean getDispatcherServlet(){
		return new ServletRegistrationBean (new DispatcherServlet(),"/");
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaAnnotationApplication.class, args);
	}
}
