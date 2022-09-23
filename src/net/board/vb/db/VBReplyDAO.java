package net.board.vb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VBReplyDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public VBReplyDAO(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패: " + ex);
			return;
		}
	}
	
	public List<VBReplyVO> list(Integer bno) throws Exception{
		return null;
	}
	
	public void create(VBReplyVO board) throws Exception{
		
	}
	
	public void update(VBReplyVO board) throws Exception{
		
	}
	
	public void delete(Integer rno) throws Exception{
		
	}
	
	public List<VBReplyVO> listPage(Integer bno) throws Exception{
		return null;
	}
	
	public int count(Integer bno) throws Exception{
		return 0;
	}
	
	public int getBno(Integer rno) throws Exception{
		return 0;
	}

	public static VBReplyDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertReply(VBReplyVO vo) {
		try {
			//session=getSession();
			//session.inert("reply.insertReply",vo);
		}catch(Exception e) {
			System.out.println("insertReply error:"+e);
			e.printStackTrace();
		}
		
	}

	public int boardReply(VBReplyVO boardData) {
		String sql = "";
		int result = 0;
		
		try {
			con = ds.getConnection();
			
			//BOARD_RE_REF, BOARD_RE_SEQ 값을 확인하여 원문 글에서 다른 답글이 있으면
			//다른 답글들의 BOARD_RE_SEQ값을 1씩 증가시킵니다.
			//현재 글을 다른 답글보다 앞에 출력되게 하기 위해서 입니다.
			
			sql = "insert into VT_REPLY (vrnum, vvbnum, usid, vrcont, vrdate, vrparent, vrsecret) "
					+ "values(?, ?, ?, ?, sysdate, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardData.getVrnum());
			pstmt.setInt(2, boardData.getVvbnum());
			pstmt.setString(3, boardData.getUsid());
			pstmt.setString(4, boardData.getVrcont());
			pstmt.setInt(5, boardData.getVrparent());	//답변에는 파일을 업로드하지 않습니다.
			pstmt.setString(6, boardData.getVrsecret());
			
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

	public VBReplyVO getDetail(int num) {
		VBReplyVO board=null;
		try {
			con=ds.getConnection();
			String sql="select * from VT_REPLY where vrnum = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board=new VBReplyVO();
				board.setVrnum(rs.getInt("vrnum"));
				board.setVvbnum(rs.getInt("vvbnum"));
				board.setUsid(rs.getString("usid"));
				board.setVrcont(rs.getString("vrcont"));
				board.setVrdate(rs.getDate("vrdate"));
				board.setVrsecret(rs.getString("vrsecret"));
				
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
