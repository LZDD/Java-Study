package com.lzdd.adal.structure.tree;

import java.util.List;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/18 4:53 下午
 **/
public interface IPFSTree {
    // 前序遍历
    void preOrder(PFSTreeNode node,List<PFSTreeNode> list);
    // 中序遍历
    void inOrder(PFSTreeNode node,List<PFSTreeNode> list);
    // 后续遍历
    void postOrder(PFSTreeNode node,List<PFSTreeNode> list);
    // 层次遍历
    void levelOrder(PFSTreeNode node,List<PFSTreeNode> list);

    // 获取大小
    int getSize(PFSTreeNode node);
    // 获取高度
    int getHeight(PFSTreeNode node);
    // 获取深度
    int getDeep(PFSTreeNode node);
}
