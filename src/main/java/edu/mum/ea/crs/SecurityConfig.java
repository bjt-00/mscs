/*package edu.mum.ea.crs;

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
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**").permitAll() 
			.antMatchers("/signUp**").permitAll() 
			.antMatchers("/**").hasRole("ADMIN")
			.antMatchers("/customer/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successForwardUrl("/loginSucess")
			.permitAll();
			.and().logout().permitAll().and().sessionManagement().invalidSessionUrl("/logout");
			}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder( new BCryptPasswordEncoder())
		.usersByUsernameQuery(
				"select username, password, active from account where username=?")
		.authoritiesByUsernameQuery(
				"select username, role from account where username=? ");
		
		auth.inMemoryAuthentication()
		.withUser("user1")
		.password("user1")
		.roles("ADMIN");
    }
    	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}

}*/