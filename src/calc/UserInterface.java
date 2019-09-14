package calc;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserInterface extends JFrame{
	
	private JTextField field = new JTextField(20);
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton button0 = new JButton("0");
	private JButton buttonplus = new JButton("+");
	private JButton buttonminus = new JButton("-");
	private JButton buttonmult = new JButton("*");
	private JButton buttondelim = new JButton("/");
	private JButton buttonbracketopen = new JButton("(");
	private JButton buttonbracketclose = new JButton(")");
	private JButton buttoncolon = new JButton(":");
	private JButton buttonquestion = new JButton("?");
	private JButton buttonequal = new JButton("=");
	private JButton buttondot = new JButton("."); // for float
	private JButton buttonclear = new JButton("c");
	private JButton buttonback = new JButton("<-");
	
	public UserInterface() {
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculator");
		setVisible(true);
		
		Container container = this.getContentPane();
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);
		
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.anchor = GridBagConstraints.NORTH;
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.gridheight = 1;
		layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
		layoutConstraints.gridx = GridBagConstraints.RELATIVE;
		layoutConstraints.gridy = GridBagConstraints.RELATIVE;
		layoutConstraints.insets = new Insets(20, 0, 10, 0);
		layoutConstraints.ipadx = 0;
		layoutConstraints.ipady = 0;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		
		// text field fills full width
		field.setPreferredSize(new Dimension(200,20));
		field.setMinimumSize(new Dimension(100,20));
		layout.setConstraints(field, layoutConstraints);
		container.add(field);
		
		// buttons actions
		button0.setActionCommand(button0.getText());
		button0.addActionListener(new ButtonEventListener());
		button1.setActionCommand(button1.getText());
		button1.addActionListener(new ButtonEventListener());
		button2.setActionCommand(button2.getText());
		button2.addActionListener(new ButtonEventListener());
		button3.setActionCommand(button3.getText());
		button3.addActionListener(new ButtonEventListener());
		button4.setActionCommand(button4.getText());
		button4.addActionListener(new ButtonEventListener());
		button5.setActionCommand(button5.getText());
		button5.addActionListener(new ButtonEventListener());
		button6.setActionCommand(button6.getText());
		button6.addActionListener(new ButtonEventListener());
		button7.setActionCommand(button7.getText());
		button7.addActionListener(new ButtonEventListener());
		button8.setActionCommand(button8.getText());
		button8.addActionListener(new ButtonEventListener());
		button9.setActionCommand(button9.getText());
		button9.addActionListener(new ButtonEventListener());
		buttonplus.setActionCommand(buttonplus.getText());
		buttonplus.addActionListener(new ButtonEventListener());
		buttonminus.setActionCommand(buttonminus.getText());
		buttonminus.addActionListener(new ButtonEventListener());
		buttonmult.setActionCommand(buttonmult.getText());
		buttonmult.addActionListener(new ButtonEventListener());
		buttondelim.setActionCommand(buttondelim.getText());
		buttondelim.addActionListener(new ButtonEventListener());
		buttondot.setActionCommand(buttondot.getText());
		buttondot.addActionListener(new ButtonEventListener());
		buttoncolon.setActionCommand(buttoncolon.getText());
		buttoncolon.addActionListener(new ButtonEventListener());
		buttonquestion.setActionCommand(buttonquestion.getText());
		buttonquestion.addActionListener(new ButtonEventListener());
		buttonbracketopen.setActionCommand(buttonbracketopen.getText());
		buttonbracketopen.addActionListener(new ButtonEventListener());
		buttonbracketclose.setActionCommand(buttonbracketclose.getText());
		buttonbracketclose.addActionListener(new ButtonEventListener());
		buttonequal.addActionListener(new ButtonEventListenerEqual());
		buttonclear.setActionCommand(buttonclear.getText());
		buttonclear.addActionListener(new ButtonEventListenerClean());
		buttonback.setActionCommand(buttonback.getText());
		buttonback.addActionListener(new ButtonEventListenerClean());;
		
		// first raw
		layoutConstraints.insets = new Insets(4, 4, 0, 0);
		layoutConstraints.gridwidth = 1;
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layout.setConstraints(button7, layoutConstraints);
		container.add(button7);
		layout.setConstraints(button8, layoutConstraints);
		container.add(button8);
		layout.setConstraints(button9, layoutConstraints);
		container.add(button9);
		layout.setConstraints(buttonplus,layoutConstraints);
		container.add(buttonplus);
		layoutConstraints.gridwidth = GridBagConstraints.REMAINDER; 		// for the last button in a raw
		layout.setConstraints(buttonminus, layoutConstraints);
		container.add(buttonminus);

		//second raw 
		layoutConstraints.gridwidth =1;
		layout.setConstraints(button4, layoutConstraints);
		container.add(button4);
		layout.setConstraints(button5, layoutConstraints);
		container.add(button5);
		layout.setConstraints(button6, layoutConstraints);
		container.add(button6);
		layout.setConstraints(buttonmult, layoutConstraints);
		container.add(buttonmult);
		layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(buttondelim, layoutConstraints);
		container.add(buttondelim);

		// third raw
		layoutConstraints.gridwidth =1;
		layout.setConstraints(button1, layoutConstraints);
		container.add(button1);
		layout.setConstraints(button2, layoutConstraints);
		container.add(button2);
		layout.setConstraints(button3, layoutConstraints);
		container.add(button3);
		layout.setConstraints(buttonbracketopen, layoutConstraints);
		container.add(buttonbracketopen);
		layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(buttonbracketclose, layoutConstraints);
		container.add(buttonbracketclose);
	
		// fourth raw
		layoutConstraints.gridwidth =1;
		layout.setConstraints(button0, layoutConstraints);
		container.add(button0);
		layoutConstraints.gridwidth =1;
		layout.setConstraints(buttondot, layoutConstraints);
		container.add(buttondot);
		layout.setConstraints(buttonequal, layoutConstraints);
		container.add(buttonequal);
		// service buttons
		layout.setConstraints(buttonclear, layoutConstraints);
		container.add(buttonclear);
		layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(buttonback, layoutConstraints);
		container.add(buttonback);
		
	}

	String getRes(String s) {
		InputLineParser parser = new InputLineParser(s);
		Float r = parser.getResult();
		return r.toString();
	}
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = ((JButton) e.getSource()).getActionCommand();
			field.setText(field.getText() + s);
		}
	}
	class ButtonEventListenerEqual implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String s=field.getText();				
				if (s.equals("")||s==null) JOptionPane.showMessageDialog(null, "¬ведите выражение дл€ вычислени€.");
				else {
	 				try{ 	
						String res = getRes(s);
						field.setText(res);
					} catch (NoSuchElementException ex) {
						JOptionPane.showMessageDialog(null, "Ќедопустимое выражение дл€ вычислени€!");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "¬ыражение не должно содержать букв и недопустимых операторов");
					}
				}
			}
	}
	class ButtonEventListenerClean implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getActionCommand();
			if(command.equals(buttonclear.getText())) { // удалить все содержимое
				field.setText(null);
				}
			if(command.equals(buttonback.getText())) { // удалить последний символ
				String s = field.getText();
				String temp="";
				for(int i=0;i<s.length()-1;i++) {
					temp+=s.charAt(i);
					}
				field.setText(temp);
				}			
		}
	}
}
