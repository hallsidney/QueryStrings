package com.galvanize.calculate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathService.class)
public class MathServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMathCalculate() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testMathSum() throws Exception {
        this.mvc.perform(post("/math/sum/?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testMathVolume1() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testMathVolume2() throws Exception {
        this.mvc.perform(patch("/math/volume/6/7/8").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }

    @Test
    public void testArea1() throws Exception {
            MockHttpServletRequestBuilder request1 = post("/math/area")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("type", "circle")
                    .param("radius", "4");

            this.mvc.perform(request1)
                    .andExpect(status().isOk())
                    .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));

    }

    @Test
    public void testArea2() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "7");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));

    }

    @Test
    public void testArea3() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("INVALID"));

    }
}
