package com.lzdd.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/27.
 * @description 内容交易平台
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);

    private static final long serialVersionUID = 1L;
    //存放所有的controller映射对象
    private Map<String,Object> controllers = new HashMap<>();
    //存放所有的controller下的方法
    private Map<String,Method> methods = new HashMap<>();

    public DispatcherServlet(){
        super();
    }

    /**
     * 初始化会调用
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        //1、扫描基础包（basePackage),加载其中的类 原理file对象，IO读取文件目录获取class的名字
        try {
            //controller类,利用反射
            Class clazz = Class.forName("com.lzdd.controller.DemoController");
            controllers.put(clazz.getName(),clazz.newInstance());
            //类下的方法
            Method[] ms = clazz.getMethods();
            for(Method m : ms){
                //若该方法没有AnnotationDemo注解，跳过
                if(m.getAnnotation(AnnotationDemo.class)==null){
                    continue;
                }
                AnnotationDemo ad = (AnnotationDemo) clazz.getAnnotation(AnnotationDemo.class);
                //拼接cotroller类路径+方法路径
                methods.put(m.getAnnotation(AnnotationDemo.class).value(),m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("DispatcherServlet Init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentPath = req.getContextPath();
        String uri = req.getRequestURI();
        System.out.println("contentPath"+contentPath+"  URI"+uri);
        String mappingPath = uri.substring(uri.indexOf(contentPath)+contentPath.length(),uri.indexOf(".do"));
        System.out.println("解析后的路径:"+mappingPath);

        Method method = methods.get(mappingPath);
        String className = method.getDeclaringClass().getName();
        Object controller = controllers.get(className);
        try {
            String result = (String) method.invoke(controller);
            //返回到客户端的值
            resp.getWriter().println(result);
            //返回一个普通的字符串的话,返回后对应的jsp
            //req.getRequestDispatcher("index").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    /*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>大家好，我的名字叫Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }*/

}
