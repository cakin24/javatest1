package com.itheima.pattern.interpreter;

/**
 * @version v1.0
 * @ClassName: Plus
 * @Description: 非终结符表达式角色 加法表达式类
 * @Author: cakin
 */
public class Plus extends AbstractExpression {

    // +号左边的表达式
    private AbstractExpression left;
    // +号右边的表达式
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret(Context context) {
        // 将左边表达式的结果和右边表达式的结果进行相加
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
