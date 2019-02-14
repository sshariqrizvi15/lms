package org.app.demo.lms.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.app.demo.lms.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestContollerTest {

	@Autowired
	private MockMvc mockMvc;
 
    @MockBean
    private UserService userService;
	
	String exampleUserJson = "{\"name\":\"alex\",\"cnic\":\"123\",\"mobile\":\"456\",\"address\":\"house_number\"}";

    @Test
    public void canCreateANewUser() throws Exception {
        // when
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON).content(
                		exampleUserJson)).andReturn().getResponse();
 
        // then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

    }
}
