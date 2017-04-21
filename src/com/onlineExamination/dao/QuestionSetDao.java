package com.onlineExamination.dao;

import java.util.ArrayList;

import com.onlineExamination.beans.QuestionSet;

public interface QuestionSetDao {
	public int setQuestionPaper(int questionid, String question, String option1, String option2, String option3, String option4, int answer, int marks);
	public QuestionSet getQuestionPaper();
	public ArrayList<QuestionSet> allQuestions();
}
