package com.abc.oa.desktop.news.newslabel.service;

import com.abc.oa.desktop.news.newslabel.commons.beans.NewsLabel;
import com.abc.oa.desktop.news.newslabel.commons.vo.Page;

public interface INewsLablelService {
    Page<NewsLabel> findCurrentPage(int pageno);

    void deleteCurrentRecord(int id);

    Page<NewsLabel> selectCurrentRecord(int id);

    Page<NewsLabel> selectCurrentRecordId();

    void updateCurrentRecord(NewsLabel newsLabel);

    void insertCurrentRecord(NewsLabel newsLabel);

    Page<NewsLabel> pidSelectCurrentRecord(int pid);
}
