## Idempotent

> if an identical request could be made once or several times in a row with the same effect while leaving the server in the same state , http method is **idempotent** 

 GET , HEAD , PUT , DELETE methods are idempotent, but not POST. 


if call *GET* several times in a row , would get same results.


if call *DELETE* , returned status code may change , but it still is idempotent.

```java
import com.api.idempotent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookController {

    @Autowired
    BookService service;

    @DeleteMapping("book/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
```

    DELETE http://localhost:8080/book/2 //200 if exists
    DELETE http://localhost:8080/book/2 //500 or 404 
    DELETE http://localhost:8080/book/2 //404

so should not use *DELETE* method to delete last Entry in RestAPI


for *POST* method , if called several times it would add rows as many as calling times;

    POST http://localhost:8080/book \
    -H "Content-Type: application/json; charset=utf-8" \
    -d '{"book_name" : "harry porter"}' //insert row once

    POST http://localhost:8080/book \
    -H "Content-Type: application/json; charset=utf-8" \
    -d '{"book_name" : "harry porter"}' //insert row twice

    POST http://localhost:8080/book \
    -H "Content-Type: application/json; charset=utf-8" \
    -d '{"book_name" : "harry porter"}' //insert row third

    