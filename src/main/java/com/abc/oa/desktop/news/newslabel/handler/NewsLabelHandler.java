package com.abc.oa.desktop.news.newslabel.handler;

import com.abc.oa.desktop.news.newslabel.commons.beans.NewsLabel;
import com.abc.oa.desktop.news.newslabel.commons.vo.Page;
import com.abc.oa.desktop.news.newslabel.service.INewsLablelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//在Spring MVC 中使用 @RequestMapping 来映射请求，也就是通过它来指定控制器可以处理哪些URL请求，相当于Servlet中在web.xml中配置
@RequestMapping("/desktop/news")

public class NewsLabelHandler {
    @Autowired
    private INewsLablelService service;
    @RequestMapping("/queryNewLable.do")

    //提供默认参数值为1
    //@RequestParam用来映射参数，方便后端收集前端传来的参数。当方法参数的类型为基本类型（包括它们的封装类型）和String类型时,
    // @RequestParam可省略不写，SpringMVC可以自己完成映射。
    public String queryNewsLabel(@RequestParam(defaultValue = "1") int pageno , Model model){
        Page<NewsLabel> page=service.findCurrentPage(pageno);
        Page<NewsLabel> page2=service.selectCurrentRecordId();
        for(NewsLabel nl:page.getDatas()){
            System.out.println(nl);
        }
        model.addAttribute("page",page);
        model.addAttribute("page2",page2);
        return "/html/news/栏目管理.jsp";
    }
    @RequestMapping("/deleteNewsLabel.do")
    public String deleteNewsLabel(int id){
        service.deleteCurrentRecord(id);
        return "/desktop/news/queryNewLable.do";
    }
    @RequestMapping("/selectNewsLabelId.do")
    public String selectNewsLabelId(int id,Model model){
        Page<NewsLabel> page=service.selectCurrentRecord(id);
        Page<NewsLabel> page2=service.selectCurrentRecordId();
        for(NewsLabel nl:page.getDatas()){
            System.out.println(nl);
        }
        for(NewsLabel nl2:page2.getDatas()){
            System.out.println(nl2);
        }
        model.addAttribute("page",page);
        model.addAttribute("page2",page2);
        return "/html/news/栏目修改.jsp";
    }
    @RequestMapping("/updateNewsLabelId.do")
    public String updateNewsLabelId(NewsLabel newsLabel){
        System.out.println(newsLabel);
        System.out.println("1----");
        service.updateCurrentRecord(newsLabel);
        return "/html/news/close.jsp";
    }
    @RequestMapping("/selectNewsLabelPid.do")
    public String selectNewsLabelPid(Model model){
        Page<NewsLabel> page2=service.selectCurrentRecordId();
        model.addAttribute("page2",page2);
        return "/html/news/栏目添加.jsp";
    }
    @RequestMapping("/insertNewsLabel.do")
    public String insertNewsLabel(NewsLabel newsLabel){
        service.insertCurrentRecord(newsLabel);
        return "/html/news/close.jsp";
    }
    @RequestMapping("/pidSelectNewsLabel.do")
    public String pidSelectNewsLabel(int pid,Model model){
        Page<NewsLabel> page=service.pidSelectCurrentRecord(pid);
        model.addAttribute("page",page);
        return "/html/news/pid_Select.jsp";
    }
}
