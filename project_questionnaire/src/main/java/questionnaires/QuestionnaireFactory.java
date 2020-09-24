/**
 * 
 */
package questionnaires;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import questionnaires.answers.AnswerFactory;
import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public class QuestionnaireFactory {
	
	public static final QuestionnaireFactory FACTORY = new QuestionnaireFactory();
	
	private QuestionnaireFactory() {}
	/**
	 * Create a new instance of question
	 * @param text the text of the question 
	 * @param answerText the text of the answer
	 * @param answerType the type of the answer
	 * @param points the points of the question
	 * @return an instance of the question
	 * 
	 * @throws IOException
	 */
	private Question createQuestion(String text,String answerText,String answerType,String points) throws IOException {
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question(text, AnswerFactory.FACTORY.buildAnswer(answerType,answerText),nbPoints);
		}catch(NumberFormatException e) {
			throw new IOException("bad format");
		}
	}
	
	/**
	 * 
	 * @param fileName the file name
	 * @return a new instance of quiz with the question in the file name.
	 * @throws IOException
	 */
	public Questionnaire createQuestionnaire(String fileName) throws IOException{
		Questionnaire questionnaire;
		questionnaire = new Questionnaire();
		File source = new File(fileName);
		BufferedReader in = null;
		FileReader fileReader = new FileReader(source);
		try {
			in = new BufferedReader(fileReader);
			String text;
			//read block of 3 lines : text, answer and number of points
			while ((text = in.readLine()) != null) {
				String answerText = in.readLine();
				String nbPoints = in.readLine();
				String answerType = in.readLine();
				if(answerText == null || nbPoints == null || answerType == null) 
					throw new IOException("bad format");
				questionnaire.addQuestion(this.createQuestion(text, answerText,answerType, nbPoints));
			}
		}catch(FileNotFoundException e) {
			throw new IOException(e);
		}
		finally {
			in.close();
		}
		return questionnaire;
	}
	
}
