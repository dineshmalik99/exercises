package com.sapient.lloyds.controller;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractControllerTest {

	protected MockMvc mvc;

 	protected void setUp(Object controller) {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	} 
}