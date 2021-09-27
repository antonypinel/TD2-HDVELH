/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
	private String playerAnswer;
	private Scanner reader;
	private int chosenPath;
	private String id;
	private GUIManager gui;
	private Scanner inputReader;
	private String answer;
	int path;

	/** Constructors **/

	public Event(GUIManager gui) {
		this.gui = gui;
	}

	public Event(String data, String id) {
		super(data);
		this.id = id;
	}

	public Event() {
		this.gui = null;
	}

	/** Methods **/

	public String toString() {
		return "Event" + "#" + getId() + "(" + getClass().getSimpleName() + ");" + getData();
	}

	public boolean isFinal() {
		return this.hasDaughters();
	}

	public boolean isInRange(int index) {
		final int i = Integer.parseInt(String.valueOf(index)) + ERROR_STATUS_INDEX_OUT_OF_RANGE;
		if (i <= NODE_MAX_ARITY && i >= 0) return true;
		return false;
	}


	public int interpretAnswer() {
		reader = new Scanner(System.in);
		System.out.println(PROMPT_ANSWER);
		playerAnswer = reader.next();
		chosenPath = Integer.parseInt(playerAnswer) -1;
		return 0;
	}

	public Event run() {
		gui.outputln(getData());
		gui.outputln(PROMPT_ANSWER);
		inputReader = gui.getInputReader();
		setPlayerAnswer(inputReader.toString());
		path = Integer.valueOf(getPlayerAnswer());
		Event theDaughter = getDaughter(path);
		return theDaughter;
	}

	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return this.playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return this.reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return this.chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		this.chosenPath = chosenPath;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return this.getData().toString();
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		this.setData(data);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return this.getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		this.setDaughter(daughter, i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return this.gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.getId();
	}
}

// eof