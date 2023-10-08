package com.geekster.Test6.Controller;

import com.geekster.Test6.Model.Laptop;
import com.geekster.Test6.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable("id") String id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable("id") String id, @RequestBody Laptop laptop) {
        laptop.setLaptopID(id);
        return laptopService.updateLaptop(laptop);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable("id") String id) {
        laptopService.deleteLaptop(id);
    }
}
