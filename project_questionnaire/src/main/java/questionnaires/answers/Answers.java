/**
 * 
 */
package questionnaires.answers;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;



/**
 * @author diallo and fungwa
 *
 */
public abstract class Answers<T> {
	
	protected T goodAnswer;
	
	// A panel of the answer
	protected JPanel answerPanel;
	
	public Answers() {
		this.answerPanel = new JPanel();
		this.answerPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN,EtchedBorder.LOWERED));
		//this.answerPanel.setMaximumSize(new Dimension(10,20));
		//this.answerPanel.setBounds(0, 0,10,10);
	}
	// pour conserver la saisie de l'utilisateur (lors de l'interface grahique) 
	protected String userAnswer = "";
	
	/**
	 * @return the goodAnswer
	 */
	public T getGoodAnswer() {
		return goodAnswer;
	}
	
	
	/**
	 * @return the answerPanel
	 */
	public JPanel getAnswerPanel() {
		return answerPanel;
	}

	/**
	 *  check the answer.
	 * @param answer the answer to check.
	 * @return <em>true</em> if the answer is correct and <em>false</em> if not.  
	 */
	public abstract boolean checkAnswer(String answer);
	
	/**
	 * check the answer type
	 * @param answer the answer to check
	 * @return <em>true</em> if the answer type is correct and <em>false</em> if not
	 */
	public abstract boolean checkType(String answer);
	
	/**
	 * @return the answer type. 
	 */
	public abstract String getType();
	
	/**
	 * @return the userAnswer
	 */
	public String getUserAnswer() {
		return userAnswer;
	}


	/**
	 * 
	 * @return an answer panel create
	 */
	public abstract JPanel creatPanel();
	
	//public abstract void setUserAnswer();
}
