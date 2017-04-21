/**
 * 
 */
package com.onlineExamination.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.onlineExamination.beans.Member;
import com.onlineExamination.util.DBUtil;

/**
 * @author Archiee
 *
 */
public class MemberDaoImp implements MemberDao {
	Member mb = new Member();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	ArrayList<Member> al;
	boolean isReflected = false;

	/*
	 * 
	 * This method is used to register the user to the online examination portal
	 * 
	 * 
	 */
	@Override
	public int RegisterUser(String email, String name, String type, String password) {
		int isValid = 0;
		String validationcode = mb.getValidationcode();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("Insert into member(email,name,type,password,validationcode) value(?,?,?,?,?);");
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, type);
			ps.setString(4, password);
			ps.setString(5, validationcode);
			System.out.println("type in mdi register = " + type);
			if (ps.executeUpdate() == 1) {
				isValid = 1;
			}

		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Duplicate User Entry");
			isValid = 2;
			return isValid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isValid;
	}

	/*
	 * 
	 * This method is used to user authentication
	 * 
	 */
	@Override
	public boolean validateMember(String username, String password) {
		boolean isValid = false;
		System.out.println("in memberdaoimp validate funciton");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where email=? and password=?");
			System.out.println(username);
			System.out.println(password);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			isValid = rs.next();
			System.out.println("validate working fine" + isValid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isValid;
	}

	/*
	 * 
	 * This method is used to get the information from member table and return
	 * the member details to user
	 * 
	 */
	@Override
	public Member getMemberData(String username) {
		Member member = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where email=?;");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setEmail(rs.getString(1));
				member.setName(rs.getString(2));
				member.setType(rs.getString(3));
				member.setPassword(rs.getString(4));
				member.setValidationcode(rs.getString(5));
				member.setAuthentication(rs.getInt(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

}
