package com.suntr.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suntrian on 17-5-31.
 */
public class BaseTreeNode <T extends Serializable> implements Serializable{
    private T id;
    private BaseTreeNode parent;
    private List<BaseTreeNode> childs;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public BaseTreeNode getParent() {
        return parent;
    }

    public void setParent(BaseTreeNode parent) {
        this.parent = parent;
    }

    public List<BaseTreeNode> getChilds() {
        return childs;
    }

    public void setChilds(List<BaseTreeNode> childs) {
        this.childs = childs;
    }
}
