/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: CallBack
 * Author:   cakin
 * Date:     2020/4/25
 * Description: 回调接口
 */

package asymsg;

/**
 * @className: CallBack
 * @description: 回调接口
 * @date: 2020/4/25
 * @author: cakin
 */
public interface CallBack {
    /**
     * 功能描述：执行回调方法
     *
     * @param jsonString 将处理后的结果作为参数返回给回调方法
     * @author cakin
     * @date 2020/4/25
     */
    void execute( String jsonString );
}
