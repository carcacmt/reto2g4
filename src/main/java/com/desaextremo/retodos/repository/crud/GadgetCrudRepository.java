/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desaextremo.retodos.repository.crud;

import com.desaextremo.retodos.model.Gadget;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author desaextremo
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer> {
    public List<Gadget> findByPriceLessThanEqual(double precio);

    public List<Gadget> findByCategory(String categoria);

    @Query("{'name':{'$regex':'?0','$options':'i'}}")
    public List<Gadget> findByNameLike(String name);
}
