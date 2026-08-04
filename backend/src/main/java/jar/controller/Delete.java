package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;

@RestController
public class Delete {

    @Autowired
    StudentRepo db;

    @DeleteMapping("/api/{id}")
    public String deleteStudent(@PathVariable long id) {

        Student exists = db.findById(id).orElse(null);

        if (exists == null) {
            return "Student not found";
        }

        db.deleteById(id);

        return "Student deleted successfully";
    }
}