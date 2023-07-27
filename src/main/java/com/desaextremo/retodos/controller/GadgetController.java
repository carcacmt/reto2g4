package com.desaextremo.retodos.controller;

import com.desaextremo.retodos.model.Gadget;
import com.desaextremo.retodos.service.GadgetService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") int id) {
        return gadgetService.getGadget(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget gadget) {
        return gadgetService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return gadgetService.delete(id);
    }
    
    @GetMapping("/category/{category}")
    public List<Gadget> gadgetsByCategory(@PathVariable("category") String category){
        return gadgetService.gadgetsByCategory(category);
    }
    
    @GetMapping("/precio/{precio}")
    public List<Gadget> gadgetsByPrice(@PathVariable("precio") double precio){
        return gadgetService.gadgetsByPrice(precio);
    }
    
    @GetMapping("/name/{name}")
    public List<Gadget> gadgetsByName(@PathVariable("name") String name){
        return gadgetService.gadgetsByName(name);
    }
    
    
    @GetMapping("/category")
    public List<String> category(){
        return gadgetService.getAllCategories();
    }
}
