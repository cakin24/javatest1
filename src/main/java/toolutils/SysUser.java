package toolutils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUser implements Serializable  {
    private String id;
    private String username;
    private Integer age;
    private String password;
    private Integer status;
    private List<SysRole> roles;
    private Date createDate;
    private static final long serialVersionUID = 1L;
}
