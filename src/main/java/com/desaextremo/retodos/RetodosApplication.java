package com.desaextremo.retodos;

import com.desaextremo.retodos.model.Gadget;
import com.desaextremo.retodos.model.User;
import com.desaextremo.retodos.repository.crud.GadgetCrudRepository;
import com.desaextremo.retodos.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        gadgetCrudRepository.deleteAll();
        userCrudRepository.deleteAll();

       gadgetCrudRepository.saveAll(List.of(
                new Gadget(1, "GENIUS", "RATONES", "MAPOCALIPSIS", "Descripción", 150000, true, 10, "https://www.avasoluciones.com/wp-content/uploads/2021/09/910-006127.jpg")
        ));

        userCrudRepository.saveAll(List.of(
                new User(1, "123123", "CARLOS ALBERTO GARCIA", "CR 34-45", "311222222", "cgarcia@gmail.com", "Demo123.", "ZONA 2", "ADM")
        ));
    }

}
