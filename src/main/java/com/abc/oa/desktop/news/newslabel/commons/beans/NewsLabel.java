package com.abc.oa.desktop.news.newslabel.commons.beans;

import java.util.Set;

public class NewsLabel {
    private Integer id;
    private String label_name;
    private String label_content;
    //关联属性，将当前类看作一方（父栏目），则关联属性为多方（子栏目）
    private Set<NewsLabel> child;
    //所谓自关联查询，是指自己既然充当一方，又充当多方。比如新闻栏目的数据表，自己可以是父栏目，也可以是多方，子栏目。
    // 在数据表里面实现就是一张表，有一个外键pid，用来表示该栏目的父栏目，一级栏目没有父栏目的，可以将其外键设置为0.
    //关联属性，将当前类看作多方
    private NewsLabel parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLabel_content() {
        return label_content;
    }

    public void setLabel_content(String label_content) {
        this.label_content = label_content;
    }

    public Set<NewsLabel> getChild() {
        return child;
    }

    public void setChild(Set<NewsLabel> child) {
        this.child = child;
    }

    public NewsLabel getParent() {
        return parent;
    }

    public void setParent(NewsLabel parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "NewsLabel{" +
                "id=" + id +
                ", label_name='" + label_name + '\'' +
                ", label_content='" + label_content + '\'' +
                ", child=" + child +
                ", parent=" + parent +
                '}';
    }
}
