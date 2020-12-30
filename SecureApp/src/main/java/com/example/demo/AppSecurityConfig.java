package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private UserDetailsService userDetailsService;

	
	 * public DaoAuthenticationProvider authProvider() { DaoAuthenticationProvider
	 * provider=new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userDetailsService);
	 * //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	 * 
	 * DelegatingPasswordEncoder delPasswordEncoder=
	 * (DelegatingPasswordEncoder)PasswordEncoderFactories.
	 * createDelegatingPasswordEncoder(); BCryptPasswordEncoder
	 * bcryptPasswordEncoder =new BCryptPasswordEncoder();
	 * delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder)
	 * ;
	 * 
	 * 
	 * provider.setPasswordEncoder(new BCryptPasswordEncoder()); return provider; }
	 */

	/*
	 * @Bean(name = "myPasswordEncoder") public PasswordEncoder getPasswordEncoder()
	 * { DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder)
	 * PasswordEncoderFactories .createDelegatingPasswordEncoder();
	 * BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
	 * delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder)
	 * ; return delPasswordEncoder; }
	 * 
	 * @Bean
	 * 
	 * @Autowired public DaoAuthenticationProvider getDaoAuthenticationProvider(
	 * 
	 * @Qualifier("myPasswordEncoder") PasswordEncoder passwordEncoder,
	 * UserDetailsService userDetailsServiceJDBC) { DaoAuthenticationProvider
	 * daoAuthenticationProvider = new DaoAuthenticationProvider();
	 * daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	 * daoAuthenticationProvider.setUserDetailsService(userDetailsServiceJDBC);
	 * return daoAuthenticationProvider; }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .csrf().disable() .authorizeRequests().antMatchers("/login").permitAll()
		 * .anyRequest().authenticated() .and() .formLogin()
		 * .loginPage("/login").permitAll() .and() .logout().invalidateHttpSession(true)
		 * .clearAuthentication(true) .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/logout-success").permitAll();
		 */
		http 
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated() 
		.and() .httpBasic();
	}

	
	
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users=new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("faizan").password(
	 * "12345").roles("USER").build()); return new
	 * InMemoryUserDetailsManager(users); }
	 */

}
