/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: OptionalDemo
 * Author:   cakin
 * Date:     2020/4/24
 * Description: Optional 解决NullPointerException这个问题
 */
package optionaldemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * @ClassName: OptionalDemo
 * @Description: Optional 解决NullPointerException这个问题
 * @Date: 2020/4/24
 * @Author: cakin
 */
@Slf4j
public class OptionalDemo {
    public static void main( String[] args ) {
        Optional<Member> optional = getMemberByIdFromDB();
        optional.ifPresent(mem -> {
            log.info("name: " + mem.getName());
        });
    }

    public static Optional<Member> getMemberByIdFromDB() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("cakin"));
        }
        return Optional.empty();
    }
}

class Member {
    /**
     * 名字
     */
    private String name;

    public String getName() {
        return name;
    }

    Member( String name ) {
        this.name = name;
    }
}
