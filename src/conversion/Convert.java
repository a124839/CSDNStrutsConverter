package conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class Convert extends StrutsTypeConverter {
	
	private DateFormat dateFormat;
	//写date转换的构造器
	public Convert() {
		System.out.println("=================conver构造器执行了====================");
		//获取当前WEB应用的pattern
		//从servletcontext中获取
		ServletContext servletContext = ServletActionContext.getServletContext();
		String pattern = servletContext.getInitParameter("pattern");
		
		dateFormat = new SimpleDateFormat(pattern);
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("===================convertFromString方法执行====================");
		if (arg2==Date.class) {
			if (arg1!=null&&arg1.length>0) {
				String value = arg1[0];
				try {
					return dateFormat.parseObject(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		//如果转换成功返回arg1
		return arg1;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.out.println("===============convertToString方法执行================");
		//判断arg1是否是date类型,如果是则强转
		if (arg1 instanceof Date) {
			Date date = (Date) arg0;
			return dateFormat.format(date);
		}
		//如果转换失败返回空
		return null;
	}

}
