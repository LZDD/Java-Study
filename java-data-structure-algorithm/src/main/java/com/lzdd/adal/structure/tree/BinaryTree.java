package com.lzdd.adal.structure.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/18 8:42 下午
 **/
public class BinaryTree {
    private BNode root; // 根节点

    public BinaryTree(){
        root = null;
    }

    public BNode find(int age){
        if (root == null){
            return null;
        }
        BNode cur = root;
        while (age != cur.getAge()){
            if (age < cur.getAge()){
                cur = cur.getlChild();
            }else {
                cur = cur.getrChild();
            }
            if (cur == null){
                return null;
            }
        }
        return cur;
    }

    public void insert(BNode node){
        if (root == null){
            root = node;
        }else {
            BNode cur = root;
            while (true){
                if (node.getAge() < cur.getAge()){
                    if (cur.getlChild() == null){
                        cur.setlChild(node);
                        return;
                    }
                    cur = cur.getlChild();
                }else {
                    if (cur.getrChild() == null){
                        cur.setrChild(cur);
                        return;
                    }
                    cur = cur.getrChild();
                }
            }
        }
    }

    public boolean delete(BNode node){
        if (root == null){
            return false;//空树直接返回
        }

        boolean isLeftChild = true; // 记录目标节点是否父节点的左孩子
        BNode parent = null;
        BNode cur = root;
        while (node.getAge() != cur.getAge()){
            parent = cur;
            if (node.getAge() < cur.getAge()){
                cur = cur.getlChild();
                isLeftChild = true;
            }else {
                cur = cur.getrChild();
                isLeftChild = false;
            }
            if (cur == null){
                return true; // 没有要删除的
            }
        }

        // solution1: 没有子节点
        if (cur.getlChild() == null && cur.getrChild() == null){
            if (cur == root){
                root = null;
            }else if (isLeftChild){
                parent.setlChild(null);
            }else {
                parent.setrChild(null);
            }
            // solution2: 只有右节点
        }else if (cur.getlChild() == null){
            if (cur == root){
                root = cur;
            }else if (isLeftChild){
                parent.setlChild(cur.getrChild());
            }else {
                parent.setrChild(cur.getrChild());
            }
            // solution3：只有一个左节点
        }else if (cur.getrChild() == null){
            if (cur == root){
                root = cur;
            }else if (isLeftChild){
                parent.setlChild(cur.getrChild());
            }else {
                parent.setrChild(cur.getrChild());
            }
        }else {
            // solution4: 有两个节点
            // 找到右子树最小的节点，也就是直接后继
            BNode successor = cur.getrChild();
            BNode successorParent = null;
            while (successor.getlChild() != null){
                successorParent = successor;
                successor = successor.getlChild();
            }

            // 说明 1：cur的直接后继是其右节点 2：successor没有左节点
            if (successorParent == null){
                successor.setlChild(cur.getlChild());
                if (cur == root){
                    root = successor;
                }else if (isLeftChild){
                    parent.setlChild(successor);
                }else {
                    parent.setrChild(successor);
                }

            // 说明 successor没有左节点,并且successor一定是左节点
            }else {
                // 1 先将successor脱离出来
                successorParent.setlChild(successor.getrChild());
                // 2 successor代替cur
                successor.setlChild(cur.getlChild());
                successor.setrChild(cur.getrChild());

                // 3 设置success的新父节点
                if (cur == root){
                    root = successor;
                }else if (isLeftChild){
                    parent.setlChild(successor);
                }else {
                    parent.setrChild(successor);
                }
            }
        }
        return true;
    }

    // 前序遍历
    void preOrder(BNode node, List<BNode> list){}
    // 中序遍历
    void inOrder(BNode node,List<BNode> list){}
    // 后续遍历
    void postOrder(BNode node,List<BNode> list){}
    // 层次遍历
    void levelOrder(BNode node,List<BNode> list){}

    // 获取大小
    int getSize(BNode node){
        return 0;
    }
    // 获取高度
    int getHeight(BNode node){
        return 0;
    }
    // 获取深度
    int getDeep(BNode node){
        return 0;
    }
}
