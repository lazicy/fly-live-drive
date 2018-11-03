package com.bff.flylivedrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bff.flylivedrive")
public class FlyLiveDriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyLiveDriveApplication.class, args);
	}
	

    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean registrationBean =
                new FilterRegistrationBean(new CORSFilter());
        registrationBean.setName("CORS Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
	
}
