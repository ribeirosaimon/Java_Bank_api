package br.com.saimon;

import br.com.saimon.controllers.ClientController;
import br.com.saimon.model.entities.BankClientVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ClientResourceTest extends JavaBankApplicationTests {

    private MockMvc mockMvc;
    private Long user_id;

    @Autowired
    private ClientController clientController;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void createCorrectUser_ReturnStatusCode201() throws Exception {
        BankClientVO user = new BankClientVO("name_test", "123", "pass", 0.0, -200.0);
        ObjectMapper mapper = new ObjectMapper();
        this.user_id = user.getId();
        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/account/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/api/account/v1")));
    }

    @Test
    public void createIncorrectUser_ReturnStatusCode404() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/account/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getUser_ReturnStatusCode200() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/account/v1/")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getIncorrectUser_ReturnStatusCode400() throws Exception {
        String url = String.format("/api/account/v1/null");
        System.out.println(url);
        this.mockMvc.perform(MockMvcRequestBuilders.delete(url)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
