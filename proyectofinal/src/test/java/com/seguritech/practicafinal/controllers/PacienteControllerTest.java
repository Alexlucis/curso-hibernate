package com.seguritech.practicafinal.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.service.PacienteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.internal.stubbing.BaseStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;


import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PacienteController pacienteController;

    @Mock
    private PacienteService pacienteService;

    public PacienteControllerTest() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Paciente paciente = new Paciente();
        Date date = new java.util.Date();
        paciente.setId(1L);
        paciente.setClave("posda");
        paciente.setEmail("example@gmail.com");
        paciente.setFechaCreacion(date);
        paciente.setEstado("HABILITADO");
        paciente.setUsuario("example");
        paciente.setNombre("Example");
        paciente.setTelefono("4432123121");
        paciente.setObraSocial(ObraSocial.OSDE);
        Mockito.when(pacienteService.findOne(1L)).thenReturn(paciente);

        pacienteController = new PacienteController(pacienteService);

        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController).build();
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
    public void testGetPaciente_isOkWhenPacienteIsFound() throws Exception {
        System.out.println("putPaciente");
        final long id = 1;

        mockMvc.perform(get("/paciente/"+ id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.estado").value("HABILITADO"));
    }

    @Test
    public void testGetPaciente_isError404WhenPacienteIsNotFound() throws Exception {
        System.out.println("getPaciente");
        final long id = 2;

        mockMvc.perform(get("/paciente/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    public void test_create_paciente_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = new Paciente();
        Date date = new java.util.Date();
        paciente.setClave("posda1");
        paciente.setEmail("example@gmail.com1");
        paciente.setFechaCreacion(date);
        paciente.setEstado("HABILITADO1");
        paciente.setUsuario("exampl3e");
        paciente.setNombre("Examp1le");
        paciente.setTelefono("44321243121");
        paciente.setObraSocial(ObraSocial.OSDE);
        String jsonPaciente = mapper.writeValueAsString(paciente);

        Mockito.doNothing().when(pacienteService).save(paciente);
        mockMvc.perform(
                post("/paciente")
                        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonPaciente))
                .andExpect(status().isCreated());

    }

    @Test
    public void test_update_paciente_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        Date date = new java.util.Date();
        paciente.setClave("posda1");
        paciente.setEmail("example@gmail.com1");
        paciente.setFechaCreacion(date);
        paciente.setEstado("HABILITADO1");
        paciente.setUsuario("exampl3e");
        paciente.setNombre("Examp1le");
        paciente.setTelefono("44321243121");
        paciente.setObraSocial(ObraSocial.OSDE);
        String jsonPaciente = mapper.writeValueAsString(paciente);

        when(pacienteService.findOne(paciente.getId())).thenReturn(paciente);
        doNothing().when(pacienteService).save(paciente);
        mockMvc.perform(
                put("/paciente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPaciente))
                .andExpect(jsonPath("$.id").value(paciente.getId()))
                .andExpect(status().isOk());


    }

    @Test
    public void test_delete_paciente_success() throws Exception {

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        Date date = new java.util.Date();
        paciente.setClave("posda1");
        paciente.setEmail("example@gmail.com1");
        paciente.setFechaCreacion(date);
        paciente.setEstado("HABILITADO1");
        paciente.setUsuario("exampl3e");
        paciente.setNombre("Examp1le");
        paciente.setTelefono("44321243121");
        paciente.setObraSocial(ObraSocial.OSDE);


        when(pacienteService.findOne(paciente.getId())).thenReturn(paciente);
        doNothing().when(pacienteService).delete(paciente.getId());
        mockMvc.perform(
                delete("/paciente/{id}", paciente.getId()))
                .andExpect(status().isOk());

    }


}
