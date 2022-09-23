package net.board.wb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WBReplyDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public WBReplyDAO(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패: " + ex);
			return;
		}
	}
	
	public List<WBReplyVO> list(Integer bno) throws Exception{
		return null;
	}
	
	public void create(WBReplyVO board) throws Exception{
		
	}
	
	public void update(WBReplyVO board) throws Exception{
		
	}
	
	public void delete(Integer rno) throws Exception{
		
	}
	
	public List<WBReplyVO> listPage(Integer bno) throws Exception{
		return null;
	}
	
	public int count(Integer bno) throws Exception{
		return 0;
	}
	
	public int getBno(Integer rno) throws Exception{
		return 0;
	}

	public static WBReplyDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertReply(WBReplyVO vo) {
		try {
			//session=getSession();
			//session.inert("reply.insertReply",vo);
		}catch(Exception e) {
			System.out.println("insertReply error:"+e);
			e.printStackTrace();
		}
		
	}

	public int boardReply(WBReplyVO boardData) {
		String sql = "";
		int result = 0;
		
		try {
			con = ds.getConnection();
			
			//BOARD_RE_REF, BOARD_RE_SEQ 값을 확인하여 원문 글에서 다른 답글이 있으면
			//다른 답글들의 BOARD_RE_SEQ값을 1씩 증가시킵니다.
			//현재 글을 다른 답글보다 앞에 출력되게 하기 위해서 입니다.
			
			sql = "insert into wr_reply(wrnum, wwbnum, usid, wrcont, wrdate, wrparent, wrsecret) "
					+ "values(?, ?, ?, ?, sysdate, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardData.getWrnum());
			pstmt.setInt(2, boardData.getWwbnum());
			pstmt.setString(3, boardData.getUsid());
			pstmt.setString(4, boardData.getWrcont());
			pstmt.setInt(5, boardData.getWrparent());	//답변에는 파일을 업로드하지 않습니다.
			pstmt.setString(6, boardData.getWrsecret());
			
			result = pstmt.executeUpdate();
			
			return result;
		} catch(Exception ex) {
			System.out.println("boardReply() error : " + ex);
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
		return 0;
		
	}

	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public WBReplyVO getDetail(int num) {
		WBReplyVO board=null;
		try {
			con=ds.getConnection();
			String sql="select * from wr_reply where wrnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board=new WBReplyVO();
				board.setWrnum(rs.getInt("wrnum"));
				board.setWwbnum(rs.getInt("wwbnum"));
				board.setUsid(rs.getString("usid"));
				board.setWrcont(rs.getString("wrcont"));
				board.setWrdate(rs.getDate("wrdate"));
				board.setWrsecret(rs.getString("wrsecret"));
				
			}
			
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



	
}
