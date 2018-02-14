package com.seguritech.practicafinal.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguritech.practicafinal.domain.Especialidad;
import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
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
public class MedicoControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private MedicoController medicoController;

    @Mock
    private MedicoService medicoService;

    public MedicoControllerTest() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Medico medico = new Medico();
        Date date = new java.util.Date();
        medico.setId(1L);
        medico.setClave("posda");
        medico.setEmail("example@gmail.com");
        medico.setFechaCreacion(date);
        medico.setEstado("HABILITADO");
        medico.setUsuario("example");
        medico.setNombre("Example");
        medico.setTelefono("4432123121");
        medico.setEspecialidadId(Especialidad.CARDIOLOGO);
        Mockito.when(medicoService.findOne(1L)).thenReturn(medico);

        medicoController = new MedicoController(medicoService);

        mockMvc = MockMvcBuilders.standaloneSetup(medicoController).build();
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
    public void testGetMedico_isOkWhenMedicoIsFound() throws Exception {
        System.out.println("getMedico");
        final long id = 1;

        mockMvc.perform(get("/medico/"+ id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.estado").value("HABILITADO"));
    }

    @Test
    public void testGetMedico_isError404WhenMedicoIsNotFound() throws Exception {
        System.out.println("getMedico");
        final long id = 2;

        mockMvc.perform(get("/medico/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    public void test_create_medico_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Medico medico = new Medico();
        Date date = new java.util.Date();
        medico.setClave("posda");
        medico.setEmail("example@gmail.com");
        medico.setFechaCreacion(date);
        medico.setEstado("HABILITADO");
        medico.setUsuario("example");
        medico.setNombre("Example");
        medico.setTelefono("4432123121");
        medico.setEspecialidadId(Especialidad.CARDIOLOGO);
        String jsonMedico = mapper.writeValueAsString(medico);

        Mockito.doNothing().when(medicoService).save(medico);
        mockMvc.perform(
                post("/medico")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMedico))
                .andExpect(status().isCreated());

    }

    @Test
    public void test_update_medico_success() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Medico medico = new Medico();
        Date date = new java.util.Date();
        medico.setId(1L);
        medico.setClave("posda");
        medico.setEmail("example@gmail.com");
        medico.setFechaCreacion(date);
        medico.setEstado("HABILITADO");
        medico.setUsuario("example");
        medico.setNombre("Example");
        medico.setTelefono("4432123121");
        medico.setEspecialidadId(Especialidad.CARDIOLOGO);
        String jsonMedico = mapper.writeValueAsString(medico);

        when(medicoService.findOne(medico.getId())).thenReturn(medico);
        doNothing().when(medicoService).save(medico);
        mockMvc.perform(
                put("/medico")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMedico))
                .andExpect(jsonPath("$.id").value(medico.getId()))
                .andExpect(status().isOk());


    }

    @Test
    public void test_delete_medico_success() throws Exception {

        Medico medico = new Medico();
        Date date = new java.util.Date();
        medico.setId(1L);
        medico.setClave("posda");
        medico.setEmail("example@gmail.com");
        medico.setFechaCreacion(date);
        medico.setEstado("HABILITADO");
        medico.setUsuario("example");
        medico.setNombre("Example");
        medico.setTelefono("4432123121");
        medico.setEspecialidadId(Especialidad.CARDIOLOGO);


        when(medicoService.findOne(medico.getId())).thenReturn(medico);
        doNothing().when(medicoService).delete(medico.getId());
        mockMvc.perform(
                delete("/medico/{id}", medico.getId()))
                .andExpect(status().isOk());

    }
}
