package com.example.product.Repository;

import com.example.product.Model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>
{

    @Query("select P.pid,P.name,P.price,P.pcategory,P.ptype,P.pdesc from Product P")
    List<Object[]> findAllData();
    @Query("select P.pid,P.name,P.price,P.pcategory,P.ptype,P.pdesc from Product P where P.name =:name")
    List<Object[]> findByName(String name);
   @Query("select P.pid,P.name,P.price,P.pcategory,P.ptype,P.pdesc from Product P where P.ptype =:ptype")
    List<Object[]> findByPtype(String ptype);
    @Query("select P.pid,P.name,P.price,P.pcategory,P.ptype,P.pdesc from Product P where P.pcategory =:pcategory")
    List<Object[]> findByPcategory(String pcategory);
   @Query("select P.pid,P.name,P.price,P.pcategory,P.ptype,P.pdesc from Product P where (P.price >:min AND P.price <:max)")
    List<Object[]> findByPriceGreaterThanAndPriceLessThan(int min, int max);

    List<Product> findBySelleridAndPassword(String sellerid, String password);
}
