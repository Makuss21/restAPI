package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Orders;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private static final int pageSize = 20;
    private final OrderRepository orderRepository;

    public List<Client> getClients(int pageNumber, Sort.Direction sort) {
        return clientRepository.findAllClients(
                PageRequest.of(pageNumber,pageSize,
                        Sort.by(sort, "id")));
    }

    public Client getSingleClient(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public List<Client> getClientsWithOrders(int pageNumber, Sort.Direction sort) {
        List<Client> allClients = clientRepository.findAllClients(
                PageRequest.of(pageNumber,pageSize,
                        Sort.by(sort, "id")));

        List<Long> ids = allClients.stream()
                .map(Client::getId)
                .toList();

        List<Orders> ordersList = orderRepository.findAllByClientIdIn(ids);
        allClients.forEach(client -> client.setOrders(extractOrders(ordersList, client.getId())));
        return allClients;
    }

    private List<Orders> extractOrders(List<Orders> ordersList, long id) {
        return ordersList.stream()
                .filter(orders -> orders.getClientId() == id)
                .toList();
    }
}
