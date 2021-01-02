package com.abc.oa.desktop.news.newslabel.service;

import com.abc.oa.desktop.news.newslabel.dao.INewsLabelDao;
import com.abc.oa.desktop.news.newslabel.commons.beans.NewsLabel;
import com.abc.oa.desktop.news.newslabel.commons.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLabelServiceImpl implements INewsLablelService{
    @Autowired
    private INewsLabelDao dao;
    @Override
    public Page<NewsLabel> findCurrentPage(int pageno) {
        Page<NewsLabel> page =new Page<>();
        page.setPageno(pageno);
        int totaLRow =dao.selectAllCount();
        page.setTotalRows(totaLRow);
        List<NewsLabel> datas=dao.selectCurrentPageNeNewLabels(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public void deleteCurrentRecord(int id) {  //删除当前记录
        dao.deleteCurrent(id);
    }

    @Override
    public Page<NewsLabel> selectCurrentRecord(int id) {
        List<NewsLabel> datas=dao.selectCurrent(id);
        Page<NewsLabel> page =new Page<>();
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<NewsLabel> selectCurrentRecordId() {
        List<NewsLabel> datas=dao.selectCurrentId();
        Page<NewsLabel> page2 =new Page<>();
        page2.setDatas(datas);
        return page2;
    }

    @Override
    public void updateCurrentRecord(NewsLabel newsLabel) {
        dao.updateCurrent(newsLabel);
    }

    @Override
    public void insertCurrentRecord(NewsLabel newsLabel) {
        dao.insertCurrent(newsLabel);
    }

    @Override
    public Page<NewsLabel> pidSelectCurrentRecord(int pid) {
        List<NewsLabel> datas=dao.pidSelectCurrentRecord(pid);
        Page<NewsLabel> page =new Page<>();
        page.setDatas(datas);
        return page;
    }

}
