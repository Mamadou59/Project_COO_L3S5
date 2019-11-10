/**
 * 
 */
package questionnaires;

import questionnaires.answers.*;
import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Questionnaire quest = new Questionnaire();
		
		NumericAnswer aNum = new NumericAnswer(21);
		TextAnswer aText = new TextAnswer("neuf");
		YesNoAnswer aY = new YesNoAnswer("oui");
		YesNoAnswer aN = new YesNoAnswer("non");
		
		Question qNum = new Question("3 x 7 vaut",aNum,2);
		quest.addQuestion(qNum);
		Question qText = new Question("3 x 3 vaut (ecrit en lettre)",aText,4);
		quest.addQuestion(qText);
		Question qY = new Question("java est un langage",aY,5);
		quest.addQuestion(qY);
		Question qN = new Question("3 x 7 = 20",aN,2);
		quest.addQuestion(qN);
		
		quest.askAll();
		
		
	}

}
