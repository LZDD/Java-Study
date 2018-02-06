package com.lzdd.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangdapeng
 * @version 1.0,2014年1月19日
 * @since 1.0
 */
public class ChildrenWorker {
    private List<NodeWorker> list = new ArrayList<NodeWorker>();

    public int getSize() {
        return list.size();
    }

    public void addChild(NodeWorker node) {
        list.add(node);
    }

    // 拼接孩子节点的JSON字符串
    @Override
    public String toString() {
        String result = "[";
        for (Iterator<NodeWorker> it = list.iterator(); it.hasNext();) {
            result += it.next().toString();
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }
}