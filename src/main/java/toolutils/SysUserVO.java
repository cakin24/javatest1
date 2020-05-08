package toolutils;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class SysUserVO {

    private String id;
    private String username;
    private Integer age;
    private Integer status;
    private List<SysRole> roles;
    private Date createDate;
    private List<SysResource> resources;
}
