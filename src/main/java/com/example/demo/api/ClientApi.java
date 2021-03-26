package com.example.demo.api;
import com.example.demo.dao.ClientRepo;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*@CrossOrigin(origins = "http://localhost:8081")*/
@RestController
@RequestMapping("/api")
public class ClientApi {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    private ClientService clientServices;
    @GetMapping(value = "/getAllRest")
    public List<Client> getAll(){

        return  clientServices.getAll();
    }
    @PutMapping(value = "/addClientRest")
    public void addUserRest(@RequestBody Client client) throws JsonProcessingException {
        clientServices.addClient(client);
    }
    @PutMapping(value = "/deleteClientRest/{id}")
    public void deleteUserRest(@PathVariable int id) throws
            JsonProcessingException {
        clientServices.deleteClient(id);
    }
    @GetMapping(value = "/GetOneClientRest/{id}")
    public Client GetOneUserRest(@PathVariable int id){

        return clientServices.GetOneClient(id);
    }
}