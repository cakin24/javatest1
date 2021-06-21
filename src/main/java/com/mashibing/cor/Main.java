package com.mashibing.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.msg = "大家好：），<script>欢迎大家访问mashibing.com，大家都是996";
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HtmlFilter());
//        filters.add(new SensitiveFilter());
//        for (Filter filter : filters) {
//            filter.doFilter(msg);
//        }
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new SensitiveFilter());
        FilterChain f2 = new FilterChain();
        f2.add(new FaceFilter()).add(new URLFilter());

        filterChain.add(f2);

        filterChain.doFilter(msg);
        System.out.println(msg);

    }
}

class Msg{
    String name;
    String msg;

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.msg;
        r = r.replace('<','[');
        r = r.replace('>',']');
        msg.msg = r;
        return true;
    }
}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.msg;
        r = r.replace("996","955");
        msg.msg = r;
        return false;
    }
}

class FaceFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.msg;
        r = r.replace("：）","^v^");
        msg.msg = r;
        return true;
    }
}

class URLFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.msg;
        r = r.replace("mashibing.com","http://www.mashibing.com");
        msg.msg = r;
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if(!filter.doFilter(msg)) return false;
        }
        return true;
    }

}