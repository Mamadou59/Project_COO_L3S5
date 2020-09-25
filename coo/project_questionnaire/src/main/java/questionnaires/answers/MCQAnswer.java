/**
 * 
 */
package questionnaires.answers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author diallo and fungwa
 *
 */
public class MCQAnswer extends Answers<String> {
	
	private Set<String> EnsAnswers;

	public MCQAnswer(String goodAnswers) {
		String[] GASplited = goodAnswers.split("\\|");
		this.EnsAnswers = new HashSet<String>();
		for(String ans: GASplited) {
			ans = ans.trim();
			this.EnsAnswers.add(ans);
		}
		this.goodAnswer = GASplited[0].trim();
		
		
	}

	@Override
	public boolean checkAnswer(String answer) {
		return this.goodAnswer.equals(answer);
	}

	@Override
	public boolean checkType(String answer) {
		return this.EnsAnswers.contains(answer);
	}

	@Override
	public String getType() {
		String res = "(";
		for(String s: this.EnsAnswers) {
			res = res + s+" ";
		}
		return res.substring(0, res.length()-1) + ")";
	}

	@Override
	public JPanel creatPanel() {
		ButtonGroup bG = new ButtonGroup();
		this.answerPanel.setLayout(new GridLayout(2,1));
		JRadioButton b;
		for(String choice: EnsAnswers) {
			b = new JRadioButton(choice);
			bG.add(b);
			//Abonner chaque boutton
			b.addActionListener(new MCQActionListener());
			this.answerPanel.add(b);
		}
		return this.answerPanel;
	}
	
	private class MCQActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userAnswer = e.getActionCommand();
			
		}
		
	}

}
