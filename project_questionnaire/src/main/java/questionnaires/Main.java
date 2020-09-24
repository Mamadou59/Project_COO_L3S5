/**
 * 
 */
package questionnaires;

import java.io.IOException;

import questionnaires.graphical.QuestionnaireFrame;


/**
 * @author diallo and fungwa
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Questionnaire quest;
		try {
			quest = QuestionnaireFactory.FACTORY.createQuestionnaire("question_tolkien_2.txt");
			if (args.length == 0) {
				QuestionnaireFrame qFrame = new QuestionnaireFrame(quest.getQuestions());
				qFrame.getTheFrame().setVisible(true);
			}
			else if (Integer.parseInt(args[0]) == 1) {
				QuestionnaireFrame qFrame = new QuestionnaireFrame(quest.getQuestions());
				qFrame.getTheFrame().setVisible(true);
			}
			else if (Integer.parseInt(args[0]) == 2) {
				quest.askAll();
			}
				
				
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
