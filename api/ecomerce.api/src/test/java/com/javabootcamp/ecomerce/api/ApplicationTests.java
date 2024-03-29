package com.javabootcamp.ecomerce.api;

import com.javabootcamp.ecomerce.api.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Table;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testPost() throws Exception{
    }

	@Test
	public void contextLoads() throws Exception {


	    MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/users/all")
                    .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());

	    verify(userRepository).findAll();
	}

}
