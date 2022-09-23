package net.board.notice.db;


import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.naming.Context;

import javax.naming.InitialContext;

import javax.sql.DataSource;



public class NTBoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public NTBoardDAO(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패: " + ex);
			return;
		}
	}
	
	public int getListCount() {
		int result=0;
		try {
			con=ds.getConnection();
			
			String sql="select count(*) from NT_BOARD";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch(Exception ex) {
			System.out.println("getListCount() error :" + ex);
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
		return result;
	}
	
	public List<NTBoardVO> getBoardList(int page, int limit){
		String ntboard_list_sql=
				"select * from "
				+"(select rownum rnum, NTNUM, AID,  ANAME, "
				+"NTSUB, NTCONT, NTFILES, "
				+"NTDATE, NTVISIT "
				+ "from NT_BOARD order by ntnum desc) "
				+"where rnum>=?  and rnum<=?"
				+"order by ntnum desc";
		
		List<NTBoardVO> list= new ArrayList<NTBoardVO>();
		int startrow =(page-1)*limit+1;
		int endrow = startrow +limit-1;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(ntboard_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				NTBoardVO board = new NTBoardVO();
				board.setNtnum(rs.getInt("NTNUM"));
				board.setAid(rs.getString("AID"));
				board.setAname(rs.getString("ANAME"));
				board.setNtsub(rs.getString("NTSUB"));
				board.setNtcont(rs.getString("NTCONT"));
				board.setNtfiles(rs.getString("NTFILES"));
				board.setNtdate(rs.getDate("NTDATE"));
				board.setNtvisit(rs.getInt("NTVISIT"));
				list.add(board);
			}
			return list;
		} catch(Exception ex) {
			System.out.println("getListCount() error :" + ex);
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
		return null;
	}
	
	
	
	public boolean boardInsert(NTBoardVO board) {
		int num = 0;
		String sql = "";
		int result = 0;
		try {
			con = ds.getConnection();
			String max_sql = "select max(NTNUM) from NT_BOARD";
			pstmt = con.prepareStatement(max_sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}
			
			pstmt.close();
			rs.close();
			
			sql = "insert into NT_BOARD"
					+"(NTNUM, AID, ANAME, NTSUB, NTCONT, NTFILES, NTDATE, NTVISIT)"
					+"values(?,?,?,?,?,?,sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2,board.getAid());
			pstmt.setString(3, board.getAname());
			pstmt.setString(4, board.getNtsub());
			pstmt.setString(5, board.getNtcont());
			pstmt.setString(6, board.getNtfiles());
			pstmt.setInt(7, board.getNtvisit());
			
			result=pstmt.executeUpdate();
			if(result==0) {
				return false;
			}
			return true;
		}catch(Exception ex){
			System.out.println("boardInsert() error : " + ex);
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
		return false;
	}
	
	public void setReadCountUpdate(int num) {
		String sql= "update NT_BOARD "
				+"set NTVISIT=NTVISIT+1 "
				+"where NTNUM=? ";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("setReadCountUpdate() error : " + ex);
		} finally {
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
	
	
	public NTBoardVO getDetail(int num) {
		NTBoardVO board=null;
		try {
			con=ds.getConnection();
			
			String sql="select * from NT_BOARD where NTNUM=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, num);
			System.out.println(num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board = new NTBoardVO();
				board.setNtnum(num);
				board.setAid(rs.getString("AID"));
				board.setAname(rs.getString("ANAME"));
				board.setNtsub(rs.getString("Ntsub"));
				board.setNtcont(rs.getString("Ntcont"));
				board.setNtfiles(rs.getString("Ntfiles"));
				board.setNtdate(rs.getDate("Ntdate"));
				board.setNtvisit(rs.getInt("Ntvisit"));
			}
			return board;
		} catch(Exception ex) {
			System.out.println("getDetail() error : " + ex);
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
		return null;
	}
	
	public boolean boardModify(NTBoardVO board) {
		int num=0;
		try {
			con=ds.getConnection();
			
			String sql="update NT_BOARD "
					+"set NTSUB=?, NTCONT=?, NTFILES=? "
					+"where NTNUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getNtsub());
			pstmt.setString(2, board.getNtcont());
			pstmt.setString(3, board.getNtfiles());
			pstmt.setInt(4,board.getNtnum());
			num=pstmt.executeUpdate();
			if(num !=0) {
				return true;
			}
		} catch(Exception ex) {
			System.out.println("boardModify() error : " + ex);
		} finally {
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
		int result =0;
		try {
			con=ds.getConnection();
			String sql="delete from NT_BOARD "
					+"where NTNUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			if(result !=0) {
				return true;
			}
		}catch(Exception ex) {
			System.out.println("boardModify() error : " + ex);
		}finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public List<NTBoardVO> getBoardList(HashMap<String, Object> listOpt,
			int page, int limit, String search, String searchotp)
    {
        List<NTBoardVO> list = new ArrayList<NTBoardVO>();
        
        String opt = (String)listOpt.get("opt"); //검색옵션
        System.out.println("opt=" + opt);
        
        String condition = (String)listOpt.get("condition"); //인풋 검색내용
        System.out.println("condition=" + condition);
        
        int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호 (1,11,21,31,...)
        int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10,20,30,40,...)
        
        try {
        	con = ds.getConnection();
            
        	// 글목록 전체를 보여줄 때
            if(opt == null) {
            	String board_list_sql =
        				"select * from "
        				+ "(select rownum rnum,  NTNUM, AID, ANAME, "
        				+ "NTSUB, NTCONT, NTFILES, NTDATE, NTVISIT "
        				+ "from (select * from nt_board "
        				+ "order by ntnum desc)) "
        				+ "where rnum>=? and rnum<=? "
        				+ "order by NTNUM desc";
        				
                pstmt = con.prepareStatement(board_list_sql);
                pstmt.setInt(1, startrow);
                pstmt.setInt(2, endrow);
                System.out.println("null일때");
                
            } else if(opt.equals("0")){ // 제목으로 검색

            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, NTNUM, AID, ANAME, "
            			+ "NTSUB, NTCONT, NTFILES, NTDATE, NTVISIT "
            			+ "from (select * from NT_BOARD "
            			+ "where NTSUB like ? "
            			+ "order by NTNUM asc)) "
            			+ "where rnum>=? and rnum<=?"
            			+ "order by NTNUM desc";
                
                pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setInt(2, startrow);
                pstmt.setInt(3, endrow);
                System.out.println("제목검색");
            } else if(opt.equals("1")) { // 내용으로 검색
            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, NTNUM, AID, ANAME, "
            			+ "NTSUB, NTCONT, NTFILES, NTDATE, NTVISIT "
            			+ "from (select * from NT_BOARD "
            			+ "where NTCONT like ? "
            			+ "order by NTNUM asc)) "
            			+ "where rnum>=? and rnum<=?"
            			+ "order by NTNUM desc";
            
            	pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setInt(2, startrow);
                pstmt.setInt(3, endrow);
                System.out.println("내용검색");
                
            } else if(opt.equals("2")) { // 작성일로 검색
            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, NTNUM, AID, ANAME, "
            			+ "NTSUB, NTCONT, NTFILES, NTDATE, NTVISIT "
            			+ "from (select * from NT_BOARD "
            			+ "where NTDATE like ? "
            			+ "order by NTNUM asc)) "
            			+ "where rnum>=? and rnum<=? "
            			+ "order by NTNUM desc"; 
                
            	pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setInt(2, startrow);
                pstmt.setInt(3, endrow);
                System.out.println("날짜 검색");
            }
            
            rs = pstmt.executeQuery();
            while(rs.next()) {
				NTBoardVO board = new NTBoardVO();
				board.setNtnum(rs.getInt("NTNUM"));
				board.setAid(rs.getString("AID"));
				board.setAname(rs.getString("ANAME"));
				board.setNtsub(rs.getString("NTSUB"));
				board.setNtcont(rs.getString("NTCONT"));
				board.setNtfiles(rs.getString("NTFILES"));
				board.setNtdate(rs.getDate("NTDATE"));
				board.setNtvisit(rs.getInt("NTVISIT"));
				list.add(board);
			}
            return list; //값을 담은 객체 저장한 리스트를 호출
        } catch (Exception ex) {
        	System.out.println("getBoardList() error :" + ex);
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
		return null;
    } // end getBoardList
	
	
	public boolean isBoardWriter(int num, String id) {
		String board_sql = "select * from NT_BOARD where NTNUM = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			rs.next();
			if(id.equals(rs.getString("AID"))) {
				return true;
			}
		} catch(Exception ex) {
			System.out.println("isBoardWriter() error : " + ex);
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
	
	
	
	
	
	
	

}
