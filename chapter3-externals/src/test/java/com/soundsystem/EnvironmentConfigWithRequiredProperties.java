package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")
public class EnvironmentConfigWithRequiredProperties {

	@Autowired
	Environment env;
	
	@Bean
	public BlankDisc blankDisc() {
		return new BlankDisc(
				env.getRequiredProperty("disc.title"), 
				env.getRequiredProperty("disc.artist"));
	}
	
}
