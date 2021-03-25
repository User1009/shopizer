package com.salesmanager.test.shop.util;

import com.salesmanager.shop.admin.model.userpassword.UserReset;
import org.junit.Assert;
import javax.inject.Inject;
import javax.inject.Named;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.salesmanager.shop.application.ShopApplication;
import com.salesmanager.test.shop.common.ServicesTestSupport;


import static com.salesmanager.shop.store.controller.customer.facade.CustomerFacadeImpl.USERNAME_LENGTH;


/**
 * This utility is for password encryption
 * @author carlsamson
 * 
 */
@SpringBootTest(classes = ShopApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(JQF.class)

public class GeneratePasswordTestFuzzingJQF extends ServicesTestSupport {

private static final Logger LOGGER = LoggerFactory.getLogger(GeneratePasswordTestFuzzingJQF.class);

  @Inject
  @Named("passwordEncoder")
  private PasswordEncoder passwordEncoder;
  @Fuzz
  public void createPassword() throws Exception {
 

      String password ="password";
      String encoded = passwordEncoder.encode(password);
      LOGGER.info(encoded);
      System.out.println(encoded);
      //To comply with sonarlint rule java:S2699
      System.out.println("Test1 code");
	  Assert.assertNotNull(encoded);


  }

   @Fuzz
    public void generateNick() {
        long start = System.currentTimeMillis();
        LOGGER.info("Starting random generation: {}", start);
        String userName = UserReset.generateRandomString(USERNAME_LENGTH);
        LOGGER.info(userName);
        LOGGER.info("End random generation, elapsed milliseconds: {}", System.currentTimeMillis() - start);
        System.out.println("Test2 code");
	    Assert.assertNotNull(userName);
       

    }

    

	

}





