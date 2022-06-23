package com.crud.service.Controller;


import com.crud.service.Models.Client;
import com.crud.service.Repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ServiceController {

    @Autowired
    private ClientRepo clientRepo;



     @GetMapping(value = "/")
    public String getPage() {
         return "Serwis";
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










}
