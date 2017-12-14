package im.wzn.year.calendarconverter;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.crypto.Data;

import im.wzn.year.servlet.SendGet;

public class LunarProgress {

	/*
	 * 获取现在的时间，转成农历 农历2017-1-1转成时间戳 现在的时间戳减去今年开始的时间戳/今年结束减去今年开始*100%
	 * 农历一年最后一天：（获取今年年份+1的年份第一天）-1
	 */
	public static void main(String[] args) {

		//发送 GET 请求
//        String s=SendGet.sendGet("https://maker.ifttt.com/trigger/year/with/key/J3hGogKnuR7a7gFJecyLK", "{\"value1\":\"ds1\"}");
		 //发送 POST 请求
        String s=SendGet.sendPost("https://maker.ifttt.com/trigger/year/with/key/J3hGogKnuR7a7gFJecyLK", "{\"value1\":\"ds2\"}");
        System.out.println(s);

	}
	
	public static String getPercent() {
		int i = 1;
		Calendar calendar = Calendar.getInstance();

		Solar solarNow = new Solar();
		solarNow.solarYear = calendar.get(Calendar.YEAR);
		// The first month of the year is JANUARY which is 0。。。。。。太坑了
		solarNow.solarMonth = calendar.get(Calendar.MONTH) + 1;
		solarNow.solarDay = calendar.get(Calendar.DATE);
		Lunar lunarNow = solar2Lunar(solarNow);
		long now = lunar2Timestamp(lunarNow);
		Lunar lunarBegin = new Lunar();
		lunarBegin.lunarYear = calendar.get(Calendar.YEAR);
		lunarBegin.lunarMonth = i;
		lunarBegin.lunarDay = i;
		long begin = lunar2Timestamp(lunarBegin);
		Lunar lunarEnd = new Lunar();
		lunarEnd.lunarYear = calendar.get(Calendar.YEAR) + 1;
		lunarEnd.lunarMonth = i;
		lunarEnd.lunarDay = i;
		// 一天86400秒
		long end = lunar2Timestamp(lunarEnd) - 86400;
		String percent = percent(now, end, begin);

		String sss = concat(percent.substring(0, percent.length() - 1));
		//返回数据 “今年过去了82% ░░░░░”
		String back =  "今年过去了"+percent+"\r\n"+sss;
		// 当前年的第几天,计算公历百分比要简单的多啊
		// int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		// Lunar lunar = LunarSolarConverter.SolarToLunar(solar);
		// System.out.println(b + h + hh + lunar.lunarYear + "-" + lunar.lunarMonth +
		// "-" + lunar.lunarDay);
		System.out.println(back);
		return back;
	}

	private static String concat(String percent) {
		String b = "░";
		String h = "▒";
		String hh = "▓";
		String sss = "";
		int a = (24 * Integer.parseInt(percent)) / 100;
		long ts = System.currentTimeMillis();
		for (int i = 1; i < a; i++) {
			hh = hh.concat("▓");

		}
		for (int i = 1; i < 24 - a; i++) {

			b = b.concat("░");
		}
		sss = hh + b;
		return sss;
	}

	/**
	 * @param a
	 *            现在的时间
	 * @param b
	 *            农历一年最后一天
	 * @param b
	 *            农历一年第一天
	 * 
	 */

	private static String percent(long a, long b, long c) {
		String baifenbi = "";
		double baia = a * 1.0;
		double baib = b * 1.0;
		double baic = c * 1.0;
		double fen = (baia - baic) / (baib - baic);
		DecimalFormat decimalFormat = new DecimalFormat("##%");
		baifenbi = decimalFormat.format(fen);
//		System.out.println(baifenbi);
		return baifenbi;
	}

	private static Solar lunar2Solar(Lunar lunar) {
		Solar solar = LunarSolarConverter.LunarToSolar(lunar);
		return solar;
	}

	private static Lunar solar2Lunar(Solar solar) {
		Lunar lunar = LunarSolarConverter.SolarToLunar(solar);
		return lunar;
	}

	private static String timestamp2Date(long timestamp) {
		String date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(timestamp * 1000));
		return date;
	}

	// yyyy/MM/dd HH:mm:ss
	private static long date2Timestamp(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return dateFormat.parse(date).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;

	}

	// yyyy/MM/dd HH:mm:ss
	private static long lunar2Timestamp(Lunar lunar) {
		String date = lunar.lunarYear + "/" + lunar.lunarMonth + "/" + lunar.lunarDay;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return dateFormat.parse(date).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * 取得当前时间戳（精确到秒）
	 * 
	 * @return
	 */
	public static long timeStamp() {
		long time = System.currentTimeMillis();
		// String t = String.valueOf(time / 1000);
		long t = time / 1000;
		return t;
	}

}
