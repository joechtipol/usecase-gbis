package fr.ych.userstory.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping(path = {"/{id}"})
    public Client findOne(@PathVariable("id") int id){
        return clientService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Client update(@PathVariable("id") int id, @RequestBody Client client){
        client.setId(id);
        return clientService.update(client);
    }

    @DeleteMapping(path ={"/{id}"})
    public Client delete(@PathVariable("id") int id) {
        return clientService.delete(id);
    }

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }
}
