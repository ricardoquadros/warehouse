package com.qsys.item.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qsys.item.entity.Item;
import com.qsys.item.service.ItemService;
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

@WebMvcTest(ItemController.class)
class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ItemService itemService;

    @Test
    void testGetAllUsers() throws Exception {
        List<Item> item = Arrays.asList(new Item(1, "John", "john@example.com"), new Item(2, "Jane", "jane@example.com"));
        when(itemService.getAllItems()).thenReturn(item);

        MvcResult result = mockMvc.perform(get("/api/v1/users/getAllItems"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        List<Item> responseUsers = objectMapper.readValue(resultContent, new TypeReference<>() {});

        assertEquals(item, responseUsers);
    }

    @Test
    void testGetItemById() throws Exception {
        Item item = new Item(1, "John", "john@example.com");
        when(itemService.getItemById(1)).thenReturn(item);

        MvcResult result = mockMvc.perform(get("/api/v1/item/getItemById/1"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Item responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(item, responseUser);
    }

    @Test
    void testCreateItem() throws Exception {
        Item item = new Item(2, "John", "john@example.com");
        when(itemService.saveItem(item)).thenReturn(item);

        MvcResult result = mockMvc.perform(post("/api/v1/item/saveItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Item responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(item, responseUser);
    }

    @Test
    void testUpdateItem() throws Exception {
        Item item = new Item(1, "John", "john@example.com");
        when(itemService.updateItem(item)).thenReturn(item);

        MvcResult result = mockMvc.perform(put("/api/v1/item/updateItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        Item responseUser = objectMapper.readValue(resultContent, new TypeReference<>() {});
        assertEquals(item, responseUser);
    }

    @Test
    void testDeleteItem() throws Exception {
        doNothing().when(itemService).deleteItemById(1);

        MvcResult result = mockMvc.perform(delete("/api/v1/item/deleteItemById/1"))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();

        assertTrue(resultContent.isEmpty());
    }
}
