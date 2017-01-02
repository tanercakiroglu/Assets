package com.chrental.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.application.exception.BusinessException;
import com.chrental.Idao.IUserDAO;
import com.chrental.Iservice.IUserService;
import com.chrental.icontroller.IUserController;
import com.chrental.pojo.CheckCredentialResponse;
import com.chrental.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/rest-servlet.xml"  })
public class UserTest {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserController userController;

	@Test
	public void daoCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, true);
	}
	
	@Test
	public void daoCheckCredentialTest1() {
		User credential = new User();
		credential.setPassword("123");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, false);
	}

	@Test
	public void serviceCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		Object returnVal = userService.checkCredential(credential);
		assertTrue(returnVal instanceof CheckCredentialResponse);
	}
	@Test
	public void controllerCheckCredentialTest() throws BusinessException {
		User credential = new User();
		credential.setPassword(" ");
		credential.setEmail("merchant@test.com");
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}
	@Test
	public void controllerCheckCredentialTest1() throws BusinessException {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail(null);
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}
}
