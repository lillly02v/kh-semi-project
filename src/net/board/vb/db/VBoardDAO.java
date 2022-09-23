package net.board.vb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VBoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private static VBoardDAO instance;
	
	public VBoardDAO(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패: " + ex);
			return;
		}
	}
	
	public int getListCount(HashMap<String, Object> listOpt) {
		int result=0;
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition");
        String id = (String)listOpt.get("id");
		try {
			con=ds.getConnection();
			StringBuffer sql=new StringBuffer();
			if(opt==null) {
				sql.append("select count(*) from VT_BOARD ");
				pstmt=con.prepareStatement(sql.toString());
			}else if(opt.equals("0")) {
				sql.append("select count(*) from VT_BOARD where VBSUB like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("1")) {
				sql.append("select count(*) from VT_BOARD where VBCONT like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("2")) {
				sql.append("select count(*) from VT_BOARD where VBSUB like ? or VBCONT like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				pstmt.setString(2, '%'+condition+'%');
			}else if(opt.equals("3")) {
				sql.append("select count(*) from VT_BOARD where VNAME like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("4")) {
				sql.append("select count(*) from VT_BOARD where VBWEEK like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("5")) {
				sql.append("select count(*) from VT_BOARD where VBPOSTIME like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("6")) {
				sql.append("select count(*) from VT_BOARD where VBAREA like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("7")) {
				sql.append("select count(*) from VT_BOARD where VBRELIG like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("8")) {
				sql.append("select count(*) from VT_BOARD where VID = ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
			}
			
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(Exception ex) {
			System.out.println("getListCount() error:"+ex); 
		}finally {
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	public List<VBoardVO> listSearch(VBoardVO board) {
		return null;
	}
	
	public boolean boardInsert(VBoardVO board) {
		int num=0;
		String sql="";
		int result=0;
		try {
			con=ds.getConnection();
			
			String max_sql="select max(vbnum) from VT_BOARD";
			pstmt=con.prepareStatement(max_sql);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				num=rs.getInt(1)+1;
			}else {
				num=1;
			}
			pstmt.close();
			rs.close();
			
			sql="insert into VT_BOARD"
					+" (vbnum, vid, vpass, vname, vbsub, vbcont, vbweek, vbpostime, vbarea,"
					+" vbrelig, VBCHRAC, vbexper, vbexcont, vbdate, vbvisit, vbcerti, vbreadcount)"
					+" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,sysdate, ?, ?, ?)";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getVid());
			pstmt.setString(3, board.getVpass());
			pstmt.setString(4, board.getVname());
			pstmt.setString(5, board.getVbsub());
			pstmt.setString(6, board.getVbcont());
			pstmt.setString(7, board.getVbweek());
			pstmt.setString(8, board.getVbpostime());
			pstmt.setString(9, board.getVbarea());
			pstmt.setString(10, board.getVbrelig());
			pstmt.setString(11, board.getVbchrac());
			pstmt.setString(12, board.getVbexper());
			pstmt.setString(13, board.getVbexcont());
			pstmt.setInt(14, 0);
			pstmt.setString(15, board.getVbcerti());
			pstmt.setInt(16, 0);
		
			result=pstmt.executeUpdate();
			
			if(result==0) {
				return false;
			}
			return true;
		}catch(Exception e) {
			System.out.println("boardInsert() error:" +e);
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean isBoardWriter(int num, String pass) {
		String board_sql="select * from VT_BOARD where vbnum = ? ";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			if(pass.equals(rs.getString("vpass"))) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println("isBoardVTite() error:"+ex);
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public VBoardVO getDetail(int num) {
		VBoardVO board= null;
		try {
			con=ds.getConnection();
			String sql="select * from VT_BOARD where vbnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board= new VBoardVO();
				board.setVbnum(rs.getInt("VBNUM"));
				board.setVid(rs.getString("VID"));
				board.setVpass(rs.getString("VPASS"));
				board.setVname(rs.getString("VNAME"));
				board.setVbsub(rs.getString("VBSUB"));
				board.setVbcont(rs.getString("VBCONT"));
				board.setVbweek(rs.getString("VBWEEK"));
				board.setVbpostime(rs.getString("VBPOSTIME"));
				board.setVbarea(rs.getString("VBAREA"));
				board.setVbrelig(rs.getString("VBRELIG"));
				board.setVbchrac(rs.getString("VBCHRAC"));
				board.setVbexper(rs.getString("VBEXPER"));
				board.setVbexcont(rs.getString("VBEXCONT"));
				board.setVbdate(rs.getDate("VBDATE"));
				board.setVbvisit(rs.getInt("VBVISIT"));
				board.setVbcerti(rs.getString("VBCERTI"));
				board.setVbreadcount(rs.getInt("VBREADCOUNT"));
			}
			return board;
		}catch(Exception ex) {
			System.out.println("getDetail() error:"+ex);
		}finally {
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public boolean boardModify(VBoardVO board) {
		int num=0;
		try {
			con=ds.getConnection();
			
			String sql="update VT_BOARD "
					+"set vbsub = ?, vbcont = ?, vbweek = ?, vbpostime = ?, vbarea = ?, vbrelig = ?,"
					+ " vbchrac = ?, vbexper = ?, vbexcont = ? "
					+"where vbnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getVbsub());
			pstmt.setString(2, board.getVbcont());
			pstmt.setString(3, board.getVbweek());
			pstmt.setString(4, board.getVbpostime());
			pstmt.setString(5, board.getVbchrac());
			pstmt.setString(6, board.getVbarea());
			pstmt.setString(7, board.getVbrelig());
			pstmt.setString(8, board.getVbexper());
			pstmt.setString(9, board.getVbexcont());
			pstmt.setInt(10, board.getVbnum());
			
			num=pstmt.executeUpdate();
			if(num!=0) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println("boardModify() error:"+ex);
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean boardDelete(int num) {
		int result=0;
		try {
			con=ds.getConnection();
			String sql= "delete from VT_BOARD "
					+"where vbnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			if(result !=0) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println("boardDelete() error : " +ex);
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public void setReadCountUpdate(int num) {
		try {
			con=ds.getConnection();
			
			String sql="update VT_BOARD "
					+"set vbreadcount= vbreadcount + 1 "
					+"where vbnum= ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("setReadCountUpdate() error: "+ex);
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static VBoardDAO getInstance() {
		if(instance==null)
            instance=new VBoardDAO();
        return instance;



	}

	public ArrayList<VBoardVO> getBoardList(HashMap<String, Object> listOpt) {
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        String id = (String)listOpt.get("id");
        int start = (Integer)listOpt.get("start"); 
		
		ArrayList<VBoardVO> list = new ArrayList<VBoardVO>();
		
		try {
			StringBuffer sql=new StringBuffer();
			con=ds.getConnection();
			
			if(opt==null) {
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum >= ? and rnum <= ? ");
		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, start+9);
			}
			else if(opt.equals("0")) {//제목
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBSUB like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("1")) {//내용
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBCONT like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("2")) {//제목+내용
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBSUB like ? OR VBCONT like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
			}else if(opt.equals("3")) {//글쓴이
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VNAME like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("4")) {//근무요일
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBWEEK like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("5")) {//근무시간
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBPOSTIME like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("6")) {//지역
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBAREA like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("7")) {//종교
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VBRELIG like ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("8")) {//종교
				sql.append("select * from ");
				sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
				sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
				sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
				sql.append("(select * from VT_BOARD where VID = ? ");
				sql.append("order by VBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				VBoardVO board=new VBoardVO();
				board.setVbnum(rs.getInt("VBNUM"));
				board.setVid(rs.getString("VID"));
				board.setVname(rs.getString("VNAME"));
				board.setVbsub(rs.getString("VBSUB"));
				board.setVbcont(rs.getString("VBCONT"));
				board.setVbweek(rs.getString("VBWEEK"));
				board.setVbpostime(rs.getString("VBPOSTIME"));
				board.setVbarea(rs.getString("VBAREA"));
				board.setVbrelig(rs.getString("VBRELIG"));
				board.setVbchrac(rs.getString("VBCHRAC"));
				board.setVbexper(rs.getString("VBEXPER"));
				board.setVbexcont(rs.getString("VBEXCONT"));
				board.setVbdate(rs.getDate("VBDATE"));
				board.setVbvisit(rs.getInt("VBVISIT"));
				board.setVbcerti(rs.getString("VBCERTI"));
				board.setVbreadcount(rs.getInt("VBREADCOUNT"));
				list.add(board);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("getBoardList() error : "+ex);
		}finally {
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public List<VBoardVO> profileList(String userId){
		List<VBoardVO> list = new ArrayList<VBoardVO>();
		try {
			StringBuffer sql=new StringBuffer();
			con = ds.getConnection();
			sql.append("select * from ");
			sql.append("(select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, ");
			sql.append("VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, ");
			sql.append("VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from ");
			sql.append("(select * from VT_BOARD order by VBNUM desc)) ");
			sql.append("where vid = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VBoardVO board=new VBoardVO();
				board.setVbnum(rs.getInt("VBNUM"));
				board.setVid(rs.getString("VID"));
				board.setVname(rs.getString("VNAME"));
				board.setVbsub(rs.getString("VBSUB"));
				board.setVbcont(rs.getString("VBCONT"));
				board.setVbweek(rs.getString("VBWEEK"));
				board.setVbpostime(rs.getString("VBPOSTIME"));
				board.setVbarea(rs.getString("VBAREA"));
				board.setVbrelig(rs.getString("VBRELIG"));
				board.setVbchrac(rs.getString("VBCHRAC"));
				board.setVbexper(rs.getString("VBEXPER"));
				board.setVbexcont(rs.getString("VBEXCONT"));
				board.setVbdate(rs.getDate("VBDATE"));
				board.setVbvisit(rs.getInt("VBVISIT"));
				board.setVbcerti(rs.getString("VBCERTI"));
				board.setVbreadcount(rs.getInt("VBREADCOUNT"));
				list.add(board);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("getBoardList() error : "+ex);
		}finally {
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


}
