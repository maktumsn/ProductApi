package com.example.product.Service;

import com.example.product.Model.Product;
import com.example.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class Productservice {
    @Autowired
    ProductRepository repository;

    public List<Object[]> retrieveAllProductss()
    {
        return  (List<Object[]>) repository.findAllData();
    }
    public Product retrieveProducts(int pid)
    {

        return repository.findById(pid).orElse(null);

    }
    public List<Object[]> retrieveProductsByName( String name)
    {
        List<Object[]> product = repository.findByName(name);
        return  product;
    }
    public List<Object[]> retrieveProductsByType( String ptype)
    {
        List<Object[]> product = repository.findByPtype(ptype);
        return  product;
    }
    public List<Object[]> retrieveProductsByCategory( String pcategory)
    {
        List<Object[]> product = repository.findByPcategory(pcategory);
        return  product;
    }
    public List<Object[]> retrieveProductsByPrice( int min,int max )
    {
        List<Object[]> product = repository.findByPriceGreaterThanAndPriceLessThan(min,max);
        return  product;
    }

    public Product saveproduct(Product product)
    {
        Product savedProducts = repository.save(product);
        return savedProducts;

    }
    public void deleteProducts(@PathVariable int pid)
    {
        repository.deleteById(pid);
    }
    public Product updateproduct( Product product)
    {

        Product savedproduct = repository.save(product);

        return savedproduct;
    }

    public List<Product> retrieveProductsBySelleridAndPassword( String sellerid,String password )
    {
        List<Product> product = repository.findBySelleridAndPassword(sellerid,password);
        return  product;
    }
    public List<Product> retrieveAllProducts()
    {
        return  (List<Product>) repository.findAll();
    }


}
