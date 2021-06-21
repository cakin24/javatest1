package com.mashibing.cor.servlet.v4;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuanzt
 * @Date: 2021/3/18
 */
public class Servlet_Main {

    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好：)，<script>，欢迎大家访问mashibing.com，大家都是996";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter())
                .add(new SensitiveFilter())
                .add(new URLFilter());
        chain.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter{
    void doFilter(Request request,Response response,FilterChain filterChain);
}

class HtmlFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replace("<","[").replace(">","]");
        filterChain.doFilter(request,response);
        response.str+="--HtmlFilter;";
    }
}

class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replace("996","955");
        filterChain.doFilter(request,response);
        response.str+="--SensitiveFilter;";
    }
}

class URLFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replace("mashibing.com","www.mashibing.com");
        filterChain.doFilter(request,response);
        response.str+="--URLFilter;";
    }
}

class Request{
    String str;
}

class Response{
    String str;
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();
    int index=0;

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response){
        if (index == filters.size()) return;
        Filter filter = filters.get(index);
        index ++;
        filter.doFilter(request,response,this);
    }
}