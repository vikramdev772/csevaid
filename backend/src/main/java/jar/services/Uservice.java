package jar.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Uservice {

    StudentRepo db;

    Uservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> us(long id, Student dto) {

        Map<Object, Object> res = new HashMap<>();

        Student d = db.findById(id).orElse(null);

        if (d != null) {

            d.setName(dto.getName());
            d.setEmail(dto.getEmail());
            d.setIp(dto.getIp());

            db.save(d);

            res.put("msg", "Student Updated Successfully");
            res.put("status", 200);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);
        }

        return res;
    }
}