package com.example.spring_data_jpa.repo;

import com.example.spring_data_jpa.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private  ProductRepository productRepository;

    @Test
   public void  save(){
       //create  Product
       Product product= new Product();
       product.setName("prodcut 1 ");
        product.setPrice(new BigDecimal(100));
        product.setDescription("product 1 desc");
      product.setSku("100ABC");
       //save Product
      Product saveObject=productRepository.save(product);
        //display product
       System.out.println(saveObject.getId());
       System.out.println(saveObject.toString());

   }

   @Test
    public void updateUsingSaveMethod(){
        //find or retrive an entity by id
        Long id=1L;
        Product product= productRepository.findById(id).get();
        //update entity information
       product.setName("updated product 1");
       product.setDescription("updated description 1 desc");
       //save updated entity
       productRepository.save(product);
   }

   @Test
   public void findByIdMethod(){
        Long id=1L;
        Product product=productRepository.findById(id).get();

   }
   //
   @Test
   public void saveAllMethod(){
       //create  Product
       Product product= new Product();
       product.setName("prodcut 2 ");
       product.setPrice(new BigDecimal(200));
       product.setDescription("product 2 desc");
       product.setSku("200ABC");

       //create  Product
       Product product3= new Product();
       product3.setName("prodcut 3 ");
       product3.setPrice(new BigDecimal(300));
       product3.setDescription("product 3desc");
       product3.setSku("300ABC");

       //productRepository.saveAll(List.of(product,product3));
   }
   @Test
   public void findAllMethod(){
        List<Product> products= productRepository.findAll();
        products.forEach((product -> {
            System.out.println(product.getName());
        }));
   }

   @Test
   public  void deleteById(){
        Long id=1L;
        productRepository.deleteById(id);
   }
}