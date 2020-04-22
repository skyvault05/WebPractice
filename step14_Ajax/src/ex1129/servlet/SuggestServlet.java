package ex1129.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String [] words= {
	   "자바프로그래밍","자바란?","java시작하기",
	   "Ajax란 무엇인가","ajax를 잘하자.", "javaScript 공부",
	   "웹 프로그래밍","웹사이트 제작하기","웹의 동작원리",
	   "jsp 공부","jQuery 학습","jsp 수업중"
	};
	
	public List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		return list;
	}
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String keyWord = request.getParameter("keyWord");
		
		//전송된 데이터 단어로 시작하는 정보를 찾아서 응답
		List<String> list = this.search(keyWord);
		
		//text로 전송 ->  개수|단어,단어,... 
		
		PrintWriter out = response.getWriter();
		
		String str = list.size()+"|";
		for(int i=0; i< list.size() ; i++) {
			if((i+1) == list.size()) {
				str+=list.get(i);
			}else {
				str+=list.get(i) +",";
			}
		}

		out.println(str);
	}

}






