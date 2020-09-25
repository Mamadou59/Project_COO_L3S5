/**
 * 
 */
package questionnaires.answers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author diallo and fungwa
 *
 */
public class AnswerFactory {
	
	public static final AnswerFactory FACTORY = new AnswerFactory();
	
	private AnswerFactory() {}
	
	/**
	 * Build a good answer by string name.
	 * @param answerType a type of answer
	 * @param answerText answer text
	 * @return a new instance of answer.
	 */
	public Answers<?> buildAnswer(String answerType,String answerText){
		Answers<?> answer = null;
		String pkg = "questionnaires.answers";
		//On récupère l'objet Class pour la classe de nom answerType
		try {
			Class<?> c = Class.forName(pkg+"."+answerType);
			//On récupère pour cette classe le constructeur de signature XXX(String)
			try {
				Constructor<?> constructor = c.getConstructor(String.class);
				try {
					answer = (Answers<?>) constructor.newInstance(answerText);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return answer;
	}
	

}
