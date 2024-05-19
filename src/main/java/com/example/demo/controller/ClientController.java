package com.example.demo.controller;

import com.example.demo.controller.dto.ClientDataTransferObject;
import com.example.demo.controller.dto.ClientDtoMapper;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client")
    public List<ClientDataTransferObject> getClients(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return ClientDtoMapper.mapToDtos(clientService.getClients(pageNumber,sortDirection));
    }

    @GetMapping("/client/orders")
    public List<Client> getClientsWithOrders(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return clientService.getClientsWithOrders(pageNumber,sortDirection);
    }

    @GetMapping("/client/{id}")
    public Client getSingleClient(@PathVariable long id){
        return clientService.getSingleClient(id);
    }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }
    @PutMapping("/client")
    public Client updateClient(@RequestBody Client client){
        return clientService.editClient(client);
    }
    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }
}
