package com.example.productservice.seeder;

import com.example.productservice.entities.Product;
import com.example.productservice.repositories.ProductRepository;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

//@Component
public class Seeder {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

//    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        System.out.println("I am ");

        BufferedReader reader = new BufferedReader(new FileReader(new ClassPathResource("data.csv").getFile()));
        String line = "";
        List<String> header;
        int counter = 0;

        Set<Product> products = new HashSet<>();
        List<String> names = new ArrayList<>();
        while((line = reader.readLine()) != null){
            List<String> list = new ArrayList<>(Arrays.asList(line.split(",")));
            if(counter == 0) {
                header = list;
                counter++;

                continue;
            }

            try{
                Product product = new Product();
                product.setName(list.get(2));

                if (names.contains(list.get(2))){
                    counter++;
                    continue;
                }
                product.setPrice(Float.parseFloat(list.get(5)) * 100f);
                product.setInfo(list.get(2));
                products.add(product);

                names.add(list.get(2));

                if (products.size() > 10000){
                    productRepository.saveAll(products);
                    System.out.println("counter:"+ counter);
                    System.out.println("10000 record saved");
                    products.clear();
                }
            }catch(Exception ex){
//                ex.printStackTrace();
            }
            counter++;
        }

        productRepository.saveAll(products);
        System.out.println("all record saved");
    }
}
