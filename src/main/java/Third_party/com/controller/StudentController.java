package Third_party.com.controller;

import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/hello")
    public String hello(){
        String url = "http://localhost:9000/love/all";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        return studentService.client(url,method,params);
    }

//    @PostMapping("/add")
//    public String add(@RequestBody Student student){
//        return studentService.add(student);
//    }

}
