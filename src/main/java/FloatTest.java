/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: FloatTest
 * Author:   cakin
 * Date:     2020/6/7
 * Description: 浮点数问题
 */

/**
 * @ClassName: FloatTest
 * @Description: 浮点数问题：有限，大约，舍入误差 接近不等于,浮点数不要用于银行业务，用BigDecimal
 * @Date: 2020/6/7
 * @Author: cakin
 */
public class FloatTest {
    public static void main(String[] args) {
        float d1 = 5434534.1F;
        float d2 = d1 + 1;
        System.out.println(d1 == d2);

        float f = 0.1F;
        double d = 0.1;
        System.out.println(d == f);

    }
}
