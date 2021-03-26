package com.example.demo.services;


import com.example.demo.models.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAll();
    public void addClient(Client client);
    public void deleteClient(int id);
    public Client GetOneClient(int id);


}