package com.seguritech.practicafinal.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguritech.practicafinal.domain.Administrador;
import com.seguritech.practicafinal.service.AdministradorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AdministradorController administradorController;

    @Mock
    private AdministradorService administradorService;

    public AdministradorControllerTest() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Administrador administrador = new Administrador();
        Date date = new java.util.Date();
        administrador.setId(1L);
        administrador.setClave("posda");
        administrador.setEmail("example@gmail.com");
        administrador.setFechaCreacion(date);
        administrador.setEstado("HABILITADO");
        administrador.setUsuario("example");
        administrador.setNombre("Example");
        administrador.setTelefono("4432123121");
        Mockito.when(administradorService.findOne(1L)).thenReturn(administrador);

        administradorController = new AdministradorController(administradorService);

        mockMvc = MockMvcBuilders.standaloneSetup(administradorController).build();
    }
//
//    @Test
//    public void testListAll_0args() {
//        System.out.println("listAll");
//        List<Rol> listAll = rolController.listAll();
//        assertEquals(2, listAll.size());
//    }
////
//     public void testGetRol_isOkWhenRolIsFound() throws Exception {
//    System.out.println("getPaciente");
//    final long id = 1;
//
//    mockMvc.perform(put("/paciente/" + id)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.id").isNumber())
//            .andExpect(jsonPath("$.id").value(id))
//            .andExpect(jsonPath("$.tipo_persona").value("PACIENTE"));
//}

    @Test
    public void testGetAdministrador_isOkWhenAdministradorIsFound() throws Exception {
        System.out.println("getAdministrador");
        final long id = 1;

        mockMvc.perform(get("/administrador/"+ id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.estado").value("HABILITADO"));
    }

    @Test
    public void testGetAdministrador_isError404WhenAdministradorIsNotFound() throws Exception {
        System.out.println("getAdministrador");
        final long id = 2;

        mockMvc.perform(get("/administrador/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    public void test_create_administrador_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Administrador administrador = new Administrador();
        Date date = new java.util.Date();
        administrador.setClave("posda");
        administrador.setEmail("example@gmail.com");
        administrador.setFechaCreacion(date);
        administrador.setEstado("HABILITADO");
        administrador.setUsuario("example");
        administrador.setNombre("Example");
        administrador.setTelefono("4432123121");
        String jsonAdministrador = mapper.writeValueAsString(administrador);

        Mockito.doNothing().when(administradorService).save(administrador);
        mockMvc.perform(
                post("/administrador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAdministrador))
                .andExpect(status().isCreated());

    }

    @Test
    public void test_update_administrador_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Administrador administrador = new Administrador();
        Date date = new java.util.Date();
        administrador.setId(1L);
        administrador.setClave("posda");
        administrador.setEmail("example@gmail.com");
        administrador.setFechaCreacion(date);
        administrador.setEstado("HABILITADO");
        administrador.setUsuario("example");
        administrador.setNombre("Example");
        administrador.setTelefono("4432123121");
        String jsonAdministrador = mapper.writeValueAsString(administrador);

        when(administradorService.findOne(administrador.getId())).thenReturn(administrador);
        doNothing().when(administradorService).save(administrador);
        mockMvc.perform(
                put("/administrador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAdministrador))
                .andExpect(jsonPath("$.id").value(administrador.getId()))
                .andExpect(status().isOk());


    }

    @Test
    public void test_delete_administrador_success() throws Exception {

        Administrador administrador = new Administrador();
        Date date = new java.util.Date();
        administrador.setId(1L);
        administrador.setClave("posda");
        administrador.setEmail("example@gmail.com");
        administrador.setFechaCreacion(date);
        administrador.setEstado("HABILITADO");
        administrador.setUsuario("example");
        administrador.setNombre("Example");
        administrador.setTelefono("4432123121");


        when(administradorService.findOne(administrador.getId())).thenReturn(administrador);
        doNothing().when(administradorService).delete(administrador.getId());
        mockMvc.perform(
                delete("/administrador/{id}", administrador.getId()))
                .andExpect(status().isOk());

    }
}
