package com.module.web.controller; 

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/** 
* UserController Tester. 
* 
* @author lvxc
* @since <pre>5月 12, 2021</pre> 
* @version 1.0 
*/ 
@SpringBootTest
public class UserControllerTest { 

	private MockMvc mockMvc ;

    @Autowired
    private WebApplicationContext wac ;

    @Autowired
    private ObjectMapper objectMapper ;

    @BeforeEach
	public void before() throws Exception { 
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	} 


	/** 
	* 
	* Method: register(@RequestBody UserVo vo) 
	* 
	*/ 
	@Test
	public void testRegister() throws Exception { 
		String requestUrl = "/user/register";
		Map<String,Object> map = new HashMap<>();
		map.put("name","lvxc123");
		map.put("password","123456");
		String userJson = objectMapper.writeValueAsString(map);

        mockMvc.perform(
                MockMvcRequestBuilders.post(requestUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
		
	} 

	/** 
	* 
	* Method: register2(@RequestBody UserVo vo) 
	* 
	*/ 
	@Test
	public void testRegister2() throws Exception { 
		String requestUrl = "/user/register";
		Map<String,Object> map = new HashMap<>();
		map.put("name","lvxc123");
		map.put("password","123456");
		String userJson = objectMapper.writeValueAsString(map);

        mockMvc.perform(
                MockMvcRequestBuilders.post(requestUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
		
	} 

	
} 
