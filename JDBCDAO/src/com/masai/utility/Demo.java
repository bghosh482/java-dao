package com.masai.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		
		
		Connection conn =  DBUtil.providedConnection();
		System.out.println(conn);

	}

}
