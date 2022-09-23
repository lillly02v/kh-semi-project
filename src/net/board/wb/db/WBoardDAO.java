package net.board.wb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.board.vb.db.VBoardVO;

public class WBoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private static WBoardDAO instance;
	
	public WBoardDAO(){
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
				sql.append("select count(*) from WR_BOARD ");
				pstmt=con.prepareStatement(sql.toString());
			}else if(opt.equals("0")) {
				sql.append("select count(*) from WR_BOARD where WBSUB like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("1")) {
				sql.append("select count(*) from WR_BOARD where WBCONT like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("2")) {
				sql.append("select count(*) from WR_BOARD where WBSUB like ? or WBCONT like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				pstmt.setString(2, '%'+condition+'%');
			}else if(opt.equals("3")) {
				sql.append("select count(*) from WR_BOARD where WNAME like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("4")) {
				sql.append("select count(*) from WR_BOARD where WBWEEK like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("5")) {
				sql.append("select count(*) from WR_BOARD where WBPOSTIME like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("6")) {
				sql.append("select count(*) from WR_BOARD where WBAREA like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("7")) {
				sql.append("select count(*) from WR_BOARD where WBRELIG like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("8")) {
				sql.append("select count(*) from WR_BOARD where WBGENV like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("9")) {
				sql.append("select count(*) from WR_BOARD where WBHOPE like ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
			}else if(opt.equals("10")) {
				sql.append("select count(*) from WR_BOARD where WID = ?");
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
	
	
	
	public List<WBoardVO> listSearch(WBoardVO board) {
		return null;
	}
	
	public boolean boardInsert(WBoardVO board) {
		int num=0;
		String sql="";
		int result=0;
		try {
			con=ds.getConnection();
			
			String max_sql="select max(wbnum) from WR_BOARD";
			pstmt=con.prepareStatement(max_sql);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				num=rs.getInt(1)+1;
			}else {
				num=1;
			}
			pstmt.close();
			rs.close();
			
			sql="insert into WR_BOARD"
					+" (wbnum, wid, wpass, wname, wbsub, wbcont, wbweek, wbpostime, wbarea,"
					+" wbrelig, wbgenv, wbhope, wbhopeve, wbdate, wbvisit, wbfile, wbreadcount)"
					+" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,sysdate, ?, ?, ?)";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getWid());
			pstmt.setString(3, board.getWpass());
			pstmt.setString(4, board.getWname());
			pstmt.setString(5, board.getWbsub());
			pstmt.setString(6, board.getWbcont());
			pstmt.setString(7, board.getWbweek());
			pstmt.setString(8, board.getWbpostime());
			pstmt.setString(9, board.getWbarea());
			pstmt.setString(10, board.getWbrelig());
			pstmt.setString(11, board.getWbgenv());
			pstmt.setString(12, board.getWbhope());
			pstmt.setString(13, board.getWbhopeve());
			pstmt.setInt(14, 0);
			pstmt.setString(15, board.getWbfile());
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
		String board_sql="select * from WR_BOARD where wbnum = ? ";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			if(pass.equals(rs.getString("wpass"))) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println("isBoardWrite() error:"+ex);
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
	
	public WBoardVO getDetail(int num) {
		WBoardVO board= null;
		try {
			con=ds.getConnection();
			String sql="select * from WR_BOARD where wbnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board= new WBoardVO();
				board.setWbnum(rs.getInt("wbnum"));
				board.setWid(rs.getString("wid"));
				board.setWpass(rs.getString("wpass"));
				board.setWname(rs.getString("wname"));
				board.setWbsub(rs.getString("wbsub"));
				board.setWbcont(rs.getString("wbcont"));
				board.setWbweek(rs.getString("wbweek"));
				board.setWbpostime(rs.getString("wbpostime"));
				board.setWbarea(rs.getString("wbarea"));
				board.setWbrelig(rs.getString("wbrelig"));
				board.setWbgenv(rs.getString("wbgenv"));
				board.setWbhope(rs.getString("wbhope"));
				board.setWbhopeve(rs.getString("wbhopeve"));
				board.setWbdate(rs.getDate("wbdate"));
				board.setWbvisit(rs.getInt("wbvisit"));
				board.setWbfile(rs.getString("wbfile"));
				board.setWbreadcount(rs.getInt("wbreadcount"));
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
	
	public boolean boardModify(WBoardVO board) {
		int num=0;
		try {
			con=ds.getConnection();
			
			String sql="update WR_BOARD "
					+"set wbsub = ?, wbcont = ?, wbweek = ?, wbpostime = ?, wbarea = ?, wbrelig = ?,"
					+ " wbgenv = ?, wbhope = ?, wbhopeve = ?  "
					+"where wbnum = ? and wid = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getWbsub());
			pstmt.setString(2, board.getWbcont());
			pstmt.setString(3, board.getWbweek());
			pstmt.setString(4, board.getWbpostime());
			pstmt.setString(5, board.getWbarea());
			pstmt.setString(6, board.getWbrelig());
			pstmt.setString(7, board.getWbgenv());
			pstmt.setString(8, board.getWbhope());
			pstmt.setString(9, board.getWbhopeve());
			
			
			pstmt.setInt(10, board.getWbnum());
			pstmt.setString(11, board.getWid());
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
			String sql= "delete from WR_BOARD "
					+"where wbnum = ? ";
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
			
			String sql="update WR_BOARD "
					+"set wbreadcount= wbreadcount + 1 "
					+"where wbnum= ? ";
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

	public static WBoardDAO getInstance() {
		if(instance==null)
            instance=new WBoardDAO();
        return instance;



	}

	public ArrayList<WBoardVO> getBoardList(HashMap<String, Object> listOpt) {
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        String id = (String)listOpt.get("id");
        int start = (Integer)listOpt.get("start"); 
        
				
		ArrayList<WBoardVO> list = new ArrayList<WBoardVO>();
		
		
		try {
			StringBuffer sql=new StringBuffer();
			con=ds.getConnection();
			
			
			if(opt==null) {
			sql.append("select * from ");
			sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
			sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
			sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
			sql.append("(select * from WR_BOARD ");
			sql.append("order by WBNUM desc)) ");
			sql.append("where rnum>=? and rnum<=? ");
		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, start+9);
			}
			else if(opt.equals("0")) {//제목
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBSUB like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("1")) {//내용
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBCONT like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("2")) {//제목+내용
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBSUB like ? OR WBCONT like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
			}else if(opt.equals("3")) {//글쓴이
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WNAME like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("4")) {//근무요일
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBWEEK like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("5")) {//근무시간
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBPOSTIME like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("6")) {//지역
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBAREA like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("7")) {//종교
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBRELIG like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("8")) {//성별
				sql.append("select * from ");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBGENV like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("9")) {
				sql.append("select * from");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WBHOPE like ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}else if(opt.equals("10")) {
				sql.append("select * from");
				sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
				sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
				sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
				sql.append("(select * from WR_BOARD where WID = ? ");
				sql.append("order by WBNUM desc)) ");
				sql.append("where rnum>=? and rnum<=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				WBoardVO board=new WBoardVO();
				board.setWbnum(rs.getInt("wbnum"));
				board.setWid(rs.getString("wid"));
				board.setWname(rs.getString("wname"));
				board.setWbsub(rs.getString("wbsub"));
				board.setWbcont(rs.getString("wbcont"));
				board.setWbweek(rs.getString("wbweek"));
				board.setWbpostime(rs.getString("wbpostime"));
				board.setWbarea(rs.getString("wbarea"));
				board.setWbrelig(rs.getString("wbrelig"));
				board.setWbgenv(rs.getString("wbgenv"));
				board.setWbhope(rs.getString("wbhope"));
				board.setWbhopeve(rs.getString("wbhopeve"));
				board.setWbdate(rs.getDate("wbdate"));
				board.setWbvisit(rs.getInt("wbvisit"));
				board.setWbfile(rs.getString("wbfile"));
				board.setWbreadcount(rs.getInt("wbreadcount"));
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
	
	public List<WBoardVO> profileList(String userId){
		List<WBoardVO> list = new ArrayList<WBoardVO>();
		try {
			StringBuffer sql=new StringBuffer();
			con = ds.getConnection();
			sql.append("select * from");
			sql.append("(select rownum rnum, WBNUM, WID, WNAME, WBSUB, WBCONT, ");
			sql.append("WBWEEK, WBPOSTIME, WBAREA, WBRELIG, WBGENV, WBHOPE, ");
			sql.append("WBHOPEVE, WBDATE, WBVISIT, WBFILE, WBREADCOUNT from ");
			sql.append("(select * from WR_BOARD order by WBNUM desc)) ");
			sql.append("where wid = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WBoardVO board=new WBoardVO();
				board.setWbnum(rs.getInt("wbnum"));
				board.setWid(rs.getString("wid"));
				board.setWname(rs.getString("wname"));
				board.setWbsub(rs.getString("wbsub"));
				board.setWbcont(rs.getString("wbcont"));
				board.setWbweek(rs.getString("wbweek"));
				board.setWbpostime(rs.getString("wbpostime"));
				board.setWbarea(rs.getString("wbarea"));
				board.setWbrelig(rs.getString("wbrelig"));
				board.setWbgenv(rs.getString("wbgenv"));
				board.setWbhope(rs.getString("wbhope"));
				board.setWbhopeve(rs.getString("wbhopeve"));
				board.setWbdate(rs.getDate("wbdate"));
				board.setWbvisit(rs.getInt("wbvisit"));
				board.setWbfile(rs.getString("wbfile"));
				board.setWbreadcount(rs.getInt("wbreadcount"));
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
