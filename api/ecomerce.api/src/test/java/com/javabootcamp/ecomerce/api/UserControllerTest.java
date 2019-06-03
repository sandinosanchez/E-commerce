package com.javabootcamp.ecomerce.api;


import com.javabootcamp.ecomerce.api.Controller.UserController;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    
    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void testAddUser() throws Exception{


        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"name\":\"eduardo\",\n" +
                "  \"lastname\":\"gomez\",\n" +
                "  \"userName\":\"edg\",\n" +
                "  \"password\":\"pass\",\n" +
                "  \"dod\":\"2010-01-18\"\n" +
                "  \"date\":\"2010-01-18\"\n" +
                "}";
        mockMvc.perform(post("/users/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json)
        )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("eduardo")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastname", Matchers.is("gomez")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.userName",Matchers.is("edg")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.password",Matchers.is("pass")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.dod",Matchers.is("2010-01-18")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(5)));
    }
}
