package com.example.demo.jUnit;

import com.example.demo.jUnit.DemoApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TestWebApp extends DemoApplicationTests {



        @Autowired
        private WebApplicationContext webApplicationContext;

        private MockMvc mockMvc;

        @Before
        public void setup() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }

        @Test
        public void testUser() throws Exception {
            mockMvc.perform(get("/api/getAllRest")).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
                    /*.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
                    .andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));
*/
        }

}
