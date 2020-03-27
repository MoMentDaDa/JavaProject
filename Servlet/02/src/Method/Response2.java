package Method;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
public class Response2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// 实现数据压缩回送给浏览器
		response.setContentType("text/html;charset=UTF-8");
		String ss = "fsdfhsdfhuisdhfusdhfuids" + "fsdfdsfsdfsdfdsfdafdsfhsdjfhsdjkfhkjds" + "fdsfjdslkfjsldkfjsdlkfjsdkfsdjkff"
				+ "fsjdfjdsklfjdsklfjkldsfjlksdjflksdjflkds" + "dsjfklsdjflsdjfkldsfkjsdkfjsldkfjsdlfk" + "fdsjlkfjdslkfjsdlkfjlkasjflk";
		//response.getWriter().write("原来的长度是：" + ss.getBytes().length + "</br>");
		//response.getWriter().write(ss);// 输出给浏览器
		
		// 创建GZIPOutputStream对象，给予它ByteArrayOutputStream
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
		// GZIP对数据压缩，GZIP写入的数据是保存在byteArrayOutputStream上的
		gzipOutputStream.write(ss.getBytes());
		// gzipOutputStream有缓冲，把缓冲清了，并顺便关闭流
		gzipOutputStream.close();
		// 将压缩的数据取出来
		byte[] bytes = byteArrayOutputStream.toByteArray();
		// 将压缩的数据写给浏览器
		response.getOutputStream().write(bytes);
		// 告诉浏览器这是gzip压缩的数据
		response.setHeader("Content-Encoding", "gzip");
		// 再将压缩的数据写给浏览器
		System.out.println("压缩后长度为："+bytes.length);
		response.getOutputStream().write(bytes);
		*/

		// 生成随机图片这是非常常见的。在我们登陆的时候经常要写验证码，而那些验证码是一张图片
		// 在内存中生成一张图片,宽为80,高为20，类型是RGB
		BufferedImage bufferedImage = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		// 获取到这张图片,并设置为白底
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 100, 40);
		// 往图片设置颜色和字体
		graphics.setColor(Color.black);
		graphics.setFont(new Font(null, Font.BOLD, 20));
		// 往图片上写数据，先写个12345，横坐标是0，纵坐标是20【高度】
		graphics.drawString(makeNum(), 5, 25);
		System.out.println(this.makeNum());
		// 要往浏览器写一张图片，那要告诉浏览器回送的类型是一张图片
		response.setHeader("ContentType", "jpeg");
		// 把图片传进去，类型是jpg，写给浏览器，java提供了图片流给我们使用，这是一个工具类
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

	}

	// 随机生成数字
	private String makeNum() {
		Random random = new Random();
		// 这样就会生成0-7位的随机数，现在问题又来了，如果随机数不够7位呢？如果不够7位，我们加到7位就行了
		int anInt = random.nextInt(9999999);
		// 将数字转成是字符串
		String num = String.valueOf(anInt);
		// 判断位数有多少个，不够就加
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 7 - num.length(); i++) {
			stringBuffer.append("0");
		}

		return stringBuffer.append(num).toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
