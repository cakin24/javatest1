/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: EUser
 * Author:   cakin
 * Date:     2020/4/26
 * Description: 用户类
 */
package toolutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: EUser
 * @Description: 用户类
 * @Date: 2020/4/26
 * @Author: cakin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EUser implements Serializable {
    private long id;
    private String username;
}
