package jar.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepo db;

    @PostMapping()
    Map<Object, Object> m1(@RequestBody Student s) {
        Map res = new HashMap<>();

        String name = s.getName();
        String email = s.getEmail();
        String ip = s.getIp();

        Student obj = new Student();

        obj.setName(name);
        obj.setEmail(email);
        obj.setIp(ip);

        db.save(obj);

        res.put("msg", "welcom post api endpoint");
        res.put("status", 201);
        res.put("student", obj.getName());

        return res;
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id,
                                @RequestBody Update update) {

        Student student = repository.findById(id).orElseThrow();

        student.setName(update.getName());
        student.setEmail(update.getEmail());
        student.setIp(update.getIp());

        return repository.save(student);
}
}
