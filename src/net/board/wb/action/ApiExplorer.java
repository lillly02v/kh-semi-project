package net.board.wb.action;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLEncoder;
	import java.io.BufferedReader;
	import java.io.IOException;

	public class ApiExplorer {
	    public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.1365.go.kr/openapi/service/rest/VolunteerPartcptnService/getVltrCategoryList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=owP7eDId7hQ4TSfui041fpat2wbSzdsTKGop7kZAGbeWVJSiATrx34E3vki36tazr2YMidzQFIQhkBtq8FCsNw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("upperClCode","UTF-8") + "=" + URLEncoder.encode("0100", "UTF-8")); /*참고 : 코드조회서비스-자원봉사분야코드조회 결과값(급식지원)*/
	        urlBuilder.append("&" + URLEncoder.encode("nanmClCode","UTF-8") + "=" + URLEncoder.encode("0199", "UTF-8")); /*참고 : 코드조회서비스-자원봉사분야코드조회 결과값(생활편의지원)*/
	        urlBuilder.append("&" + URLEncoder.encode("schSido","UTF-8") + "=" + URLEncoder.encode("6410000", "UTF-8")); /*코드조회서비스-지역코드조회 결과값*/
	        urlBuilder.append("&" + URLEncoder.encode("schSign1","UTF-8") + "=" + URLEncoder.encode("6410000", "UTF-8")); /*코드조회서비스-지역코드조회 결과값*/
	        urlBuilder.append("&" + URLEncoder.encode("schCateGu","UTF-8") + "=" + URLEncoder.encode("all", "UTF-8")); /*전체/내용/제목 all/progrmCn/prormSj*/
	        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode("종합지원", "UTF-8")); /*봉사참여 제목*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}

