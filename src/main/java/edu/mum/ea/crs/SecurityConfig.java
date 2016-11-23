package edu.mum.ea.crs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	protected void configure(HttpSecurity http) throws Exception {
		http 
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**").permitAll() 
			.antMatchers("/signUp**").permitAll()
			.antMatchers("/cars**").permitAll() 
			/*.antMatchers("/cars.do").permitAll()  */
			/*.antMatchers("/**").hasAuthority("ADMIN")
			.antMatchers("/**").hasAuthority("USER")*/
			/*.antMatchers("/user/list.do","/customer/list.do").hasAuthority("ADMIN")
			.antMatchers("/reservations.add").hasAnyAuthority ("ADMIN","USER")*/
			.antMatchers("/**").hasAnyAuthority("ADMIN","USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successForwardUrl("/loginSucess")
			.permitAll();
			/*.and().logout().permitAll().and().sessionManagement().invalidSessionUrl("/");*/
			}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder( new BCryptPasswordEncoder())
		.usersByUsernameQuery(
				"select username, password, active from account where username=?")
		.authoritiesByUsernameQuery(
				"select username, role from account where username=? ");
		/*
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("admin")
		.roles("ADMIN");
		*/
    }
    	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}

}