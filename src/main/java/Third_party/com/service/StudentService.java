package Third_party.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.Student;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

public interface StudentService extends IService<Student> {
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params);

}
