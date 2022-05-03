package co.micol.notice.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;

import co.micol.notice.servicelmpl.NoticeServiclmpl;

public interface Notice {
   private NoticeServiclmpl dao = new NoticeServiclmpl();
   private Scanner nsc = new Scanner(System.in);
   public static void noticeList() {
      List<NoticeVO> list = new ArrayList<NoticeVO>;
      list = dao.noticeSelectList();
      System.out.println("*****게시글목록*****");
      System.out.println("순번 작성자 제목 작성일자 조회수");
      System.out.println("******************");
      for(NoticeVO vo : list) {
         vo.toString();
         }
   }
   public static void noticeSelect() {
      NoticeVO vo = new NoticeVO();
      System.out.println("==읽을 공지사항 번호 입력==");
      int id = nsc.nextInt();
      vo.setId(id);
      vo.toString();
      System.out.println("글내용 : " + vo.getSubject());
      System.out.println("==========================");
      
   }
   public static void noticeInsert() {
      NoticeVO vo = new NoticeVO();
      System.out.println("작성자를 입력하세요 ");
      vo.setWriter(nsc.nextLine());
      System.out.println("제목을 입력하세요 ");
      vo.setTitle(nsc.nextLine());
      System.out.println("내용을 입력하세요 ");
      vo.setSubject(nsc.nextLine());
      
      int n = dao.noticeInsert(vo);
      if(n !=0) {
         System.out.println("정상적으로 글이 등록 되었습니다.");
      }else {
         System.out.println("글이 등록되지 않았습니다.");
      }
   }
}
