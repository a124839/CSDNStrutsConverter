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
	//дdateת���Ĺ�����
	public Convert() {
		System.out.println("=================conver������ִ����====================");
		//��ȡ��ǰWEBӦ�õ�pattern
		//��servletcontext�л�ȡ
		ServletContext servletContext = ServletActionContext.getServletContext();
		String pattern = servletContext.getInitParameter("pattern");
		
		dateFormat = new SimpleDateFormat(pattern);
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("===================convertFromString����ִ��====================");
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
		//���ת���ɹ�����arg1
		return arg1;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.out.println("===============convertToString����ִ��================");
		//�ж�arg1�Ƿ���date����,�������ǿת
		if (arg1 instanceof Date) {
			Date date = (Date) arg0;
			return dateFormat.format(date);
		}
		//���ת��ʧ�ܷ��ؿ�
		return null;
	}

}
