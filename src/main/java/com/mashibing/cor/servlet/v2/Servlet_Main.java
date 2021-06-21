package com.mashibing.cor.servlet.v2;

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
        chain.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter{
    boolean doFilter(Request request, Response response);
}

class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("<","[").replace(">","]");
        response.str += "------HtmlFilter()";
        return true;
    }
}

class Request{
    String str;
}

class Response{
    String str;
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("996","955");
        response.str += "----------SensitiveFilter";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter filter : filters) {
            filter.doFilter(request,response);
        }
        return true;
    }
}
