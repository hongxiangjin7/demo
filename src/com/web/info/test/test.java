package com.web.info.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.web.info.system.PageBar;
import com.web.util.DateUtil;

public class test {

	public static void main(String[] args) {
		//String uuid = UUID.randomUUID().toString();
		//String  uuid36 = UUID.randomUUID().toString().replace("-", "").toLowerCase();
//		try {	
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		Date date = formatter.parse("2018-04-10T17:00:00+08:00");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String sDate=sdf.format(date);
//		System.out.println(sDate);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		SimpleDateFormat df1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String str = "2018-04-10T17:00:00+08:00";
//		try {
//			Date dat =  DateUtil.string2Date("yyyy-MM-dd HH:mm:ss", str);
//			System.out.println(dat);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		System.out.println(df1.format(new Date()));
		/*String oldpath = "D:/img/新建文件夹/W76F01F01/2018911151329_45876/570/";
		String realPath = "D:/img/新建文件夹/W76F01F01/2018911151329_45876/" + (int) ((Math.random() * 9 + 1) * 100000);
		File fileML = new File(realPath);
		// 判断文件夹是否存在，不存在则创建
		if (!fileML.exists() && !fileML.isDirectory()) {
			fileML.mkdirs();
		}
		List<String> a = FileUtil.getFileName("D:/img/新建文件夹/W76F01F01/2018911151329_45876/570/");
		System.out.println("开始复制:" + a);
		Integer b = 12;
		Integer oldc = 0;
		for (String str : a) {
			String indexstr = str.substring(0, str.indexOf("_"));
			if (oldc != 0) {
				if (Integer.parseInt(indexstr) > oldc) {
					b = b + 1;
				}
			}
			oldc = Integer.parseInt(indexstr);
			String newstr = str.substring(str.indexOf("_") + 1);// 指定字符之后的全部
			// System.out.println(b.toString()+"_"+newstr);
			FileUtil.copyFile(oldpath + str, realPath + "/" + b.toString() + "_" + newstr);
		}*/
	}
}
