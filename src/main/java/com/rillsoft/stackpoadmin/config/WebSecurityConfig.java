package com.rillsoft.stackpoadmin.config;
//package hello;	// commented by crane zhou on 10.08.2018

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.rillsoft.stackpoadmin.service.CustomUserService;

import javax.servlet.http.HttpServletRequest;
//@EnableGlobalMethodSecurity(prePostEnabled = true) // open security annotation (注解)

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    
    @Autowired
//    private UserDetailsServiceImpl userDetailsServiceImpl;
    private CustomUserService m_prv_customUserService;
    @Autowired
    private BCryptPasswordEncoder m_prv_bCryptPasswordEncoder;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/hello").permitAll()
                .anyRequest().authenticated()
                .and()
//        		.csrf().disable() // close CSRF
//        		.csrf().requireCsrfProtectionMatcher(new RequestMatcher() { 
//	        	@Override 
//	        	public boolean matches(HttpServletRequest httpServletRequest) { 
//	        		String servletPath = httpServletRequest.getServletPath(); 
//	        		if (servletPath.contains("/druid")) { 
//	        			return false; 
//	        		} 
//	        		return true; 
//	        		} 
//	        	}).and()
                .csrf().requireCsrfProtectionMatcher(new RequestMatcher() { 
                	// allow these request methods
                    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
                    // allow rest requests, rest and web will be separated, it could be removed then.
                    // 放行rest请求，当然后面rest与web将会分开，到时这里可以删除
                    private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("^/rest/.*", null);

                    @Override
                    public boolean matches(HttpServletRequest request) { if(allowedMethods.matcher(request.getMethod()).matches()){ return false;
                        } String servletPath = request.getServletPath();
                        if (servletPath.contains("/druid")) { 
                        	return false;
                        } 
                        return !unprotectedMatcher.matches(request);
                    	} 
                    }).and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login-error")
                .and()
            .logout()
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/login")
                .permitAll();        
    	}

    //Beans
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
/*
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
//                .username("user@example.com")
                .username("czhou")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
*/  
	@Override
	public void configure(WebSecurity web) throws Exception {	
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**",
	    		   "/normal/**",
	    		   "/bower_components/**",
	    		   "/dist/**",
	    		   "/plugins/**");
	     
	    /* "/static/**", "/templates-dev/**", */
	    /* "/css/**", "/js/**", "/images/**", */ 
	}
	
/*	
    @Bean
    UserDetailsService customUserService(){ // register UserDetailsService bean
//    	System.out.println("UserDetailsService customUserService() OK here");
        return new CustomUserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService()); // user Details Service verify
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }
*/
	
    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsServiceImpl);
        authProvider.setUserDetailsService(m_prv_customUserService);
        authProvider.setPasswordEncoder(m_prv_bCryptPasswordEncoder);
        return authProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
    
	/*
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	 		auth.inMemoryAuthentication() 
			.withUser("user").password("password").roles("USER"); 
		}
	*/
}