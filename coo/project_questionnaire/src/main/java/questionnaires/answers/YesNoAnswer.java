/**
 * 
 */
package questionnaires.answers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author diallo and fungwa
 *
 */
public class YesNoAnswer extends Answers<Boolean> {
	
	public static Map<String,Boolean> possibleAnswer;
	
	protected ButtonGroup bG;
	protected JRadioButton yesB;
	protected JRadioButton noB;
	
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
		answer = answer.toLowerCase();
		if(checkType(answer))
			return possibleAnswer.get(answer).equals(this.goodAnswer);
		return false;
	}

	@Override
	public boolean checkType(String answer) {
		answer = answer.toLowerCase();
		return possibleAnswer.containsKey(answer);
	}

	@Override
	public String getType() {
		return "(yes/no)/(vrai/faux)/(oui/non)/(true/false)";
	}

	@Override
	public JPanel creatPanel() {
		this.bG = new ButtonGroup();
		this.yesB = new JRadioButton("Yes");
		this.noB = new JRadioButton("No");
		this.bG.add(this.noB);
		this.bG.add(yesB);
		this.answerPanel.setLayout(new GridLayout(2,1));
		this.answerPanel.add(this.yesB);
		this.answerPanel.add(noB);
		//J'abonne mes deux bouton
		this.yesB.addActionListener(new YesNoActionListener());
		this.noB.addActionListener(new YesNoActionListener());
		return this.answerPanel;
	}
	
	
	public class YesNoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userAnswer = e.getActionCommand();
		}
		
	}

}
