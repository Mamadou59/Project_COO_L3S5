/**
 * 
 */
package questionnaires.answers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanoussy
 *
 */
public class YesNoAnswer extends Answers<Boolean> {
	
	public static Map<String,Boolean> possibleAnswer;
	
	public YesNoAnswer(String answer) {
		this.addPosibleAnswers();
		Boolean ansBool = possibleAnswer.get(answer);
		this.goodAnswer = ansBool;
		
	}
	
	private void addPosibleAnswers() {
		possibleAnswer = new HashMap<String,Boolean>();
		possibleAnswer.put("oui",true);
		possibleAnswer.put("vrai",true);
		possibleAnswer.put("true",true);
		possibleAnswer.put("yes",true);
		
		possibleAnswer.put("non",false);
		possibleAnswer.put("faux",false);
		possibleAnswer.put("false",false);
		possibleAnswer.put("no",false);

	}
	@Override
	public boolean checkAnswer(String answer) {
		return possibleAnswer.get(answer).equals(this.goodAnswer);
	}

	@Override
	public boolean checkType(String answer) {
		return possibleAnswer.containsKey(answer);
	}

	@Override
	public String getType() {
		return "(yes/no)/(vrai/faux)/(oui/non)/(true/false)";
	}

}
