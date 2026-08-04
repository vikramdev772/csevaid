package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class Delete {

    @Autowired
    StudentRepo db;

    @DeleteMapping("/delete/{id}")
    public Map<Object, Object> deleteStudent(@PathVariable Long id) {

        Map<Object, Object> res = new HashMap<>();

        if (db.existsById(id)) {

            db.deleteById(id);

            res.put("msg", "Student deleted successfully");
            res.put("status", 200);

        } else {

            res.put("msg", "Student not found");
            res.put("status", 404);

        }

        return res;
    }
}