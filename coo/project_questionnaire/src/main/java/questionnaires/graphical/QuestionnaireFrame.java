/**
 * 
 */
package questionnaires.graphical;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import questionnaires.question.Question;

/**
 * @author diallo and fungwa
 *
 */
public class QuestionnaireFrame{
	
	private JFrame theFrame;
	private JButton validateButton;
	private List<Question> questions;
	private List<QuestionPanel> questionsPanel;
	
	public static int MAX_SCORE;
	
	public QuestionnaireFrame(List<Question> questions) {
		this.theFrame = new JFrame("Quiz");
		this.theFrame.setLocation(200,200);
		//this.theFrame.setSize(1100, 400);
		//this.theFrame.setResizable(false);
		this.theFrame.addWindowListener(new CloseWindowEvent());
		this.questions = questions;
		this.questionsPanel = new ArrayList<QuestionPanel>();
		this.theFrame.add(manegeQuestionContainer());
		this.theFrame.pack();
		this.validateButton = new JButton("I have finished");
		//this.validateButton.setBounds(10, 10, 10, 8);
		//Abonner le button de validation
		this.validateButton.addActionListener(new ValidateActionListener());
		this.theFrame.add(this.validateButton, BorderLayout.SOUTH);
	}
	
	private Container manegeQuestionContainer() {
		
		Container container = new JPanel();
		container.setLayout(new GridLayout(this.questions.size(),1));
		QuestionPanel qP;
		for(Question q: this.questions) {
			MAX_SCORE += q.getPoint();
			qP = new QuestionPanel(q);
			this.questionsPanel.add(qP);
			container.add(qP.getQuesPanel());
		}
		
		return new JScrollPane(container);
	}

	/**
	 * @return the theFrame
	 */
	public JFrame getTheFrame() {
		return theFrame;
	}
	
	private int giveScore() {
		int score = 0;
		int points;
		for(QuestionPanel qP:this.questionsPanel) {
			points = qP.checkAnswerAndGiveNbPoint();
			score += points;
			if (points != 0)
				this.questions.remove(qP.question);
		}
		return score;
	}
	
	private String giveDisplayErrors(int n) {
		String res = "";
		if (n == this.questionsPanel.size())
			res = "You missed all questions\n\n";
		else
			res = "You missed "+n+" questions\n\n";
			 
		for(Question q:this.questions) {
			res += q.toString()+ "\n ==> Ans: " +  q.getAnswer().getGoodAnswer()+"\n";
		}
		return res;
	}

	private class ValidateActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int score = giveScore();
			if (questions.size() > 0) {
				JOptionPane.showMessageDialog(theFrame, giveDisplayErrors(questions.size()),"Errors",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(theFrame,"Congratulation you answered all the questions");
			}
			JOptionPane.showMessageDialog(theFrame, "Your score is => "+score+" / "+MAX_SCORE);
			
			theFrame.dispose();
		}
		
	}
	// pour gérer la fermeture de l'application lorsuq'on ferme une fenêtre
	// ----------------------------------------------------------------------
	private class CloseWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
}
