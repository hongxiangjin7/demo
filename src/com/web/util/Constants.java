package com.web.util;

import java.util.Date;

public class Constants {
	
	/***************** system *****************/
	public static String DB_NAME = "oracle";
	public static String MESSAGE = "message";
	
	/***************** session key *****************/
    public static final String CURRENT_USER = "user";
    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
    
	/***************** default password (123456) *****************/
	public static final String DEFAULT_PASSWORD = "14e1b600b1fd579f47433b88e8d85291";
	
	public static long SYSY_INIT_TIME = new Date().getTime();
}
