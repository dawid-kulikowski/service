package com.crud.service.Controller;


import com.crud.service.Models.Client;
import com.crud.service.Models.Order;
import com.crud.service.Repo.ClientRepo;
import com.crud.service.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ServiceController {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private OrderRepo orderRepo;

    // Client
    @GetMapping(value = "/")
    public String getPage() {
        return "Menu";
    }

    @GetMapping(value = "/clients")
    public List<Client> getClient() {
        return clientRepo.findAll();
    }


    @PostMapping(value = "/client/add")
    public String saveClient(@RequestBody Client client) {
        clientRepo.save(client);
        return "Client Saved.";
    }

    @PutMapping(value = "/client/update/{id}")
    public String updateClient(@PathVariable long id, @RequestBody Client client) {
        Client updatedClient = clientRepo.findById(id).get();
        updatedClient.setName(client.getName());
        updatedClient.setSurname(client.getSurname());
        updatedClient.setPhoneNumber(client.getPhoneNumber());
        updatedClient.setEmail(client.getEmail());
        clientRepo.save(updatedClient);
        return "Client Updated.";
    }

    @DeleteMapping(value = "/client/delete/{id}")
    public String deleteClient(@PathVariable long id) {
        Client deleteClient = clientRepo.findById(id).get();
        clientRepo.delete(deleteClient);
        return "Deleted user with id:" + id;
    }


    // Order
    @GetMapping(value = "/orders")
    public List<Order> getOrder() {
        return orderRepo.findAll();
    }

    @PostMapping(value = "/order/add")
    public String saveOrder(@RequestBody Order order) {
        orderRepo.save(order);
        return "Order saved.";
    }

    @PutMapping(value = "/order/update/{id}")
    public String updateOrder(@PathVariable long id, @RequestBody Order order) {
        Order updatedOrder = orderRepo.findById(id).get();
        updatedOrder.setDeviceType(order.getDeviceType());
        updatedOrder.setDeviceModel(order.getDeviceModel());
        updatedOrder.setRepairInfo(order.getRepairInfo());
        updatedOrder.setEstimatedPrice(order.getEstimatedPrice());
        updatedOrder.setRepairStatus(order.getRepairStatus());
        return "Order updated.";
    }

    @DeleteMapping(value = "/order/delete/{id}")
    public String deleteOrder(@PathVariable long id) {
        Order deleteOrder = orderRepo.findById(id).get();
        orderRepo.delete(deleteOrder);
        return "Deleted order with id:" + id;
    }
}

