package com.example.product.Controller;

import com.example.product.Model.Product;
import com.example.product.Service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Productcontroller {

    @Autowired
    Productservice productservice;
    @GetMapping("/")
    public List<Object[]> getAll() {
        return  productservice.retrieveAllProductss();
    }

    @GetMapping("/productname/{name}")
    public ResponseEntity<?> getProductBYname(@PathVariable String name) {
        return ResponseEntity.ok().body(productservice.retrieveProductsByName(name));
    }
    @GetMapping("/type/{ptype}")
    public ResponseEntity<?> getProductBYtype(@PathVariable String ptype) {
        return ResponseEntity.ok().body(productservice.retrieveProductsByType(ptype));
    }
    @GetMapping("/category/{pcategory}")
    public ResponseEntity<?> getProductBYcategory(@PathVariable String pcategory) {
        return ResponseEntity.ok().body(productservice.retrieveProductsByCategory(pcategory));
    }
    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<?> getProductBYPrice(@PathVariable int min,@PathVariable int max) {
        return ResponseEntity.ok().body(productservice.retrieveProductsByPrice(min,max));
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct
    (@RequestBody Product product, @RequestParam(defaultValue = "empty")  String sellerid,
     @RequestParam(defaultValue = "empty") String password){

        List<Product> products =productservice.retrieveProductsBySelleridAndPassword(sellerid,password);
      if(sellerid.equals("empty") || password.equals("empty") )
         return null;
    else if(products==null)
        return null;
    else
        return ResponseEntity.ok().body(productservice.saveproduct(product));
    }
    @PutMapping("/saveProduct/{pid}")
    public ResponseEntity<?> updateProduct(@PathVariable int pid,@RequestBody Product product, @RequestParam(defaultValue = "empty")  String sellerid,
                                           @RequestParam(defaultValue = "empty") String password) {
        List<Product> products =productservice.retrieveProductsBySelleridAndPassword(sellerid,password);
        Product retrieveProducts = productservice.retrieveProducts(pid);
        if(sellerid.equals(retrieveProducts.getSellerid()) && password.equals(retrieveProducts.getPassword()) && !(products==null))
        {
            Product savedproduct = productservice.updateproduct(product);
            return ResponseEntity.accepted().body(savedproduct);
        }
        else
            return null;
    }

    @DeleteMapping("/product/{pid}")
    public void deleteCustomer(@PathVariable int pid,@RequestParam(defaultValue = "empty")  String sellerid,
                               @RequestParam(defaultValue = "empty") String password) {
        List<Product> products =productservice.retrieveProductsBySelleridAndPassword(sellerid,password);
        Product product = productservice.retrieveProducts(pid);
        if(sellerid.equals(product.getSellerid()) && password.equals(product.getPassword()) && !(products==null) ) {

            productservice.deleteProducts(pid);
        }
    }
    //Mapping to get all the data including sellerid and password which won't be displayed in actual scenario,for checking puprose only
//    @GetMapping("/products")
//    public List<Product> getAllproducts() {
//        return  productservice.retrieveAllProducts();
//    }

}
