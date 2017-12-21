package im.wzn.unsplash.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filewrite")
public class FileWriteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Value.PATH = request.getSession().getServletContext().getRealPath("");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String s = "没数据";

		s = getString(request);

		// fileCreate(null);
		System.out.println(Value.PATH);
		System.out.println(s);
		out.println(s);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Value.PATH = request.getSession().getServletContext().getRealPath("");
		response.setContentType("text/html");

		String s = "没数据";
		try {
			s = getString(request);
			PrintWriter out = response.getWriter();
			out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileCreate(s);
		System.out.println(s);

	}

	/**
	 * 
	 * @return 返回request中的数据
	 * @throws IOException
	 */
	private String getString(HttpServletRequest request) throws IOException {
		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		body = stringBuilder.toString();

		return body;
	}

	private void fileCreate(String data) {
		File file = new File(Value.PATH, "write" + Value.JS);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileWrite(file, data);
	}

	private void fileWrite(File file, String data) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(data);
			out.close();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
