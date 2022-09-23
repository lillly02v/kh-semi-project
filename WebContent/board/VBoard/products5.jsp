<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="org.json.simple.*" %>

<%
	request.setCharacterEncoding("utf-8");

	int wwbnum=Integer.parseInt(request.getParameter("vvbnum"));
	
	String usid = request.getParameter("usid");
	String wrcont = request.getParameter("vrcont");
	String wrsecret = request.getParameter("vrsecret");
	int num = 0;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		if(usid != null && !usid.isEmpty()){
			String nextSql = "select max(vrnum) from VT_REPLY";
			pstmt = conn.prepareStatement(nextSql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			}
			rs.close();
			pstmt.close();
			
			String sql = "insert into VT_REPLY values(VT_REPLY_SEQ.nextval , ? , ? , ? , sysdate , ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wwbnum);
			pstmt.setString(2, usid);
			pstmt.setString(3, wrcont);
			
			pstmt.setString(4, wrsecret);
			
			pstmt.executeUpdate();
			pstmt.close();
		}
		
		String sql = "";
		System.out.println(num);
		if(usid == null || usid.equals("")){	//처음으로 페이지가 로딩되었을때
			sql = "select * from VT_REPLY order by vrnum where vvbnum = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wwbnum);
		} else {	//추가 버튼을 클릭한 경우
			sql = "select * from VT_REPLY where vrnum = ? and vvbnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, wwbnum);
		}
		
		rs = pstmt.executeQuery();
		
		//JSON 형태로 데이터를 만듭니다.
		JSONArray array = new JSONArray();
		while(rs.next()){
			JSONObject object = new JSONObject();
			object.put("vrnum", rs.getInt(1));
			object.put("vvbnum", rs.getInt(2));
			object.put("usid", rs.getString(3));
			object.put("vrcont", rs.getString(4));
			object.put("vrdate", rs.getString(5));
			object.put("vrsecret", rs.getString(6));
			array.add(object);
		}
		//page가 안바뀐상태에서 한번 요청하면 갱신이 안되고 캐쉬에 남아있는
		//데이터를 계속 쓰게 됩니다.
		
		response.setHeader("cache-control", "no-cache, no-store");
		System.out.println(array);
		out.println(array);
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
%>