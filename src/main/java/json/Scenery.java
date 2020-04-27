/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: Scenery
 * Author:   cakin
 * Date:     2020/4/27
 * Description: 实体类
 */
package json;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: Scenery
 * @Description: 实体类
 * @Date: 2020/4/27
 * @Author: cakin
 */
@AllArgsConstructor
@ToString
public class Scenery {
    /**
     * id
     */
    private int id;
    /**
     * 名字
     */
    private String name;
    /**
     * 地址
     */
    private String address;
}
