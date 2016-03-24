package cn.edu.mcu.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.edu.mcu.bean.Account;

public class CookieUtil {
	public static List<Cookie> addCookie(Account account) {
		Cookie cookieAccount = new Cookie("account", account.getAccount());
		Cookie cookiePassword = new Cookie("password", account.getPassword());
		cookieAccount.setMaxAge(60 * 60 * 24 * 14);
		cookiePassword.setMaxAge(60 * 60 * 24 * 14);
		cookieAccount.setPath("/");
		cookiePassword.setPath("/");

		List<Cookie> list = new ArrayList<Cookie>();
		list.add(cookieAccount);
		list.add(cookiePassword);
		return list;
	}

	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					String value = cookie.getValue();
					return value;
				}
			}
		}

		return null;
	}
}
