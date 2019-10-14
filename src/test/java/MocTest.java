/*

import com.example.stu_manage.StuManageApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuManageApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class MocTest {


    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        System.out.println(context);
        System.out.println(mvc);
    }

    @Test
    public void test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/client/test")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
//                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
    @Test
    public void qeuryById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/client/queryById/{params}", 222)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void testt() throws Exception {
        String params = "{\"name\":\"zs\",\"age\":\"23\"}";
        mvc.perform(MockMvcRequestBuilders.post("/client/testt")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .content(params))
                .andDo(MockMvcResultHandlers.print());
    }
}*/
