package br.edu.ifsp.campus_match_spring.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${spring.mail.username}")
	private String mailUsername;
	
	@Value("${spring.mail.port}")
	private int mailPort;
	
	@Value("${spring.mail.host}")
	private String mailHost;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String mailAuth;

	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String mailTlsEnable;
	
	@Value("${spring.mail.password}")
	private String mailPassword;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("pages/web/landingPage");
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers(
						"/"
						,"/css/**"
						,"/auth/**"
						,"/estudantes/save/**"
						,"/instituicoes/save/**"
						).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/auth/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	JavaMailSender javaMailSender() {
	    System.out.println("Creating JavaMailSender bean");
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(this.mailHost);
	    mailSender.setPort(this.mailPort);
	    mailSender.setUsername(this.mailUsername);
	    mailSender.setPassword(this.mailPassword);

	    Properties properties = mailSender.getJavaMailProperties();
	    properties.put("mail.transport.protocol", "smtp");
	    properties.put("mail.smtp.auth", this.mailAuth);
	    properties.put("mail.smtp.starttls.enable", this.mailTlsEnable);
	    properties.put("mail.debug", "true");

	    return mailSender;
	}

}
