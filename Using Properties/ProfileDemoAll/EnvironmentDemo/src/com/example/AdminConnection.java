package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.Setter;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	@Setter
	private Environment env;
	
	@Getter @Setter private String adminId;
	
	@Getter
	@Setter
	private String adminPwd;

	@Override
	public void destroy() throws Exception {
		System.out.println("called destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("called afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPwd(env.getProperty("admin.pwd"));
	}

	// bean이 생성되기 전에 callback 으로 호출됨. 가장 먼저 호출됨.
	// MainClass에서 사용하는 env 정보가 넘어옴.
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment()");
		setEnv(env);
	}
}
