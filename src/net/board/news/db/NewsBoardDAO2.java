package net.board.news.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NewsBoardDAO2 {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public NewsBoardDAO2(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패: " + ex);
			return;
		}
	}
	
	// 게시물 수	리스트카운트
	public int getListCount(HashMap<String, Object> listOpt) {
		
		int result = 0;
	    String opt = (String) listOpt.get("opt");
	    String condition = (String)listOpt.get("condition");
	    
		try {
			con = ds.getConnection();
			if(opt==null) {
				String sql = "select count(*) from news_board ";
				pstmt = con.prepareStatement(sql);
			} else if(opt.equals("0")) {
				String sql = "select count(*) from news_board ";
				pstmt = con.prepareStatement(sql);
			} else if(opt.equals("1")) {
				String sql = "select count(*) from news_board where nesub like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%'+condition+'%');
			} else if(opt.equals("2")) {
				String sql = "select count(*) from news_board where necont like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%'+condition+'%');
			} else if(opt.equals("3")) {
				String sql = "select count(*) from news_board where nesub like ? or necont like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%'+condition+'%');
				pstmt.setString(2, '%'+condition+'%');
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount() error :" + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//게시물 추가
	public boolean boardInsert(NewsBoardVO board) {
		int num = 0;
		String sql ="";
		int result =0;
		try {
			con = ds.getConnection();
			String max_sql = "select max(nenum) from news_board";
			pstmt = con.prepareStatement(max_sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}
			
			pstmt.close();
			rs.close();
			
			sql = "insert into news_board "
					+ "(nenum, aid, aname, nesub, necont, nefiles, nedate, nevisit) "
					+ " values(?, ?, ?, ?, ?, ?, sysdate, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getAid());					
			pstmt.setString(3, board.getAname());					
			pstmt.setString(4, board.getNesub());					
			pstmt.setString(5, board.getNecont());					
			pstmt.setString(6, board.getNefiles());
			pstmt.setInt(7, board.getNevisit());
			
			result = pstmt.executeUpdate();
			if(result ==0) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert() error : " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	//방문자수 +1
	public void setReadCountUpdate(int num) {
		String sql = "update news_board "
				+ "set nevisit=nevisit + 1 "
				+ "where nenum = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
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
	
	//게시물 보기
	public NewsBoardVO getDetail(int num) {
		NewsBoardVO board = null;
		try {
			con = ds.getConnection();
			
			String sql = "select * from news_board where nenum = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board = new NewsBoardVO();
				board.setNenum(rs.getInt("nenum"));
				board.setAid(rs.getString("aid"));
				board.setAname(rs.getString("aname"));
				board.setNesub(rs.getString("nesub"));
				board.setNecont(rs.getString("necont"));
				board.setNefiles(rs.getString("nefiles"));
				board.setNedate(rs.getDate("nedate"));
				board.setNevisit(rs.getInt("nevisit"));
			}
			return board;
		} catch(Exception ex) {
			System.out.println("getDeail() error : " + ex);
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
	
	//게시물 수정
	public boolean boardModify(NewsBoardVO board) {
		int num = 0;
		try {
			con = ds.getConnection();
			
			String sql = "update news_board "
					+ "set nesub = ?, necont = ?"
					+ "where nenum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getNesub());
			pstmt.setString(2, board.getNecont());
			pstmt.setInt(3, board.getNenum());
			num = pstmt.executeUpdate();
			if(num != 0) {
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
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "delete from news_board "
					+ "where nenum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		} catch(Exception ex) {
			System.out.println("boardDelete() error : " + ex);
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
	
	//검색 리스트 어레이리스트 출력
	public ArrayList<NewsBoardVO> getBoardList(HashMap<String, Object> listOpt, int page, int limit, String search, String searchOpt){
			
	String opt = (String)listOpt.get("opt"); 
	String condition = (String)listOpt.get("condition");
    int start = (Integer)listOpt.get("start"); 
    
    ArrayList<NewsBoardVO> list = new ArrayList<NewsBoardVO>();
	
	try {
		con=ds.getConnection();
            
            // 글목록 전체를 보여줄 때
            if(opt == null) {
            	String board_list_sql =
        				"select * from "
        				+ "(select rownum rnum,  NENUM, AID, ANAME, "
        				+ "NESUB, NECONT, NEFILES, NEDATE, NEVISIT "
        				+ "from (select * from news_board "
        				+ "order by nenum desc)) "
        				+ "where rnum>=? and rnum<=? ";
        				
                pstmt = con.prepareStatement(board_list_sql);
                pstmt.setInt(1, start);
                pstmt.setInt(2, start+9);
                System.out.println("검색이 null일때");
            } else if(opt.equals("0")) {	//선택으로 검색
            	String board_list_sql =
            			"select * from "
                				+ "(select rownum rnum,  NENUM, AID, ANAME, "
                				+ "NESUB, NECONT, NEFILES, NEDATE, NEVISIT "
                				+ "from (select * from news_board "
                				+ "order by nenum desc)) "
                				+ "where rnum>=? and rnum<=? ";
        				
                pstmt = con.prepareStatement(board_list_sql);
                pstmt.setInt(1, start);
                pstmt.setInt(2, start+9);
                System.out.println("검색이 선택일때");
                
            } else if(opt.equals("1")){ // 제목으로 검색
            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, nenum, aid, aname, "
            			+ "nesub, necont, nefiles, nedate, nevisit "
            			+ "from (select * from news_board "
            			+ "where nesub like ? "
            			+ "order by nenum asc)) "
            			+ "where rnum>=? and rnum<=? "
            			+ "order by NENUM desc";
                
                pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setInt(2, start);
                pstmt.setInt(3, start+9);
                System.out.println("검색이 제목검색");
            } else if(opt.equals("2")) { // 내용으로 검색
            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, nenum, aid, aname, "
            			+ "nesub, necont, nefiles, nedate, nevisit "
            			+ "from (select * from news_board "
            			+ "where necont like ? "
            			+ "order by nenum asc)) "
            			+ "where rnum>=? and rnum<=?"
            			+ "order by NENUM desc";
            
            	pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setInt(2, start);
                pstmt.setInt(3, start+9);
                System.out.println("검색이 내용검색");
                
            } else if(opt.equals("3")) { //제목+내용
            	String board_list_sql =
            			"select * from "
            			+ "(select rownum rnum, nenum, aid, aname, "
            			+ "nesub, necont, nefiles, nedate, nevisit "
            			+ "from (select * from news_board "
            			+ "where nesub like ? or necont like ? "
            			+ "order by nenum desc)) "
            			+ "where rnum>=? and rnum<=? "
            			+ "order by NENUM desc"; 
                
            	pstmt = con.prepareStatement(board_list_sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setString(2, "%"+condition+"%");
                pstmt.setInt(3, start);
                pstmt.setInt(4, start+9);
                System.out.println("검색이 제목+내용 검색");
            }
            
            rs = pstmt.executeQuery();
            while(rs.next()) {
				NewsBoardVO board = new NewsBoardVO();
				board.setNenum(rs.getInt("nenum"));
				board.setAid(rs.getString("aid"));
				board.setAname(rs.getString("aname"));
				board.setNesub(rs.getString("nesub"));
				board.setNecont(rs.getString("necont"));
				board.setNefiles(rs.getString("nefiles"));
				board.setNedate(rs.getDate("nedate"));
				board.setNevisit(rs.getInt("nevisit"));
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
	
	
	
	//검색 앨범 어레이리스트 출력
	public ArrayList<NewsBoardVO> getBoardAlbum(HashMap<String, Object> listOpt, int page, int limit, String search, String searchOpt){
		
		String opt = (String)listOpt.get("opt"); 
		String condition = (String)listOpt.get("condition");
		int start = (Integer)listOpt.get("start"); 
		
		ArrayList<NewsBoardVO> list = new ArrayList<NewsBoardVO>();
		
		try {
			con=ds.getConnection();
			
			// 글목록 전체를 보여줄 때
			if(opt == null) {
				String board_list_sql =
						"select * from "
								+ "(select rownum rnum,  NENUM, AID, ANAME, "
								+ "NESUB, NECONT, NEFILES, NEDATE, NEVISIT "
								+ "from (select * from news_board "
								+ "order by nenum desc)) "
								+ "where rnum>=? and rnum<=? ";
				
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+11);
				System.out.println("검색이 null일때");
			} else if(opt.equals("0")) {	//선택으로 검색
				String board_list_sql =
						"select * from "
								+ "(select rownum rnum,  NENUM, AID, ANAME, "
								+ "NESUB, NECONT, NEFILES, NEDATE, NEVISIT "
								+ "from (select * from news_board "
								+ "order by nenum desc)) "
								+ "where rnum>=? and rnum<=? ";
				
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+11);
				System.out.println("검색이 선택일때");
				
			} else if(opt.equals("1")){ // 제목으로 검색
				String board_list_sql =
						"select * from "
								+ "(select rownum rnum, nenum, aid, aname, "
								+ "nesub, necont, nefiles, nedate, nevisit "
								+ "from (select * from news_board "
								+ "where nesub like ? "
								+ "order by nenum asc)) "
								+ "where rnum>=? and rnum<=? "
								+ "order by NENUM desc";
				
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+11);
				System.out.println("검색이 제목검색");
			} else if(opt.equals("2")) { // 내용으로 검색
				String board_list_sql =
						"select * from "
								+ "(select rownum rnum, nenum, aid, aname, "
								+ "nesub, necont, nefiles, nedate, nevisit "
								+ "from (select * from news_board "
								+ "where necont like ? "
								+ "order by nenum asc)) "
								+ "where rnum>=? and rnum<=?"
								+ "order by NENUM desc";
				
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+11);
				System.out.println("검색이 내용검색");
				
			} else if(opt.equals("3")) { //제목+내용
				String board_list_sql =
						"select * from "
								+ "(select rownum rnum, nenum, aid, aname, "
								+ "nesub, necont, nefiles, nedate, nevisit "
								+ "from (select * from news_board "
								+ "where nesub like ? or necont like ? "
								+ "order by nenum desc)) "
								+ "where rnum>=? and rnum<=? "
								+ "order by NENUM desc"; 
				
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+11);
				System.out.println("검색이 제목+내용 검색");
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				NewsBoardVO board = new NewsBoardVO();
				board.setNenum(rs.getInt("nenum"));
				board.setAid(rs.getString("aid"));
				board.setAname(rs.getString("aname"));
				board.setNesub(rs.getString("nesub"));
				board.setNecont(rs.getString("necont"));
				board.setNefiles(rs.getString("nefiles"));
				board.setNedate(rs.getDate("nedate"));
				board.setNevisit(rs.getInt("nevisit"));
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
	} // end getBoardAlbum
	
	
}
