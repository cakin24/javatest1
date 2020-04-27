/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: GsonTest
 * Author:   cakin
 * Date:     2020/4/27
 * Description: json测试
 */
package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Constant.NUM2;
import static common.Constant.NUM4;
import static common.Constant.NUM5;
import static common.Constant.SPLIT_LINE;

/**
 * @className: GsonTest
 * @description: json测试
 * @date: 2020/4/27
 * @author: cakin
 */
@Slf4j
public class GsonTest {
    public static void main( String[] args ) {
        log.info(SPLIT_LINE);
        jsonObjTest();
        log.info(SPLIT_LINE);
        jsonListTest();
        log.info(SPLIT_LINE);
        jsonMapTest();
        log.info(SPLIT_LINE);
    }

    /**
     * JSON 和 对象 的相互转换
     */
    private static void jsonObjTest() {
        Scenery scenery = new Scenery(1, "天坛公园", "北京");

        Gson gson = new Gson();
        // 使用 toJson() 方法将Java对象转换json字符串
        String json = gson.toJson(scenery);
        log.info(json);

        // 使用 formJson 方法将 json 字符串转换为Java对象
        Scenery sceneryBean = gson.fromJson(json, Scenery.class);
        log.info("" + sceneryBean);
    }

    /**
     * JSON 和 List 的相互转换
     */
    private static void jsonListTest() {
        // List 和json的互转
        List<Scenery> list = new ArrayList<>();
        list.add(new Scenery(NUM2, "野人谷风景区", "湖北"));
        list.add(new Scenery(NUM4, "绿野山庄", "浙江"));
        list.add(new Scenery(NUM5, "天坛公园", "北京"));
        // 创建 gson 工具类
        Gson gson = new Gson();
        // 使用 toJson() 方法 把list集合转换为json字符串
        String json = gson.toJson(list);
        log.info(json);

        // 使用fromJson() 方法将json字符串转换为list集合
        // 使用匿名内部类
        List<Scenery> list1 = gson.fromJson(json, new TypeToken<List<Scenery>>() {
        }.getType());
        log.info("" + list1);

        // 转成java对象
        Scenery scenery = list1.get(0);
        log.info("" + scenery);

    }

    /**
     * JSON 和 Map 的相互转换
     */
    private static void jsonMapTest() {
        Map<String, Scenery> sceneryMap = new HashMap<>();
        sceneryMap.put("CN10121010103A", new Scenery(NUM2, "杭州极地海洋公园", "杭州"));
        sceneryMap.put("CN10121010104A", new Scenery(NUM4, "雷峰塔", "杭州"));
        sceneryMap.put("CN10109060801A", new Scenery(NUM5, "八达岭长城", "北京"));
        Gson gson = new Gson();
        // Map对象转成json字符串使用 toJson() 方法
        String json = gson.toJson(sceneryMap);
        log.info(json);

        // json字符串转换成 map集合
        // 使用匿名内部类
        Map<String, Scenery> map = gson.fromJson(json, new TypeToken<Map<String, Scenery>>() {
        }.getType());
        log.info("" + map);
        Scenery cn10109060801A = map.get("CN10109060801A");
        log.info("" + cn10109060801A);
    }
}
