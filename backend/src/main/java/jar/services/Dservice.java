package jar.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jar.repo.StudentRepo;

@Service
public class Dservice {

    StudentRepo db;
    Dservice (StudentRepo db){
        this.db=db;
    }
    
  public  Map<Object, Object> ds(long id){
         Map<Object, Object> res = new HashMap<>();

        if (db.existsById(id)) {
            db.deleteById(id);

            res.put("msg", "Student Deleted Successfully");
            res.put("status", 204);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);
        }
    return res;

    }
}
