package br.com.jean.wedding.integration;

import br.com.jean.wedding.dto.PresenteDTO;
import br.com.jean.wedding.model.Presente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PresenteIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sholdAddNewPresente() throws Exception{
        PresenteDTO valido = new PresenteDTO(null, "teste","descricao teste", "teste.png", 1500.0);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/presentes")
                .content(mapper.writeValueAsBytes(valido))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    public void sholdNotAddPresenteWhichZeroPrice() throws Exception{
        PresenteDTO valido = new PresenteDTO(null, "teste","descricao teste", "teste.png", 0.0);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/presentes")
                        .content(mapper.writeValueAsBytes(valido))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void sholdNotAddPresenteWhichBlanck() throws Exception{
        PresenteDTO valido = new PresenteDTO(null, "","descricao teste", "teste.png", 0.0);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/presentes")
                        .content(mapper.writeValueAsBytes(valido))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}
