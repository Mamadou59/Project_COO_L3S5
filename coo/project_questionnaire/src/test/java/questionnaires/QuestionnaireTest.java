package questionnaires;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import questionnaires.display.InterfaceDisplay;
import questionnaires.question.Question;
import questionnaires.scanner.MockScanner;

public class QuestionnaireTest {
	
	private Questionnaire questionnaire;
	private MockQuestion questionMock;
	private MockInterface mockInterface;
	private MockAnswer mockAnswer;
	private MockScanner mockScanner;
	@Before
	public void init() {
		this.mockAnswer = new MockAnswer();
		this.questionMock = new MockQuestion(mockAnswer);
		this.questionnaire = new Questionnaire();
		this.questionnaire.addQuestion(questionMock);
		this.mockScanner = new MockScanner();
		//this.questionnaire.changeUsedScanner(this.mockScanner);
		this.mockInterface = new MockInterface();
		this.questionnaire.interfaceDisplayer = this.mockInterface; 
		//this.questionnaire.changeInterfaceDisplayer(mockInterface);
	}

	@Test
	public void testAskOne() {
		//before calling askOne all of those method are not called.
		assertEquals(0,this.mockInterface.displayQTextCalls);
		assertEquals(0,this.mockInterface.displayTypeCalls);
		assertEquals(0,this.mockAnswer.getCheckTypeCalls());
		assertEquals(0,this.mockScanner.getReadStringCalls());
		this.questionnaire.askOne(questionMock);
		//but after calling ankOne
		// displayQuestionText is called once
		assertEquals(1,this.mockInterface.displayQTextCalls);
		// displayType is called four times
		assertEquals(4,this.mockInterface.displayTypeCalls);
		// checkType an Answer is called four times too.
		assertEquals(4,this.mockAnswer.getCheckTypeCalls());		
		
	}
	
	class MockInterface implements InterfaceDisplay{
		
		protected int displayQTextCalls = 0;
		protected int displayTypeCalls = 0;
		
		public MockInterface() {
			super();
		}
		
		
		public void displayQuestionText(Question q) {this.displayQTextCalls++;}
		/**
		 * @param q the question to display
		 */
		public void displayType(Question q) {this.displayTypeCalls++;}


		@Override
		public void displayStart(AbstractQuestionnaire questionnaire) {}


		@Override
		public void displayScore(int score) {}


		@Override
		public void displayCorrectAnswer(Question q) {}


		@Override
		public void displayIncorrectAnswer(Question q) {}


		@Override
		public String getInput() {return "";}


		
		
	}

}
