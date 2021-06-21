package com.mashibing.cor.servlet.V3;

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
        chain.add(new HtmlFilter()).add(new SensitiveFilter());
        chain.doFilter(request,response,chain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter{
    boolean doFilter(Request request, Response response,FilterChain chain);
}

class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        request.str = request.str.replace("<","[").replace(">","]");
        chain.doFilter(request,response,chain);
        response.str+="------HtmlFilter;";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        request.str = request.str.replace("996","955");
        chain.doFilter(request,response,chain);
        response.str+="------SensitiveFilter;";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        if (index == filters.size())
            return false;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request,response,chain);
    }
}

class Request{
    String str;
}

class Response{
    String str;
}


