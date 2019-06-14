package com.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.main.admin.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		//role ADMIN or Member
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('MEMBER')");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/error");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()
				//login
				.loginProcessingUrl("/action-login")
				.loginPage("/")
				.defaultSuccessUrl("/admin/index")
				.failureUrl("/?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				//Logout
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
				.and().logout().deleteCookies("JSESSIONID");

		//Remember Me
		http.authorizeRequests().and()
				.rememberMe().tokenRepository(this.persistentTokenRepository())
				.tokenValiditySeconds(60 * 60);

	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}
