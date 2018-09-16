package com.donkey.demo.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Title: StrUtil.java Description: 字符处理公共类

 *         	<li>1.getFormData() 封装request请求参数为HashMap</li>
 *         	<li>2.getNoNullNewStr() 去NULL 用传入得参数代替</li>
 *         	<li>3.dateToString()	日期转化为字符串</li>
 *         	<li>4.datetimeToString()	日期时间转化为字符串</li>
 *         	<li>5.isEmpty()	判断字符串是否无效</li>
 *         	<li>6.strFormat()	字符串为空或去掉前后空格处理</li>
 *         	<li>7.isNumber() 判断是否数字</li>
 *         	<li>8.getOPERATEID()	生成受理号</li>
 *         	<li>9.encodeFileName()	将文件名进行转码，避免乱码</li>
 *         	<li>10.getFlowNo()	获取流水号(20位)</li>
 *         	<li>11.formatValue()	格式化值格式</li>
 *         </ul>
 */
public class StrUtil extends org.apache.commons.lang3.StringUtils{
	private static final String CHARSET_NAME = "UTF-8";
	/**
	 * 处理json解析不了的特殊字符
	 * @param paramValue
	 * @return
	 */
	public static String transferString(String paramValue) {
		if (!"".equals(paramValue) && paramValue != null) {
			paramValue = paramValue.replaceAll("\"", "“");
			//paramValue = paramValue.replaceAll("\"", "”");
			paramValue = paramValue.replaceAll("\'", "‘");
			paramValue = paramValue.replaceAll("\\\\", " ");
			paramValue = paramValue.replaceAll("&apos;", "‘");
			paramValue = paramValue.replaceAll("\n", " ");
			paramValue = paramValue.replaceAll("\r", " ");			
			//paramValue = paramValue.replaceAll("\'", "’");
		}
		return paramValue;
	}
	/*********
	 * 处理工单流转备注
	 * @param paramValue
	 * @return
	 * @author xiaojianfeng
	 * @updateDate:2015-11-04
	 */
	public static String transFerStringMemo(String paramValue){
		if (!"".equals(paramValue) && paramValue != null) {
			paramValue = paramValue.replaceAll("\"", "“");
			paramValue = paramValue.replaceAll("\'", "‘");
			paramValue = paramValue.replaceAll("\\\\", " ");
			paramValue = paramValue.replaceAll("&apos;", "‘");
			paramValue = paramValue.replaceAll("\r\n", "<br>");
		}
		return paramValue;
	}

	/**
	 * @desc 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}

	/**
	 * @desc 将对象转为字符串
	 * @param o
	 * @return
	 */
	public static String isNull(Object o) {
		if (o == null) {
			return "";
		}
		String str = "";
		if (o instanceof String) {
			str = (String) o;
		} else {
			str = o.toString();
		}
		return str.trim();
	}
	
	/**
	 * 去NULL 用传入得参数代替
	 * @param oldStr
	 * @param rel
	 * @return
	 */
	public static String getNoNullNewStr(String oldStr, String rel) {
		String newStr = (oldStr == null ? rel : oldStr.trim());
		return newStr;
	}
	
	/**
	 * 日期转化为字符串
	 * @param date	日期
	 * @return	如：2015-01-08
	 * @throws Exception
	 */
	public static String dateToString(Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 日期时间转化为字符串
	 * @param date	日期时间
	 * @return	如：2015-01-08 12:12:12
	 * @throws Exception
	 */
	public static String datetimeToString(Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		return sdf.format(date);
	}
	
	//add by zhangdulong 20150917 增加替换掉特殊字符
	public static final String filterHF(Object out) {
		
		if (out == null || out.toString().length() == 0)
			return "";
		String sout = out.toString();
		StringBuffer sb = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < sout.length(); i++) {
			ch = sout.charAt(i);
			if (ch == '<') {
				sb.append("&lt;");
			} else if (ch == '>') {
				sb.append("&gt;");
			} else if (ch == '&') {
				sb.append("&amp;");
			} else if (ch == '"') {
				sb.append("&quot;");
			} else if (ch == '\'') {
				sb.append("&#39;"); // &acute
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static final String filterHF(String out) {
		if (out == null || out.length() == 0)
			return out;
		StringBuffer sb = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < out.length(); i++) {
			ch = out.charAt(i);
			if (ch == '<') {
				sb.append("&lt;");
			} else if (ch == '>') {
				sb.append("&gt;");
			} else if (ch == '&') {
				sb.append("&amp;");
			} else if (ch == '"') {
				sb.append("&quot;");
			} else if (ch == '\'') {
				sb.append("&#39;"); // &acute
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public static final String filterSS(String out) {
		if (out == null || out.length() == 0)
			return out;
		StringBuffer sb = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < out.length(); i++) {
			ch = out.charAt(i);
			if (ch == '&') {
				sb.append("&amp;");
			} else if (ch == '"') {
				sb.append("&quot;");
			} else if (ch == '\'') {
				sb.append("&#39;"); // &acute
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	/**
	 * 去掉字符串前后空格
	 * @param sValue
	 * @return
	 */
	public static String getString(String sValue) {
		return (sValue == null) ? "" : sValue.trim();
	}

	// 必须是|1|2|3|否则最后一个为&ERROR&
	static public String getFieldData(String AString, int Index, char Dilimiter) {
		int p1, p2;
		int count;
		p1 = 0;
		p2 = 0;
		count = 0;
		if (AString == null)
			AString = "";
		for (int i = 0; i < AString.length(); i++) {
			if (AString.charAt(i) == Dilimiter) {
				p2 = p1;
				p1 = i + 1;
				count++;
			}
			if (count == Index) {
				break;
			}
		}

		if ((p1 > 0) && (count == Index))
			return AString.substring(p2, p1 - 1).trim();
		else
			return "&ERROR&";
	}

	/**
	 * 判断字符串是否无效
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str.trim()) || "null".equals(str.trim())
				|| "NULL".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 字符串为空或去掉前后空格处理
	 * @param str
	 * @return
	 */
	public static String strFormat(String str) {
		if (null == str || "".equals(str.trim()) || "null".equals(str.trim())
				|| "NULL".equals(str.trim())) {
			return "";
		} else {
			return str.trim();
		}
	}

	/**
	 * 校验输入串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		boolean rtn = true;
		String array[] = str.split("");// 将字符串转换为字符串数组，以""为分隔符来转换字符串。注：array[0]=""
		int length = array.length;
		for (int i = 1; i < length; i++) { // 从array[1]开始判断
			int code = array[i].hashCode(); // 获得ASCII码
			// 如果array[i]为数字
			if (code >= 48 && code <= 57) { // 判断是否为数字
				continue;
			} else {
				rtn = false;
				break;
			}
		}

		return rtn;
	}

	/**
	 * 生成受理号
	 * 
	 * @param OPERATETYPE
	 *            工单编号
	 * @param flowno
	 *            流水号
	 * @return String
	 * */
	public static String getOPERATEID(String OPERATETYPE, String flowno) {

		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		StringBuffer sb = new StringBuffer(date);
		sb.append(OPERATETYPE).append(flowno);
		return sb.toString();

	}

	/**
	 * 将文件名进行转码，避免乱码
	 * @param request
	 * @param fileName
	 * @author xiajia
	 * @return
	 */
	public static String encodeFileName(HttpServletRequest request,
			String fileName) {
//		String agent = request.getHeader("USER-AGENT");
//		try {
//			if (null != agent && -1 != agent.indexOf("MSIE")) {
//				return URLEncoder.encode(fileName, "UTF-8");
//			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
//				return "=?UTF-8?B?"
//						+ new String(Base64.encodeBase64(fileName
//								.getBytes("UTF-8"))) + "?=";
//			} else {
//				return fileName;
//			}
//		} catch (UnsupportedEncodingException e) {
//		}
		return "";
	}
	
	/**
	 * 1.将null对象返回空字符串-“""”<br>
	 * 2.若非null对象返回toString()及trim字符串<br>
	 * 
	 * @param origin
	 *            String
	 * @return String
	 */
	public static String null2Str(Object origin) {
		return (origin == null ? "" : origin.toString().trim()).replace("null", "");
	}
	
	/**
	 * 格式化值格式
	 * @param value 值
	 * @param valueFormat 值格式(保留2位小数，若显示88.00%，则传入0.00%;若显示88.88，则传入0.00。以此类推！)
	 * @author xuwei
	 * @return
	 */
	public static String formatValue(String value,String valueFormat){
		String digits = "";//默认0位，即取整数
		NumberFormat numberFormat = null;
		if(valueFormat.indexOf("%") > 0){
			//带%值格式
			digits = valueFormat.substring(0, valueFormat.indexOf("%"));//去掉%
			numberFormat = NumberFormat.getPercentInstance();
		}else{
			//不带%值格式
			digits = valueFormat;
			numberFormat = NumberFormat.getNumberInstance();
		}
		if(digits.indexOf(".") > 0){
			//含小数点，取小数点后面的位数
			digits = digits.substring(digits.indexOf(".")+1, digits.length());
		}else{
			digits = "";
		}
		
		int decimals = digits.length();//小数位数
		numberFormat.setMinimumFractionDigits(decimals);
		numberFormat.setMaximumFractionDigits(decimals);
		numberFormat.setGroupingUsed(false);//不千分位显示
		return numberFormat.format(Double.parseDouble(value));
	}
	
	public static String parseSosMgTyp(String mgTyp){
		if(mgTyp.indexOf("Sos")>0){
			return "求助";
		}else if(mgTyp.indexOf("Fire")>0){
			return "火警";
		}else if(mgTyp.indexOf("Aleak")>0){
			return "漏水";
		}else if(mgTyp.indexOf("Hijack")>0){
			return "被劫持";
		}else if(mgTyp.indexOf("War")>0){
			return "预警";
		}else if(mgTyp.indexOf("Alm")>0){
			return "报警";
		}
		return "未知";
	}

	/**
	 * 转换为字节数组
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str){
		if (str != null){
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		}else{
			return null;
		}
	}

	/**
	 * 获取byte[]类型Key
	 * @param object
	 * @return
	 */
	public static byte[] getBytesKey(Object object){
		if(object instanceof String){
			return getBytes((String)object);
		}else{
			return ObjectUtils.serialize(object);
		}
	}

	/**
	 * 转换为字节数组
	 * @return
	 */
	public static String toString(byte[] bytes){
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	/**
	 * 校验是否为手机号
	 * @param str
	 * @return
	 */
	public static boolean isMobile(final String str) {
		boolean b ;
		if(isBlank(str)){
			return false;
		}
		Pattern p = Pattern.compile("^[1][3,4,5,6,7,8][0-9]{9}$"); // 验证手机号
		Matcher m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 按指定大小，分隔集合，将集合按规定个数分为n个部分
	 *
	 * @param list
	 * @param len
	 * @return
	 */
	public static List<List<String>> splitList(List<String> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		int size = list.size();
		int count = (size + len - 1) / len;
		for (int i = 0; i < count; i++) {
			List<String> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}

	public static String listToString(List list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return list.isEmpty()?"":sb.toString().substring(0, sb.toString().length() - 1);
	}

	/**
	 * @desc String转long
	 * @param str
	 * @return
	 */
	public static long getLong(String str){
		if(str==null||str.equals(""))
			return 0L;
		long ret=0;
		try {
			ret=Long.parseLong(str);
		} catch (NumberFormatException e) {
			ret=0;
		}
		return ret;
	}

	/**
	 * @desc String转Int
	 * @param str
	 * @return
	 */
	public static int getInt(String str){
		if(str==null||str.equals(""))
			return 0;
		int ret=0;
		try {
			ret=Integer.parseInt(str);
		} catch (NumberFormatException e) {
			ret=0;
		}
		return ret;
	}

	public static List<String> getRandomFromArray(String[] array, int count){
		if(array == null){
			return null;
		}
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		if(count > array.length || count < 0){
			for(String s: array){
				stringList.add(s);
			}
			return stringList;
		}
		int n = 0;//新集合下标计数
		Map map = new HashMap();
		while (map.size() < count){
			int temp = random.nextInt(array.length);
			if(!map.containsKey(temp)){
				map.put(temp, "");
				stringList.add(array[temp]);
			}
		}
		return stringList;
	}

	public static int calcSurplusNewsCount(List<String> list, int expectCount){
		int surplusCount = 0;
		if(list != null && list.size() > 0){
			surplusCount = (expectCount - list.size());
		}else{
			surplusCount = expectCount;
		}
		return surplusCount;
	}

	/**
	 * 根据频道列表，随机出一定num的新频道列表
	 * @param pidList
	 * @param num
	 * @return
	 */
	public static List<String> createRandomPids(List<String> pidList, int num) {
		if(num == 0){
			return null;
		}
		List<String> pids = new ArrayList<String>();
		if(pidList != null && pidList.size() >=num ){
			Collections.shuffle(pidList);
			pids.addAll(pidList.subList(0,num));
		}else{
			pids.addAll(pidList);
		}
		return pids;
	}

	public static String createDefaultRecKey(String deviceId,String pid){
		String key ="##ttrc:prev:"+deviceId+":"+pid;
		return key;
	}


	public static String createRecKey(String deviceId,int pid,String slipType){
		String key ="##ttrc:"+slipType+":"+deviceId+":"+pid;
		return key;
	}

	public static String createRecPastKey(String deviceId,int pid,String slipType){
		String key = "##ttrc:"+slipType+":past:"+deviceId+":"+pid;
		return key;
	}

	public static String createFixRecCommonKey(String pid){
		String key ="##ttrc:common:"+pid;
		return key;
	}

	//使用循环判断
	public static boolean isContain(String[] arr,String targetValue){
		for(String s:arr){
			if(s.equals(targetValue))
				return true;
		}
		return false;
	}


	/**
	 * 根据比例生成位置
	 */
	public static int createIndex(int i){
		int result = 0;
		int a = i%10;
		if(a == 0|| a==1 || a==4 || a==7){
			result = 1;
		}else if(a==2 || a==5 || a== 8){
			result = 2;
		}else if(a == 3 || a== 6){
			result = 3;
		}else if(a == 9){
			result = 4;
		}
		return result;
	}

	/**
	 * 把一个List集合有规律的插入另一个List集合中,如果插入的list数量不足，就按照待插入list的原集合显示元素
	 * @param mainList 待插入List
	 * @param insertList 插入List
	 * @param step 步长
	 * @return
	 */
	public static List<String> regularInsertList(List<String> mainList, List<String> insertList, int step){
		if(mainList != null && mainList.size() >0 && insertList != null){
			int mainSize = mainList.size();
			for(int i = 0; i< mainSize;){
				i += step;
				if(insertList.size() <= 0){
					break;
				}
				if(i >  mainSize){
					mainList.add(mainSize,insertList.get(0));
				}else{
					mainList.add(i,insertList.get(0));
				}
				insertList.remove(0);
				i+=1;
			}
		}
		return mainList;
	}
}