package com.module.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.module.web.vo.UserVo;
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

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/11 10:48
 **/
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc ;

//    private MockHttpSession session ;

    @Autowired
    private WebApplicationContext wac ;

    @Autowired
    private ObjectMapper objectMapper ;

    @BeforeEach
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        session = new MockHttpSession();
//        SysUser user =new SysUser();
//        user.setLoginName("lvxc123");
//        user.setLoginPassword("123456");
//        session.setAttribute("user",user);
    }

    @Test
    @Transactional
    public void testRegister() throws Exception {
//		mockMvc.perform(
//				 MockMvcRequestBuilders.get("/user/{userName}", "scott")
//				.contentType(MediaType.APPLICATION_JSON_UTF8))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("scott"))
//		.andDo(MockMvcResultHandlers.print());

//		String jsonStr = "{\"username\":\"Dopa\",\"passwd\":\"ac3af72d9f95161a502fd326865c2f15\",\"status\":\"1\"}";

        UserVo user =new UserVo();
        user.setName("lvxc123");
        user.setPassword("123456");

        String userJson = objectMapper.writeValueAsString(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

//		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name={name}","mrbird"));
//		mockMvc.perform(MockMvcRequestBuilders.post("/user/{id}", 1));
//		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/fileupload").file("file", "文件内容".getBytes("utf-8")));
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("message", "hello"));
//		mockMvc.perform(MockMvcRequestBuilders.get("/hobby/save").param("hobby", "sleep", "eat"));

//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("name", "mrbird");
//		params.add("hobby", "sleep");
//		params.add("hobby", "eat");
//		mockMvc.perform(MockMvcRequestBuilders.get("/hobby/save").params(params));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").sessionAttr(name, value));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").cookie(new Cookie(name, value)));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").contentType(MediaType.APPLICATION_JSON_UTF8));
//		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1).accept(MediaType.APPLICATION_JSON));
//		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1).header(name, values));

//		mockMvc.perform(MockMvcRequestBuilders.get("/index"))
//		.andDo(MockMvcResultHandlers.print());

    }
}
