package jar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.services.Uservice;

@RestController
public class Update {

    @Autowired
    Uservice obj;

    @PutMapping("/api/{id}")
    public Map<Object, Object> updateStudent(
            @PathVariable long id,
            @RequestBody Student dto) {

        return obj.us(id, dto);
    }
}