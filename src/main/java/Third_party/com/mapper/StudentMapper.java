package Third_party.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    public String client(String url, HttpMethod method, MultiValueMap params);
}
