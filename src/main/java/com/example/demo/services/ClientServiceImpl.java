package com.example.demo.services;
import com.example.demo.dao.ClientRepo;
import com.example.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Value("${demo.url}")
    private String url;
    @Autowired
    ClientRepo clientRepo;
    @Override
    public List<Client> getAll() {
       /* final String uri = url+ "/getAllRest";
        RestTemplate restTemplate = new RestTemplate();
        Client[] result = restTemplate.getForObject(uri, Client[].class);
        return result;*/

        return clientRepo.getAll();

    }
    @Override
    public void addClient(Client Client) {
       /* final String uri = url+ "/addClientRest/"+Client;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, Client.class);*/

        clientRepo.save(Client);

    }
    @Override
    public void deleteClient(int id) {
      /*  final String uri = url+"/deleteClientRest/"+id;
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.put(uri,Client.class);*/
        clientRepo.deleteById(id);

    }
    @Override
    public Client GetOneClient(int id) {
       /* final String uri = url+ "/GetOneClientRest/"+id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;*/

        return clientRepo.getOneClient(id);
    }
}