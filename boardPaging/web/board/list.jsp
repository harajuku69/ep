<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.kedu.common.db.DBManager" %>
<%-- <jsp:useBean id="dbmgr" scope="application" class="com.kedu.common.db.DBManager" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body style="font-size: 13px;">
<h1>목록</h1>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = null;
//1.총레코드 수를 구한다.
int totalRecord = 0;
try {
	conn = DBManager.getConnection();
	sql = "SELECT count(*) FROM brdex";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	rs.next();
	totalRecord = rs.getInt(1);
} catch (SQLException e) {
} finally {
	DBManager.close(conn, pstmt, rs);
}
//2.페이지당 보일 레코드 수를 결정하고 총 페이지 수를 구한다.
int numPerPage = 10; //한 페이지에서 보일 레코드 수
int totalPage = 0; //총 페이지수
if (totalRecord != 0) {
	if (totalRecord % numPerPage == 0) {
		totalPage = totalRecord / numPerPage;
	} else {
		totalPage = totalRecord / numPerPage + 1;
	}
}
//3.첫번째 레코드 번호와 마지막 레코드 번호를 구한다.
int curPage = request.getParameter("curPage") == null ? 1 : Integer.parseInt(request.getParameter("curPage"));
//시작 레코드 계산
int start = (curPage - 1) * numPerPage + 1;
//마지막 레코드 계산
int end = start + numPerPage - 1;
//해당 페이지의 레코드 셋을 구한 후 출력한다.
	try {
		conn = DBManager.getConnection();
		sql="SELECT no,title,wdate FROM (" +
		         "SELECT ROWNUM R, A.* FROM (" + 
		          "SELECT no, title, wdate FROM brdex ORDER BY no DESC) A) " +
		         "WHERE R BETWEEN ? AND ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
	%>
		<table>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
	<%
		while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				Date wdate = rs.getDate("wdate");
	%>
		<tr>
			<td><%=no %></td> 
			<td><a href="view.jsp?no=<%=no %>"><%=title %></a></td> 
			<td><%=wdate.toString() %></td>
		</tr>
	<%
	 	}
	%>
		</table>
	<%
	} catch(SQLException e) {
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
//4.각 페이지에 대한 직접 이동 링크를 만든다.
for (int i = 1; i <= totalPage; i++) {
%>
	<a href="list.jsp?curPage=<%=i %>">[<%=i %>]</a>
<%
}
%>
<p>
<a href="write_form.jsp?curPage=<%=curPage %>">글쓰기</a>
</p>
</body>
</html>
