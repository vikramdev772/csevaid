package jar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Aservice {

    StudentRepo db;

    Aservice(StudentRepo db) {
        this.db = db;
    }

    public List<Student> all() {
        return db.findAll();
    }
}