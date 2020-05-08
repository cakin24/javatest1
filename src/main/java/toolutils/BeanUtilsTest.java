/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: BeanUtilsTest
 * Author:   cakin
 * Date:     2020/5/8
 * Description: 不同结构类拷贝
 */
package toolutils;


import org.springframework.beans.BeanUtils;

import static common.Constant.NUM10;

/**
 * @ClassName: BeanUtilsTest
 * @Description: 不同结构类拷贝
 * @Date: 2020/5/8
 * @Author: cakin
 */
public class BeanUtilsTest {

    public static void main( String[] args ) {
        SysUser v = new SysUser();
        v.setId("1258674238592294913");
        v.setUsername("cakin");
        v.setAge(NUM10);
        v.setPassword("75fbae06dcf2eecade95992fbb41eaa2");
        v.setStatus(1);
        SysUserVO vo = new SysUserVO();
        BeanUtils.copyProperties(v, vo);
        System.out.println(vo);
    }
}
