package br.com.jean.wedding.service;

import br.com.jean.wedding.dto.PresenteDTO;
import br.com.jean.wedding.model.Presente;
import br.com.jean.wedding.repo.PresenteRepo;
import br.com.jean.wedding.service.presente.IPresenteService;
import br.com.jean.wedding.service.presente.PresenteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PresenteServiceTest {

    @Mock
    private PresenteRepo repo;// Quem sera o duble
    @InjectMocks
    private PresenteServiceImpl service;//Quem injeta o duble


    private PresenteDTO dto;
    @BeforeEach
    public void setUp(){
        Presente p = new Presente();
        p.setId(1);
        p.setNome("teste");
        p.setDescricao("teste de descricao");
        p.setLinkFoto("test.png");
        p.setPreco(2000.0);

        Mockito.when(repo.save(p)).thenReturn(p);
        dto = new PresenteDTO(1,"teste", "teste de descricao", "teste.png", 2000.0);
    }

    @Test
    public void sholdAddNewPresente(){
        PresenteDTO res = service.save(dto);
        System.out.printf("Debug " + res);
        assertNotNull(res);
        assertEquals("teste", res.nome());
    }


}
