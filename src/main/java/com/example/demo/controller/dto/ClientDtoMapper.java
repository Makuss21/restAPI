package com.example.demo.controller.dto;

import com.example.demo.model.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDtoMapper {

    private ClientDtoMapper() {

    }

    public static List<ClientDataTransferObject> mapToDtos(List<Client> clients) {
        return clients.stream()
                .map(client -> mapToClientDto(client))
                .collect(Collectors.toList());
    }


    public static ClientDataTransferObject mapToClientDto(Client client) {
        return ClientDataTransferObject.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .created(client.getCreated())
                .build();
    }

}
