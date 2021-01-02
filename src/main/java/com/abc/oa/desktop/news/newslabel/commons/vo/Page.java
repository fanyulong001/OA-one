package com.abc.oa.desktop.news.newslabel.commons.vo;

import java.util.ArrayList;
import java.util.List;
//Page类放到vo中的原因：page类是个值对象，不是封装数据库里的数据，负责再Java代码中把Java代码中的数据传递到jsp页面上

//Page是VO（value object）对象，完成java类与jsp页面的数据传递

//Page对象用来封装每一页查询到的数据，再通过转发在页面上显示

//它和实体类不一样，实体类是用来封装数据库里查询到的数据

public class Page<T> {      //分页，加泛型原因：为了保证page对象的通融性，即提高通用性
    private int pageno;     //当前页的页码
    private int pageStartIndex;     //当前页的起始索引
    private int pageSize;       //每一页显示的记录数
    private int totalRows;      //查询总的记录数
    private int totalPages;     //总页码
    private List<T> datas;      //当前页所包含的具体数据

    public Page() {
        this.pageSize=3;
        this.pageno=1;
        datas =new ArrayList<>();
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPageStartIndex() {//定义每一页索引的开始
        //第一页起始索引为0，定义每页显示的数据为pageSize行，则下一页的索引开始为(pageno-1)*pageSize
        return (pageno-1)*pageSize;
    }

    public void setPageStartIndex(int pageStartIndex) {
        this.pageStartIndex = pageStartIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() { //总页码数
        if(totalRows%pageSize==0){
            totalPages=totalRows/pageSize;
        }else{
            totalPages=totalRows/pageSize+1;  //当前页码不能是整页时，多加一页显示
        }
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageno=" + pageno +
                ", pageStartIndex=" + pageStartIndex +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", datas=" + datas +
                '}';
    }
}
