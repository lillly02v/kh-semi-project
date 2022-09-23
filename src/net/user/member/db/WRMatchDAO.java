package net.user.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WRMatchDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public WRMatchDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception e) {
			System.out.println("DB 연결 실패 : " + e);
			return;
		}
	}
	
	public int sendMatch(WRMatchVO matchVO) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "insert into WR_MATCH(MNUM, BOARDNUM, REQUESTMB, RESPONSEMB, MATCHING, MATCHDATE) "
					+ "values(WR_MATCH_SEQ.NEXTVAL, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, matchVO.getBoardNum());
			pstmt.setString(2, matchVO.getRequestMb());
			pstmt.setString(3, matchVO.getResponseMb());
			pstmt.setString(4, matchVO.getMatching());
			result = pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
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
		
		return result;
	}
	
	public int processState(int boardNum, String responseMb) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "select MATCHING from WR_MATCH "
					+ "where BOARDNUM = ? and RESPONSEMB = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setString(2, responseMb);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("MATCHING").equals("매칭완료")) {
					result = 1;
				}
			}
			return result;
			
			
		} catch(Exception e) {
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
	
	public String stateBtn(WRMatchVO matchVO) {
		String matchText = "";
		String sql = "";
		try {
			con = ds.getConnection();
			sql = "select MATCHING from WR_MATCH "
					+ "where BOARDNUM = ? and MATCHING = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, matchVO.getBoardNum());
			pstmt.setString(2, "매칭완료");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				matchText = rs.getString("MATCHING");
				return matchText;
			} else {
				rs.close();
				pstmt.close();
				
				sql = "select MATCHING from WR_MATCH "
						+ "where BOARDNUM = ? AND REQUESTMB = ? AND RESPONSEMB = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, matchVO.getBoardNum());
				pstmt.setString(2, matchVO.getRequestMb());
				pstmt.setString(3, matchVO.getResponseMb());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					matchText = rs.getString("MATCHING");
					return matchText;
				}
			}
			
			
		} catch(Exception e) {
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
	
	public int messageCount(String id) {
		int count = 0;
		try {
			con = ds.getConnection();
			String sql = "select count(MNUM) from WR_MATCH "
					+ " where RESPONSEMB = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
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
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	public List<WRMatchVO> messageGetList(String responseMB){
		List<WRMatchVO> list = new ArrayList<WRMatchVO>();
		try {
			con = ds.getConnection();
			
			String sql = "select MNUM, BOARDNUM, REQUESTMB, MATCHING, CONFIRM, MATCHDATE, APPROVEDATE "
					+ " from WR_MATCH "
					+ " where RESPONSEMB = ? "
					+ " order by MATCHDATE DESC ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, responseMB);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WRMatchVO matchVO = new WRMatchVO();
				matchVO.setmNum(rs.getInt(1));
				matchVO.setBoardNum(rs.getInt(2));
				matchVO.setRequestMb(rs.getString(3));
				matchVO.setMatching(rs.getString(4));
				matchVO.setConfirm(rs.getString(5));
				matchVO.setMatchDate(rs.getDate(6));
				matchVO.setApproveDate(rs.getDate(7));

				list.add(matchVO);
			}
			return list;
		} catch(Exception e) {
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
	
	public List<WRMatchVO> alarmGetList(String requestMB){
		List<WRMatchVO> list = new ArrayList<WRMatchVO>();
		try {
			con = ds.getConnection();
			
			String sql = "select MNUM, BOARDNUM, RESPONSEMB, MATCHDATE, APPROVEDATE "
					+ " from WR_MATCH "
					+ " where REQUESTMB = ? and MATCHING = '매칭완료' and CONFIRM = '미확인' "
					+ " order by MATCHDATE DESC ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, requestMB);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WRMatchVO matchVO = new WRMatchVO();
				matchVO.setmNum(rs.getInt(1));
				matchVO.setBoardNum(rs.getInt(2));
				matchVO.setResponseMb(rs.getString(3));
				matchVO.setMatchDate(rs.getDate(4));
				matchVO.setApproveDate(rs.getDate(5));

				list.add(matchVO);
			}
			return list;
		} catch(Exception e) {
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
	
	public int approveCancleMatch(WRMatchVO matchVO, String str) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "";
			
			if(str.equals("approve")) {
				sql = "update WR_MATCH set MATCHING = '매칭완료', CONFIRM = '미확인', APPROVEDATE = sysdate "
						+ " where MNUM = ? and BOARDNUM = ? and REQUESTMB = ? and RESPONSEMB = ? ";
			} else if(str.equals("cancle")){
				sql = "update WR_MATCH set MATCHING = '매칭중', CONFIRM = NULL, APPROVEDATE = NULL "
						+ " where MNUM = ? and BOARDNUM = ? and REQUESTMB = ? and RESPONSEMB = ? ";
			} else if(str.equals("confirm")) {
				sql = "update VT_MATCH set CONFIRM = '확인' "
						+ " where MNUM = ? and BOARDNUM = ? and REQUESTMB = ? and RESPONSEMB = ? ";
			}
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, matchVO.getmNum());
			pstmt.setInt(2, matchVO.getBoardNum());
			pstmt.setString(3, matchVO.getRequestMb());
			pstmt.setString(4, matchVO.getResponseMb());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
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
		return result;
	}
	
	public int rejectMatch(WRMatchVO matchVO) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "delete from WR_MATCH "
					+ " where MNUM = ? and BOARDNUM = ? and REQUESTMB = ? and RESPONSEMB = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, matchVO.getmNum());
			pstmt.setInt(2, matchVO.getBoardNum());
			pstmt.setString(3, matchVO.getRequestMb());
			pstmt.setString(4, matchVO.getResponseMb());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
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
		return result;
	}
}