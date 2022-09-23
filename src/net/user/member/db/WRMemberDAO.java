package net.user.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * DAO(Data Access Object) 클래스
 * - 데이터 베이스와 연동하여 레코드의 추가, 수정, 삭제 작업이
 * 		이루어지는 클래스 입니다.
 * - 어떤 Action 클래스가 호출되더라도 그에 해당하는
 * 		데이터 베이스 연동 처리는 DAO 클래스에서 이루어지게 됩니다.
 */
public class WRMemberDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	//생성자에게 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	public WRMemberDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int isId(String id, String pass) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql = "select WID, WPASS from WR_MEMBER where WID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(2).equals(pass)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
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
	
	public String userPassFind(String id, String email, String phone) {
		String pass = "";
		try {
			con = ds.getConnection();
			String sql = "select WPASS from WR_MEMBER "
					+ " where WID = ? and WEMAIL = ? and WPHONE = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pass = rs.getString("WPASS");
			}
			return pass;
		} catch(Exception ex) {
			ex.printStackTrace();
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
	
	public double[] addressLatLng(String id) {
		double[] loc = new double[2];
		try {
			con = ds.getConnection();
			String sql = "select WADDRLAT, WADDRLNG from WR_MEMBER where WID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loc[0] = rs.getDouble(1);
				loc[1] = rs.getDouble(2);
			}
			return loc;
		} catch(Exception ex) {
			System.out.println("좌표값을 반환할 수 없습니다.");
			ex.printStackTrace();
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
	
	public JSONArray getAddressList() {
		JSONArray array = new JSONArray();
		try {
			con = ds.getConnection();
			
			String sql = "select WID, WADDRLAT, WADDRLNG from WR_Member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("id", rs.getString(1));
				object.put("lat", rs.getDouble(2));
				object.put("lng", rs.getDouble(3));
				array.add(object);
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
		return array;
	}
	
	public Map<String, Object> monthListCount() {
		Map<String, Object> monthList = new HashMap<String, Object>();
		try {
			con = ds.getConnection();
			String sql = "select MONTH, count(MONTH) from " + 
					"	(select substr(WDATE, 4, 2) as MONTH from WR_MEMBER) " + 
					"		group by MONTH order by MONTH ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				monthList.put(rs.getString(1), rs.getInt(2));
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
		
		return monthList;
	}
	
	public int userAge(String id) {
		int age = 0;
		try {
			con = ds.getConnection();
			String sql = "select (FLOOR((MONTHS_BETWEEN("
					+ "SYSDATE, TO_DATE(WRESID, 'YYYYMMDD'))/12)/10) * 10) "
					+ "AS AGE FROM WR_MEMBER where wid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				age = rs.getInt(1);
				System.out.println(age);
			}
			return age;
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
	
	public Map<String, Object> ageListCount(){
		Map<String, Object> ageList = new HashMap<String, Object>();
		try {
			con = ds.getConnection();
			String sql = "select AGE, count(AGE) from " + 
					"		(select (FLOOR((MONTHS_BETWEEN(SYSDATE, " +
					"		TO_DATE(WRESID, 'YYYYMMDD'))/12)/10) * 10) AS AGE " +
					"			FROM WR_MEMBER) group by AGE order by AGE ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ageList.put(rs.getString(1), rs.getInt(2));
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
		return ageList;
	}
	
	public List<WRMemberVO> getList(){
		List<WRMemberVO> list = new ArrayList<WRMemberVO>();
		try {
			con = ds.getConnection();
			
			String sql =  "select rownum NUM, WID, WPASS, WNAME, WRESID, WGENDER, WJOB, " + 
					"			WPHONE, WEMAIL, WPOST, WADDRESS, WADDRLAT, WADDRLNG, " + 
					"			WPAIN, WKEY, WINTRO, WDATE, WSECRET FROM " + 
					"		(select WID, WPASS, WNAME, WRESID, WGENDER, WJOB, " + 
					"				WPHONE, WEMAIL, WPOST, WADDRESS, WADDRLAT, WADDRLNG, " + 
					"				WPAIN, WKEY, WINTRO, WDATE, WSECRET FROM WR_MEMBER ORDER BY WDATE ASC)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WRMemberVO member = new WRMemberVO();
				member.setNum(rs.getInt("NUM"));
				member.setId(rs.getString("WID"));
				member.setPass(rs.getString("WPASS"));
				member.setName(rs.getString("WNAME"));
				member.setResid(rs.getInt("WRESID"));
				member.setGender(rs.getString("WGENDER"));
				member.setJob(rs.getString("WJOB"));
				member.setPhone(rs.getString("WPHONE"));
				member.setEmail(rs.getString("WEMAIL"));
				member.setPost(rs.getString("WPOST"));
				member.setAddress(rs.getString("WADDRESS"));
				member.setAddrlat(rs.getDouble("WADDRLAT"));
				member.setAddrlng(rs.getDouble("WADDRLNG"));
				member.setPain(rs.getString("WPAIN"));
				member.setKey(rs.getString("WKEY"));
				member.setIntro(rs.getString("WINTRO"));
				member.setDate(rs.getDate("WDATE"));
				member.setSecret(rs.getString("WSECRET"));
				list.add(member);
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
		return list;
	}
	
	public WRMemberVO member_info(String id) {
		WRMemberVO member = new WRMemberVO();
		try {
			con = ds.getConnection();
			String sql = "select * from WR_MEMBER where wid = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("WID"));
				member.setPass(rs.getString("WPASS"));
				member.setName(rs.getString("WNAME"));
				member.setResid(rs.getInt("WRESID"));
				member.setGender(rs.getString("WGENDER"));
				member.setJob(rs.getString("WJOB"));
				member.setPhone(rs.getString("WPHONE"));
				member.setEmail(rs.getString("WEMAIL"));
				member.setPost(rs.getString("WPOST"));
				member.setAddress(rs.getString("WADDRESS"));
				member.setAddrlat(rs.getDouble("WADDRLAT"));
				member.setAddrlng(rs.getDouble("WADDRLNG"));
				member.setPain(rs.getString("WPAIN"));
				member.setKey(rs.getString("WKEY"));
				member.setIntro(rs.getString("WINTRO"));
				member.setDate(rs.getDate("WDATE"));
				member.setSecret(rs.getString("WSECRET"));
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
		return member;
	}
	
	public int delete(String id, String pass) {
		int result = 0;
		try {
			 con = ds.getConnection();
			 
			 String sql = "delete from WR_MEMBER where WID = ? and WPASS = ?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, pass);
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
	
	public int update(WRMemberVO member) {
		int result = 0;
		try {
			con = ds.getConnection();
			
			String sql = "update WR_Member "
					+ "set WPASS = ?, WRESID = ?, WGENDER = ?, WJOB = ?, WPHONE = ?, "
					+ "WEMAIL = ?, WPOST = ?, WADDRESS = ?, WADDRLAT = ?, WADDRLNG = ?, "
					+ "WKEY = ?, WPAIN = ?, WINTRO = ?, WSECRET = ? "
					+ "where WID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPass());
			pstmt.setInt(2, member.getResid());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getJob());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPost());
			pstmt.setString(8, member.getAddress());
			pstmt.setDouble(9, member.getAddrlat());
			pstmt.setDouble(10, member.getAddrlng());
			pstmt.setString(11, member.getKey());
			pstmt.setString(12, member.getPain());
			pstmt.setString(13, member.getIntro());
			pstmt.setString(14, member.getSecret());
			pstmt.setString(15, member.getId());
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
	
	public int insert(WRMemberVO member) {
		int result = 0;
		try {
			con = ds.getConnection();
			
			String sql = "insert into WR_MEMBER "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getResid());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getJob());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getPost());
			pstmt.setString(10, member.getAddress());
			pstmt.setDouble(11, member.getAddrlat());
			pstmt.setDouble(12, member.getAddrlng());
			pstmt.setString(13, member.getPain());
			pstmt.setString(14, member.getKey());
			pstmt.setString(15, member.getIntro());
			pstmt.setString(16, member.getSecret());
			
			result = pstmt.executeUpdate();
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("멤버 아이디 중복 에러입니다.");
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
	
	public int idCheck(String id) {
		int result = 0;
		try {
			String sql = "select wid from WR_MEMBER where wid = ?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = -1;
			} else {
				result = 1;
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
		
		return result;
	}
}
