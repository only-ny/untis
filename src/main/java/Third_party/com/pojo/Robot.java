package Third_party.com.pojo;

import lombok.Data;

@Data
public class Robot {

    private Integer reqType;

    private Perception perception;

    private UserInfo userInfo;
}
