package im.wzn.unsplash.servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/getrandom")
public class DataServlet extends HttpServlet {
	private String message;

	public void init() throws ServletException {

		message = "Hello World!!!";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Value.PATH = request.getSession().getServletContext().getRealPath("");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		ImageLoad.reName("image1", "image0");
//		ImageLoad.reName("rename", "333333");
		getUrl("image0");

		

		out.println("");
	}

	private void getUrl(String name) {
		String data = SendGet.sendGet(Value.URL, Value.PARAM);
		Gson gson = new Gson();
		// 完整数据
		ImageBean image = gson.fromJson(data, ImageBean.class);
		Urls urls = image.getUrls();
		String imageName = name + Value.JPG;
		try {
			System.out.println("+++++++++++" + urls.getRegular());
			ImageLoad.downImage(urls.getRegular(), imageName);
		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public void destroy() {

	}
}
