package com.xu.shen.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.xu.shen.session.SessionInformationExpiredStrategyImpl;

/**
 * Security 主配置文件
 * 
 * @author shenxu
 */
@Configuration
@EnableWebSecurity // 开启Spring Security的功能
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启注解控制权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	SessionRegistry sessionRegistry;

	// 这里配置PasswordEncoder,BCryptPasswordEncoder是security提供的PasswordEncorder的一个实现类
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 定义不需要过滤的静态资源（等价于HttpSecurity的permitAll）
	 */
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/css/**");
	}

	/**
	 * 安全策略配置
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()

				.antMatchers("/register", "/doRegister").permitAll().anyRequest().authenticated();

		httpSecurity.cors()
				// 跨域伪造请求=无效，
				.and().csrf().disable();
		// 定义当需要用户登录时候，转到的登录页面
		httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll();

		// 定义登出操作
		httpSecurity.logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/login?logout").permitAll().and().csrf()
				.disable();
		// 20200627 加入session单登录验证
		/*
		 * 需要重写userDetails里面的equal,hashCode,toString方法，让Security知道，同一个人，
		 * 在不同地方登录了。
		 * 
		 */
		httpSecurity.sessionManagement().invalidSessionUrl("/login").maximumSessions(1).expiredUrl("/login");

		// 禁用缓存
		httpSecurity.headers().cacheControl();

	}

	/**
	 * 开启注解控制权限 见Controller 中 @PreAuthorize("hasAuthority('XXX')")
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	// session 集群是东西，下一波再研究，记着点这个事儿。
	@Bean
	public SessionRegistry getSessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

}
