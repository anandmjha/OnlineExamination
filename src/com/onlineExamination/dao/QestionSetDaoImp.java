package com.onlineExamination.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.onlineExamination.beans.QuestionSet;
import com.onlineExamination.util.DBUtil;

public class QestionSetDaoImp implements QuestionSetDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;

	@Override
	public int setQuestionPaper(int questionid, String question, String option1, String option2, String option3, String option4,
			int answer, int marks) {
		int isValid = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"Insert into questionset(questionId, question,option1,option2,option3,option4,answer,marks) value(?,?,?,?,?,?,?,?);");
			ps.setInt(1, questionid);
			ps.setString(2, question);
			ps.setString(3, option1);
			ps.setString(4, option2);
			ps.setString(5, option3);
			ps.setString(6, option4);
			ps.setInt(7, answer);
			ps.setInt(8, marks);
			System.out.println("type in QDI setquestionpaper ");
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

	@Override
	public QuestionSet getQuestionPaper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionSet> allQuestions() {
		System.out.println("Executing All question query");
		ArrayList<QuestionSet> questions=new ArrayList<QuestionSet>();
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement("select * from questionset;");
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionSet questionset = new QuestionSet(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7), rs.getInt(8));
				questions.add(questionset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		System.out.println(questions.toString());
		return questions;
	}

}
