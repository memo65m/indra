http://localhost:8083/api/indra/h2-console/
JDBC URL: jdbc:h2:mem:testdb
user:sa
passoword: password


http://localhost:8083/api/indra/swagger-ui/index.html#/


curl -X 'GET' \
'http://localhost:8083/api/indra/price/rate?date=14%2010%3A00&productId=35455&brandId=1' \
-H 'accept: */*'