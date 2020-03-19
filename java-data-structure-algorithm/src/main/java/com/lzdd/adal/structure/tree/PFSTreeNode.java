package com.lzdd.adal.structure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/18 4:37 下午
 * 基于 父亲-长子-兄弟模型的数节点
 **/
public class PFSTreeNode implements IPFSTree {
    private PFSTreeNode parent,firstChild,sibling;
    private Object data;

    @Override
    // 前序遍历
    public void preOrder(PFSTreeNode node, List<PFSTreeNode> list) {
        list.add(node);
        PFSTreeNode next = node.getFirstChild();
        while ( next != null){
            preOrder(next,list);
            next = next.getSibling();
        }
    }

    @Override
    public void inOrder(PFSTreeNode node, List<PFSTreeNode> list) {
        //不支持中序遍历
    }

    @Override
    // 后序遍历
    public void postOrder(PFSTreeNode node, List<PFSTreeNode> list) {
        PFSTreeNode next = node.getFirstChild();
        while (next != null){
            postOrder(next,list);
            next = next.getSibling();
        }
        list.add(node);
    }

    @Override
    // 层级遍历
    public void levelOrder(PFSTreeNode node, List<PFSTreeNode> list) {
        LinkedList<PFSTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while ( !queue.isEmpty() ){
            PFSTreeNode next = queue.pop();
            list.add(next);
            next = next.getFirstChild();
            while (next != null){
                queue.push(next);
                next = next.getSibling();
            }
        }
    }

    @Override
    public int getSize(PFSTreeNode node) {
        int size = 1;
        PFSTreeNode next = node.getFirstChild();
        while (next != null){
            size += next.getSize(next);
            next = next.getSibling();
        }
        return size;
    }

    @Override
    public int getHeight(PFSTreeNode node) {
        int height = -1;
        PFSTreeNode next = node.getFirstChild();
        while (next != null){
            height = Math.max(next.getHeight(next),height);
            next = next.getSibling();
        }
        return height + 1;
    }

    @Override
    public int getDeep(PFSTreeNode node) {
        int deep = 0;
        PFSTreeNode parent = node.getParent();
        while (parent != null){
            deep++;
            parent = parent.getParent();
        }
        return deep;
    }

    public PFSTreeNode getParent() {
        return parent;
    }

    public void setParent(PFSTreeNode parent) {
        this.parent = parent;
    }

    public PFSTreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(PFSTreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public PFSTreeNode getSibling() {
        return sibling;
    }

    public void setSibling(PFSTreeNode sibling) {
        this.sibling = sibling;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
