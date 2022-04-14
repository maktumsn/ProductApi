Java jdk 1.8 has been used
This has been developed in Intellij
The Database used is PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit
application.properties contains the port number,credentials for the database being used

------------------------------------------------------------------------------------------------------

Model- Product which is the Entity used here.
Repository -ProductRepository
Service -ProductService
Controller -Productcontroller

------------------------------------------------------------------------------------------------------

Getmappings-
All products ---  localhost:8100/
Byproductname ---  localhost:8100/productname/Vivo V5
Bytype ---  localhost:8100/type/Phone
Bycategory --- localhost:8100/category/Electronics
ByrangeusingMinandMax --- localhost:8100/price/100/10000

------------------------------------------------------------------------------------------------------

Post--  localhost:8100/product?sellerid=200&password=2001
Update(Put)---  localhost:8100/saveProduct/5?sellerid=200&password=2001
Del------localhost:8100/product/3?sellerid=200&password=2001

------------------------------------------------------------------------------------------------------

All the Getmappings can be accessed by both Customer and seller  but Post ,Put and delete can be accessed
by only sellers using sellerid and password which will be passed in the url for authentication .

and sellers can update or delete only their products.

------------------------------------------------------------------------------------------------------

Swagger URL-
http://localhost:8100/swagger-ui.html

------------------------------------------------------------------------------------------------------

//Mapping to get all the data including sellerid and password which won't be displayed in actual scenario,
 for checking puprose only
find the above line in the controller and uncomment the mapping just after this line.

Or

use the below Sample for Post and Put requests
{
        "pid": 1,
        "price": 17000,
        "name": "Vivo V5",
        "pcategory": "electronics",
        "ptype": "phone",
        "pdesc": "black 8-128",
        "sellerid": "100",
        "password": "1001"
    }

------------------------------------------------------------------------------------------------------

