package com.lzdd.domain;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Created by fei.tang@hand-china.com on 2018/2/5.
 * @Description 内容交易平台
 * 将template的segment1、segment2、segment3转化为tree结构的json
 * 使用方法
 * String jsonStr = Object2TreeJsonUtil.generatorJson(templates);
 * templates 是Template的list集合
 */
public class Object2TreeJsonUtil {
    public Object2TreeJsonUtil() { }

    public static  String generatorJson(List<Template> list){

        List<Node> nodeList = new Object2ListUtil().object2List(list);

        //节点列表，散列表，用于临时存储节点对象
        Map<String,Node> nodeMap = new HashMap<>();
        //根节点
        Node root = null;
        for (Iterator<Node> it = nodeList.iterator();it.hasNext();){
            Node node = it.next();
            nodeMap.put(node.getId(),node);
        }

        //制造无须的多叉树
        Set<Map.Entry<String,Node>> entries = nodeMap.entrySet();
        for (Iterator<Map.Entry<String,Node>> it = entries.iterator();it.hasNext();){
            Node node = it.next().getValue();
            if(node.getPid()==null||node.getPid()==""){
                root = node;
            }else {
                nodeMap.get(node.getPid()).addChild(node);
            }
        }
        return root.toString();
    }

}

/**
 * 节点，包含节点id，父节点id，节点信息
 */
class Node{
    //节点的id
    private String id;

    //节点的父id，若为根节点父id为""
    private String pid;

    //节点的数据
    private Object data;

    //子节点
    private ChildrenNode childrenNode = new ChildrenNode();

    public Node(){
        super();
    };

    public Node(String id, String pid) {
        this.id = id;
        this.pid = pid;
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

    public ChildrenNode getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(ChildrenNode childrenNode) {
        this.childrenNode = childrenNode;
    }

    public void addChild(Node node){
        this.childrenNode.addChild(node);
    }

    /**
     * 通过java反射，获取data的所有字段，将字段拼接成json类型
     * @return 拼接的json字段
     */
    @Override
    public String toString(){
        //反射获取所有字段
        Class<? extends Object> clazz = data.getClass();
        Field[] fields = clazz.getDeclaredFields();
        //结果字符串
        StringBuilder result = new StringBuilder();
        String fieldName = null;
        String value = null;
        for (int i=0;i<fields.length;i++){
            fieldName = fields[i].getName();
            Method method = null;
            try {
                method = this.getGetMethod(data.getClass(),fieldName);
                value = (String) method.invoke(data,new Object[0]);
                if(i!=0){
                    result.append(",").append('"' + fieldName + '"' + ":" + '"' + value + '"');
                }else{
                    result.append("{").append('"' + fieldName + '"' + ":" + '"' + value + '"');
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if(childrenNode!=null && childrenNode.getSize()>0){
            result.append(",").append('"').append("children").append('"').append(":").append(childrenNode.toString());
        }
        return result.append("}").toString();
    }

    /**
     * 获取对象o字段名为fieldName的get方法
     * @param clazz 操作的对象的类类型
     * @param fieldName 字段名
     * @return 对象o的字段名相对应的get方法Method
     */
    protected Method getGetMethod(Class clazz,String fieldName) throws NoSuchMethodException {
        StringBuilder methodName = new StringBuilder("get");
        methodName.append(fieldName.substring(0,1).toUpperCase());
        methodName.append(fieldName.substring(1));
        Method method = clazz.getMethod(methodName.toString());
        return method;
    }
}

//子节点信息
class ChildrenNode{
    private List<Node> childNodes = new ArrayList<>();

    public int getSize(){
        return childNodes.size();
    }

    public void addChild(Node node){
        childNodes.add(node);
    }

    //拼接子节点json字符串
    @Override
    public  String toString(){
        String result = "[";
        //遍历子节点
        for(Iterator<Node> it = childNodes.iterator();it.hasNext();){
            result += it.next().toString()+",";
        }
        //去掉最后的,号
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result.toString();
    }
}

/**
 * 将template转换为list对象
 */
class Object2ListUtil{
    public  List object2List(List<Template> templates) {
        //segment1，segment2，segment3自动生成id，存放在list中，数组中的
        //的第一个map存放segment1的id，第二个map存放segment2的id，第三个map存放segment3的id，
        List<Map<String, Integer>> geneIds = new ArrayList<Map<String, Integer>>() {
            {
                add(new HashMap<String, Integer>());
                add(new HashMap<String, Integer>());
                add(new HashMap<String, Integer>());
            }
        };
        int id = 1;
        List<Node> nodeList = new ArrayList<>();
        for (Template template : templates){
            Node node1 = new Node();
            //当前template的segment1字段没有生成id,根节点就一个
            if(!geneIds.get(0).containsKey(template.getSegment1())){
                geneIds.get(0).put(template.getSegment1(),id);
                //设置节点信息
                Node node = new Node(Integer.toString(id),"");
                //加入segment1数据
                node.setData(new Segment1(template.getSegment1()));
                nodeList.add(node);
                id++;
            }

            //当前template的segment2字段没有生成id,二级节点有多个
            if(!geneIds.get(1).containsKey(template.getSegment2())){
                geneIds.get(1).put(template.getSegment2(),id);
                //设置节点信息,本节点id和父节点id，父节点id从genesId中的第1个map中取
                Node node = new Node(Integer.toString(id),Integer.toString(geneIds.get(0).get(template.getSegment1())));
                //加入segment1数据
                node.setData(new Segment2(template.getSegment2()));
                nodeList.add(node);
                id++;
            }

            //segment3默认不为空
            Node node3 = new Node(Integer.toString(id),Integer.toString(geneIds.get(1).get(template.getSegment2())));
            node3.setData(new Segment3(template.getSegment3(),template.getTemplateId()));
            nodeList.add(node3);
            id++;
        }
        return nodeList;
    }


}


//大类
class Segment1{
    private String segment1;
    public Segment1(String segment1){
        this.segment1 = segment1;
    }
    public String getSegment1() {
        return segment1;
    }
    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }
}
//中类
class Segment2{
    private String segment2;
    public Segment2(String segment2){
        this.segment2 = segment2;
    }
    public String getSegment2() {
        return segment2;
    }
    public void setSegment2(String segment2) {
        this.segment2= segment2;
    }
}

//小类
class Segment3{
    private String segment3;
    private String templateId;
    public Segment3(String segment3, String templateId) {
        this.segment3 = segment3;
        this.templateId = templateId;
    }
    public String getSegment3() {
        return segment3;
    }
    public void setSegment3(String segment3) {
        this.segment3 = segment3;
    }
    public String getTemplateId() {
        return templateId;
    }
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}