package com.lzdd.domain;

/**
 *
 * @author zhangdapeng
 * @version 1.0,2014年5月13日
 * @since 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author zhangdapeng
 * @version 1.0,2014年5月13日
 * @since   1.0
 */
public class MultiTreeBuilder {

    /**
     *
     */
    public MultiTreeBuilder() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 安预定义排列
     * @param list
     * @return
     */
    public String generateJson(List<NodeWorker> list) {
        // 节点列表（散列表，用于临时存储节点对象）
        HashMap<String, NodeWorker> nodemap = new HashMap<String, NodeWorker>();
        // 根节点
        NodeWorker root = null;
        // 根据结果集构造节点列表（存入散列表）
        for (Iterator<NodeWorker> it = list.iterator(); it.hasNext();) {
            NodeWorker node = it.next();
            nodemap.put(node.getId(), node);
        }
        // 构造无序的多叉树
        Set<Entry<String, NodeWorker>> entrySet = nodemap.entrySet();
        for (Iterator<Entry<String, NodeWorker>> it = entrySet.iterator(); it.hasNext();) {
            NodeWorker node = it.next().getValue();
            if (node.getPid() == null || node.getPid().equals("")) {
                root = node;
            } else {
                nodemap.get(node.getPid()).addChild(node);
            }
        }
        // 输出无序的树形菜单的JSON字符串
        return root.toString();
    }


    public static void main(String[] args) {
        // 读取层次数据结果集列表
        List<NodeWorker> dataList = new ArrayList<NodeWorker>();

        NodeWorker dataNode1 = new NodeWorker();
        dataNode1.setId("1030000");
        Node2 n2=new Node2();
        n2.setText("北京软件解放道支部");
        //n2.setContent("1030000");
        dataNode1.setData(n2);
        dataNode1.setPid("100000");


        NodeWorker dataNode2 = new NodeWorker();
        dataNode2.setId("1200000");
        Node2 n1=new Node2();
        n1.setText("北京软件三大街支部");
        //n1.setContent("1200000");
        dataNode2.setData(n1);
        dataNode2.setPid("100000");

        NodeWorker dataNode3 = new NodeWorker();
        dataNode3.setId("112100");
        Node2 n4=new Node2();
        n4.setText("北京软件三大街支部4");
        //n4.setContent("12000004");
        dataNode3.setData(n4);
        dataNode3.setPid("1200000");
//
//      Node dataNode4 = new Node();
//      dataNode4.id="113000";
//      dataNode4.text="北京软件开发区支部";
//      dataNode4.parentId="110000";

        NodeWorker dataNode5 = new NodeWorker();
        dataNode5.setId("100000");
        Node2 n3=new Node2();
        n3.setText("北京软件总部");
        //n3.setContent("100000");
        dataNode5.setData(n3);
        dataNode5.setPid("");


//      Node dataNode6 = new Node();
//      dataNode6.id="110000";
//      dataNode6.text="北京支部";
//      dataNode6.parentId="100000";
//
//      Node dataNode7 = new Node();
//      dataNode7.id="111000";
//      dataNode7.text="北京软件金光道支部";
//      dataNode7.parentId="110000";


//      HashMap dataNode123 = new HashMap();
//      dataNode123.put("id", "123");
//      dataNode123.put("text", "北京软件开发区支部");
//      dataNode123.put("parentId", "12");


        dataList.add(dataNode1);
        dataList.add(dataNode2);
        dataList.add(dataNode5);
        dataList.add(dataNode3);

        MultiTreeBuilder mt = new MultiTreeBuilder();
        System.out.println(mt.generateJson(dataList));

        List<String[]> list = new ArrayList<String[]>(){{
            add(new String[]{"大类","中类","小类"});
            add(new String[]{"大类","中类","小类1"});
            add(new String[]{"大类","中类","小类2"});
            add(new String[]{"大类","中类","小类3"});
            add(new String[]{"大类","中类1","小类1"});
            add(new String[]{"大类","中类1","小类2"});
            add(new String[]{"大类","中类1","小类3"});
            add(new String[]{"大类","中类1","小类4"});
        }};

        List<Map<String,Integer>> geneIds = new ArrayList<Map<String,Integer>>(){
            {
                add(new HashMap<String,Integer>());
                add(new HashMap<String,Integer>());
                add(new HashMap<String,Integer>());
            }
        };
        int id = 0;

        List<NodeWorker> dataListSegment = new ArrayList<>();

        for (String[] li : list){
            NodeWorker nodeWorker1 = new NodeWorker();
            Node2 node1 = new Node2();
            if(!geneIds.get(0).containsKey(li[0])){
                geneIds.get(0).put(li[0],id);
                id++;
                nodeWorker1.setId(Integer.toString(geneIds.get(0).get(li[0])));
                nodeWorker1.setPid("");
                node1.setText(li[0]);
                nodeWorker1.setData(node1);
            }


            NodeWorker nodeWorker2 = new NodeWorker();
            Node2 node2 = new Node2();
            if(!geneIds.get(1).containsKey(li[1])){
                geneIds.get(1).put(li[1],id);
                id++;
                nodeWorker2.setId(Integer.toString(geneIds.get(1).get(li[1])));
                nodeWorker2.setPid(Integer.toString(geneIds.get(0).get(li[0])));
                node2.setText(li[1]);
                nodeWorker2.setData(node2);
            }


            NodeWorker nodeWorker3 = new NodeWorker();
            Node2 node3 = new Node2();
            if(!geneIds.get(2).containsKey(li[2])){
                geneIds.get(2).put(li[2],id);
                id++;
                nodeWorker3.setId(Integer.toString(geneIds.get(2).get(li[2])));
                nodeWorker3.setPid(Integer.toString(geneIds.get(1).get(li[1])));
                node3.setText(li[2]);
                nodeWorker3.setData(node3);
            }


            if (nodeWorker1.getData()!=null){
                dataListSegment.add(nodeWorker1);
            }
            if (nodeWorker2.getData()!=null){
                dataListSegment.add(nodeWorker2);
            }
            if (nodeWorker3.getData()!=null){
                dataListSegment.add(nodeWorker3);
            }
        }

        System.out.println(geneIds.toString());
        System.out.println(mt.generateJson(dataListSegment));

    }
}

