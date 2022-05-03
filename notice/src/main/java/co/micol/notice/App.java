package co.micol.notice;

import java.util.ArrayList;
import java.util.List;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.servicelmpl.NoticeServiclmpl;


public class App 
{
    public static void main( String[] args )
    {
    	Menu menu = new Menu();
    	menu.run();
//       NoticeService notice = new NoticeServiclmpl();
//       List<NoticeVO> list = new ArrayList<>();
//       list = notice.noticeSelectList();
//       
//       for(NoticeVO vo : list) {
//    	   vo.toString();
//       }
    }
}
