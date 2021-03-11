package com.itheima.pattern.interpreter;

/**
 * @version v1.0
 * @ClassName: AbstractExpression
 * @Description: 抽象表达式类
 * 定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()
 * @Author: cakin
 */
public abstract class AbstractExpression {

    public abstract int interpret(Context context);
}
