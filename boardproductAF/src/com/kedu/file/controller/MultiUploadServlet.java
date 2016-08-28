package com.kedu.file.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      String savePath = "upload";
      int uploadFileSizeLimit = 5 * 1024 * 1024;
      String encType = "UTF-8";
      
      ServletContext context = getServletContext();
      String uploadFilePath = context.getRealPath(savePath);
      
      try {
         MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
         Enumeration<?> files = multi.getFileNames();
         
         while (files.hasMoreElements()){
            String file = (String) files.nextElement();
            String file_name = multi.getFilesystemName(file);
            
            String ori_file_name = multi.getOriginalFileName(file);
            out.print("<br> 서버에 저장된 파일명 : " + file_name);
            out.print("<br> 클라이언트 원본 파일명 : " + ori_file_name);
            out.print("<hr>");
         }
         } catch (Exception e) {
            System.out.print("예외 발생 : " + e);
      }
   }

}


















