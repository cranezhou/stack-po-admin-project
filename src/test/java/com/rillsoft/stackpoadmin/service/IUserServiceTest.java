/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rillsoft.stackpoadmin.StackPOAdminApplication;
import com.rillsoft.stackpoadmin.domain.User;
import com.rillsoft.stackpoadmin.service.IUserService;
//import com.rillsoft.stackpoadmin.utils.PasswordGenerator;
import com.rillsoft.stackpoadmin.utils.ShiroSimpleHash;

/**
 * @author crane
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceTest {

	/**
	 * 
	 */
	public IUserServiceTest() {
		// TODO Auto-generated constructor stub
	}
	
    private static Logger logger = LoggerFactory.getLogger(StackPOAdminApplication.class);
    
	@Autowired
    private IUserService userService;

	
    @Test
    public void testDBUserName() throws Exception {
//    	System.out.println("=== testUserName() in IUserServiceTest{} class ===");
    	
    	logger.info("LOGGER.INFO: === testDBUserName() in IUserServiceTest{} class ===");
    	
//    	User user = userService.getUserById(2001);
    	User user = userService.selectByUsername("admin"); 
    	
//    	System.out.println("user.getUsername()=" + user.getUsername());
//    	logger.info("LOGGER.INFO: " + user.getUsername());

//        assertThat(user.getUsername(), equalTo("czhou"));
        assertThat(user.getId(), equalTo(2001));
//    	assertThat("czhou", equalTo("czhou"));
    }

    
    @Test
    public void testDBPassword() throws Exception {
		System.out.println("=== testPassword() in IUserServiceTest{} class ===");
		
        logger.info("LOGGER.INFO: === testDBPassword() in IUserServiceTest{} class ===");
        
//        PasswordGenerator passwordGenerator = new PasswordGenerator();
//        ShiroSimpleHash passwordGenerator = new ShiroSimpleHash();
		
//		String strDecPassword = passwordGenerator.encryptPassword("admin", "password");

//        logger.info("LOGGER.INFO: === theUser.getPassword() = " + theUser.getPassword() + " ===");
        
//		User databaseUser = userService.selectByUsername("admin");
       	
//    	assertThat(databaseUser.getPassword(), equalTo(strDecPassword)); 
//    	assertThat("password", equalTo("password"));
        
    	User databaseUser = userService.selectByUsername("user02");
       	assertThat(databaseUser.getPassword(), equalTo("password02"));
    }
    
    @Test
    public void testDBBcryptPassword() throws Exception {
		System.out.println("=== testPassword() in IUserServiceTest{} class ===");
		
        logger.info("LOGGER.INFO: === testDBBcryptPassword() in IUserServiceTest{} class ===");
        
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        
    	User databaseUser = userService.selectByUsername("admin");
    	
    	String strPassword = "password";
    	
		assertThat(bCryptPasswordEncoder.matches(strPassword, databaseUser.getPassword()), equalTo(true));
    	
//       	assertThat(databaseUser.getPassword(), equalTo("password"));
    }
}