package com.blade.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DemoConfig {
	@Value("${ext.allUserGetUrl}")
	private String allusersUrl;
	
	@Value("${ext.userUrl}")
	private String userUrl;
}
