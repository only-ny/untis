package Third_party.com.service.impl;

import Third_party.com.mapper.StudentMapper;
import Third_party.com.pojo.Student;
import Third_party.com.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class StudetServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params) {

        Student[] student = null;
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String strBody = null;
        if (response.getStatusCodeValue() == 200){
            strBody = response.getBody();
        }
        try {
            student=objectMapper.readValue(strBody,Student[].class);
            for (Student student1 : student) {
                QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("name",student1.getName());
                Student student2 = studentMapper.selectOne(queryWrapper);
                if (student2 == null){
                    studentMapper.insert(student1);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }


}
