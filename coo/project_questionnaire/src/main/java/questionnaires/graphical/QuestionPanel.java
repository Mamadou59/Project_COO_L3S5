/**
 * 
 */
package questionnaires.graphical;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public class QuestionPanel {
	private JLabel text;
	private JPanel answer;
	protected Question question;
	private JPanel quesPanel;
	
	public QuestionPanel(Question q) {
		this.quesPanel = new JPanel();
		this.question = q;
		this.text = new JLabel(q.toString());
		this.answer = q.getAnswer().creatPanel();
		manageQuestionPanel();
	}

	/**
	 * Manage the question panel
	 */
	private void manageQuestionPanel() {
		this.quesPanel.setLayout(new GridLayout(2,1));
		this.quesPanel.add(text);
		this.quesPanel.add(answer);
		this.quesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,EtchedBorder.LOWERED));
	}
	
	public String getUserAnswer() {
		return this.question.getAnswer().getUserAnswer();
	}
	public int checkAnswerAndGiveNbPoint() {
		if (question.checkAnswer(getUserAnswer()))
			return question.getPoint();
		return 0;
	}

	/**
	 * @return the quesPanel
	 */
	public JPanel getQuesPanel() {
		return quesPanel;
	}
	
	
}
