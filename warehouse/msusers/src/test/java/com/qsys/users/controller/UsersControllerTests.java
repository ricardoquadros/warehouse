package com.qsys.users.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qsys.users.entity.Users;
import com.qsys.users.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
class UsersControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UsersService userService;

    @Test
    void testGetAllUsers() throws Exception {
        List<Users> users = Arrays.asList(new Users(1, "John", "john@example.com"), new Users(2, "Jane", "jane@example.com"));
        when(userService.getAllUsers()).thenReturn(users);

        MvcResult result = mockMvc.perform(get("/api/v1/users/getAllUsers"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        List<Users> responseUsers = objectMapper.readValue(resultContent, new TypeReference<>() {});

        assertEquals(users, responseUsers);
    }

    @Test
    void testGetUserById() throws Exception {
        Users user = new Users(1, "John", "john@example.com");
        when(userService.getUserById(1)).thenReturn(user);

        MvcResult result = mockMvc.perform(get("/api/v1/users/getUserById/1"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Users responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(user, responseUser);
    }

    @Test
    void testCreateUser() throws Exception {
        Users user = new Users(2, "John", "john@example.com");
        when(userService.saveUser(user)).thenReturn(user);

        MvcResult result = mockMvc.perform(post("/api/v1/users/saveUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Users responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(user, responseUser);
    }

    @Test
    void testUpdateUser() throws Exception {
        Users user = new Users(1, "John", "john@example.com");
        when(userService.updateUser(user)).thenReturn(user);

        MvcResult result = mockMvc.perform(put("/api/v1/users/updateUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Users responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(user, responseUser);
    }

    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUserById(1);

        MvcResult result = mockMvc.perform(delete("/api/v1/users/deleteUserById/1"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        assertTrue(resultContent.isEmpty());
    }
}
