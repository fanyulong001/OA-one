package com.abc.oa.desktop.news.newslabel.dao;

import com.abc.oa.desktop.news.newslabel.commons.beans.NewsLabel;
import com.abc.oa.desktop.news.newslabel.commons.vo.Page;

import java.util.List;

public interface INewsLabelDao {
    int selectAllCount();   //

    List<NewsLabel> selectCurrentPageNeNewLabels(Page<NewsLabel> page); //选择当前页面新闻标签

    void deleteCurrent(int id); //删除

    List<NewsLabel> selectCurrent(int id);

    List<NewsLabel> selectCurrentId();

    void updateCurrent(NewsLabel newsLabel);  //更新

    void insertCurrent(NewsLabel newsLabel);  //插入

    List<NewsLabel> pidSelectCurrentRecord(int pid);
}
