package jar.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PutMapping("/update/{id}")
    public Map<Object, Object> updateStudent(@PathVariable Long id, @RequestBody Student s) {

        Map<Object, Object> res = new HashMap<>();

        Optional<Student> optionalStudent = db.findById(id);

        if (optionalStudent.isPresent()) {

            Student obj = optionalStudent.get();

            obj.setName(s.getName());
            obj.setEmail(s.getEmail());
            obj.setIp(s.getIp());

            db.save(obj);

            res.put("msg", "Student updated successfully");
            res.put("status", 200);
            res.put("student", obj);

        } else {

            res.put("msg", "Student not found");
            res.put("status", 404);

        }

        return res;
    }
}