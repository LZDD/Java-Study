package com.lzdd.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Created by fei.tang@hand-china.com on 2018/2/3.
 * @description 内容交易平台
 */
public class NodeWorker {

    /**
     *自身id
     */
    private String id;
    /**
     * 父id
     */
    private String pid;
    /**
     * 节点内容
     */
    private Object data;
    /**
     * 孩子节点列表
     */
    private ChildrenWorker children = new ChildrenWorker();

    public NodeWorker() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 先序遍历，拼接JSON字符串

    /**
     * 通过java反射，获取data的所有字段，将字段拼接成json类型
     * @return 拼接的json字段
     */
    @Override
    public String toString() {
        Class<? extends Object> clazz = data.getClass();
        Field[] field = clazz.getDeclaredFields();

        String name = null;
        String value = null;
        StringBuilder result=new StringBuilder();
        //先拼接自身的字段
        for (int i = 0; i < field.length; i++) {
            name = field[i].getName();
            value = (String) invokeGet(data, name);
            if(i!=0){
                result.append(",").append('"' + name + '"' + ":" + '"' + value + '"');

            }else{
                result.append("{").append('"' + name + '"' + ":" + '"' + value + '"');
            }
        }

        //再拼接子节点
        if (children != null && children.getSize() != 0) {
            result.append(",").append('"').append("children").append('"').append(":").append(children.toString());
        } else {
//          result.append(",").append('"' + "leaf" + '"' + ":" + '"' + "true" + '"');
        }

        return result.append("}").toString();
    }

    /**
     * java反射bean的get方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    @SuppressWarnings("unchecked")
    public Method getGetMethod(Class objectClass, String fieldName) {
        StringBuffer sb = new StringBuffer();
        sb.append("get");
        sb.append(fieldName.substring(0, 1).toUpperCase());
        sb.append(fieldName.substring(1));
        try {
            return objectClass.getMethod(sb.toString());
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 执行get方法
     *
     * @param o
     *            执行对象
     * @param fieldName
     *            属性
     */
    public Object invokeGet(Object o, String fieldName) {
        Method method = getGetMethod(o.getClass(), fieldName);
        try {
            //method的invoke(对象，method的参数)，new Object[0]代表没有参数
            return method.invoke(o, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 添加孩子节点
    public void addChild(NodeWorker node) {
        this.children.addChild(node);
    }


}