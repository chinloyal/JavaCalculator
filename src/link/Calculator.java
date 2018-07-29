package link;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JTextField;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Calculator extends JFrame{

	private JPanel contentPane;
	private JTextField displayField;
	private JButton btnC;
	private JButton btnF;
	private JButton btnM;
	private JButton btnB;
	private JButton btnEqual;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnTimes;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnDivide;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton btnPlus;
	private JButton btn0;
	private JButton btnPoint;
	private JButton btnMinus;
	private JButton btnPlusOrMinus;
	private JTextField postfixDisplayField;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmViewUserManual;
	private JLabel lblPostfixExpression;

	public Calculator() {
		//Design starts here
		super("HP-35 Calculator Advanced");
		setFocusable(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 352);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmViewUserManual = new JMenuItem("View User Manual           F1");
		mnHelp.add(mntmViewUserManual);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[77.00px,grow][65.00px][65.00px][39px][]", "[23px][][][][][grow][][][][][][][]"));
		
		btn7 = new JButton("7");
		btn7.setFocusable(false);
		btn7.setBackground(SystemColor.activeCaption);
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn7.setPreferredSize(new Dimension(65, 23));
		
		lblPostfixExpression = new JLabel("Postfix Expression");
		lblPostfixExpression.setForeground(Color.WHITE);
		contentPane.add(lblPostfixExpression, "cell 0 3 5 1,alignx right");
		
		postfixDisplayField = new JTextField();
		postfixDisplayField.setPreferredSize(new Dimension(70, 40));
		postfixDisplayField.setOpaque(true);
		postfixDisplayField.setHorizontalAlignment(SwingConstants.RIGHT);
		postfixDisplayField.setForeground(new Color(255, 255, 224));
		postfixDisplayField.setFont(new Font("Roboto", Font.BOLD, 20));
		postfixDisplayField.setEnabled(false);
		postfixDisplayField.setEditable(false);
		postfixDisplayField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		postfixDisplayField.setColumns(10);
		postfixDisplayField.setBackground(new Color(47, 79, 79));
		contentPane.add(postfixDisplayField, "cell 0 5 5 1,growx");
		
		displayField = new JTextField();
		displayField.setEnabled(false);
		displayField.setBackground(new Color(47, 79, 79));
		displayField.setForeground(new Color(255, 255, 224));
		displayField.setOpaque(true);
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayField.setFont(new Font("Roboto", Font.BOLD, 20));
		displayField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		displayField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		displayField.setEditable(false);
		displayField.setPreferredSize(new Dimension(70, 40));
		contentPane.add(displayField, "cell 0 7 5 1,growx,aligny center");
		displayField.setColumns(10);
		
		btnC = new JButton("C");
		btnC.setFocusable(false);
		btnC.setToolTipText("Clear Memory");
		btnC.setBackground(SystemColor.activeCaption);
		btnC.setForeground(new Color(255, 255, 255));
		btnC.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnC.setPreferredSize(new Dimension(65, 28));
		contentPane.add(btnC, "cell 0 8");
		
		btnF = new JButton("F");
		btnF.setFocusable(false);
		btnF.setToolTipText("Store to File");
		btnF.setBackground(SystemColor.activeCaption);
		btnF.setForeground(new Color(255, 255, 255));
		btnF.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnF.setPreferredSize(new Dimension(65, 28));
		contentPane.add(btnF, "cell 1 8");
		
		btnM = new JButton("M");
		btnM.setFocusable(false);
		btnM.setToolTipText("Memory");
		btnM.setBackground(SystemColor.activeCaption);
		btnM.setForeground(new Color(255, 255, 255));
		btnM.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnM.setPreferredSize(new Dimension(65, 28));
		contentPane.add(btnM, "cell 2 8");
		
		btnB = new JButton("B");
		btnB.setFocusable(false);
		btnB.setToolTipText("Backspace");
		btnB.setBackground(SystemColor.activeCaption);
		btnB.setForeground(new Color(255, 255, 255));
		btnB.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		contentPane.add(btnB, "cell 3 8");
		
		btnPlusOrMinus = new JButton("+/-");
		btnPlusOrMinus.setFocusable(false);
		btnPlusOrMinus.setToolTipText("Negate");
		btnPlusOrMinus.setBackground(SystemColor.activeCaption);
		btnPlusOrMinus.setForeground(new Color(255, 255, 255));
		btnPlusOrMinus.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnPlusOrMinus.setPreferredSize(new Dimension(35, 60));
		contentPane.add(btnPlusOrMinus, "cell 4 8 1 2");
		
		btnEqual = new JButton("=");
		btnEqual.setFocusable(false);
		btnEqual.setBackground(SystemColor.textHighlight);
		btnEqual.setForeground(new Color(255, 255, 255));
		btnEqual.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnEqual.setPreferredSize(new Dimension(50, 95));
		contentPane.add(btnEqual, "cell 4 10 1 3");
		contentPane.add(btn7, "cell 0 9,alignx left,aligny center");
		
		btn8 = new JButton("8");
		btn8.setFocusable(false);
		btn8.setBackground(SystemColor.activeCaption);
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn8.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn8, "cell 1 9,alignx left,aligny center");
		
		btn9 = new JButton("9");
		btn9.setFocusable(false);
		btn9.setBackground(SystemColor.activeCaption);
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn9.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn9, "cell 2 9,alignx left,aligny center");
		
		btnTimes = new JButton("*");
		btnTimes.setFocusable(false);
		btnTimes.setToolTipText("Multiply");
		btnTimes.setBackground(SystemColor.activeCaption);
		btnTimes.setForeground(new Color(255, 255, 255));
		btnTimes.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnTimes.setPreferredSize(new Dimension(35, 28));
		contentPane.add(btnTimes, "cell 3 9");
		
		btn4 = new JButton("4");
		btn4.setFocusable(false);
		btn4.setBackground(SystemColor.activeCaption);
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn4.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn4, "cell 0 10");
		
		btn5 = new JButton("5");
		btn5.setFocusable(false);
		btn5.setBackground(SystemColor.activeCaption);
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn5.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn5, "cell 1 10");
		
		btn6 = new JButton("6");
		btn6.setFocusable(false);
		btn6.setBackground(SystemColor.activeCaption);
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn6.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn6, "cell 2 10,alignx left,aligny center");
		
		btnDivide = new JButton("/");
		btnDivide.setFocusable(false);
		btnDivide.setToolTipText("Divide");
		btnDivide.setBackground(SystemColor.activeCaption);
		btnDivide.setForeground(new Color(255, 255, 255));
		btnDivide.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnDivide.setPreferredSize(new Dimension(35, 28));
		contentPane.add(btnDivide, "cell 3 10");
		
		btn3 = new JButton("3");
		btn3.setFocusable(false);
		btn3.setBackground(SystemColor.activeCaption);
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn3.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn3, "cell 0 11");
		
		btn2 = new JButton("2");
		btn2.setFocusable(false);
		btn2.setBackground(SystemColor.activeCaption);
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn2.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn2, "cell 1 11");
		
		btn1 = new JButton("1");
		btn1.setFocusable(false);
		btn1.setBackground(SystemColor.activeCaption);
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn1.setPreferredSize(new Dimension(65, 23));
		contentPane.add(btn1, "cell 2 11");
		
		btnPlus = new JButton("+");
		btnPlus.setFocusable(false);
		btnPlus.setToolTipText("Plus");
		btnPlus.setBackground(SystemColor.activeCaption);
		btnPlus.setForeground(new Color(255, 255, 255));
		btnPlus.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		contentPane.add(btnPlus, "cell 3 11");
		
		btn0 = new JButton("0");
		btn0.setFocusable(false);
		btn0.setBackground(SystemColor.activeCaption);
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btn0.setPreferredSize(new Dimension(134, 28));
		contentPane.add(btn0, "cell 0 12 2 1");
		
		btnPoint = new JButton(".");
		btnPoint.setFocusable(false);
		btnPoint.setBackground(SystemColor.activeCaption);
		btnPoint.setForeground(new Color(255, 255, 255));
		btnPoint.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnPoint.setPreferredSize(new Dimension(65, 28));
		contentPane.add(btnPoint, "cell 2 12");
		
		btnMinus = new JButton("-");
		btnMinus.setFocusable(false);
		btnMinus.setToolTipText("Minus");
		btnMinus.setBackground(SystemColor.activeCaption);
		btnMinus.setForeground(new Color(255, 255, 255));
		btnMinus.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		contentPane.add(btnMinus, "cell 3 12");
		
		//Design ends here
		
		//Events and more
		KeyHandler h = new KeyHandler();
		for(Component comp : contentPane.getComponents()){
			if(comp instanceof JButton){
				((JButton) comp).addActionListener(h);
			}
		}
		mntmViewUserManual.addActionListener(h);
		contentPane.getParent().setFocusable(true);
		contentPane.getParent().addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(!e.isShiftDown()){
					switch(e.getKeyCode()){
					case KeyEvent.VK_0:
						btn0.doClick();
						break;
					case KeyEvent.VK_1:
						btn1.doClick();
						break;
					case KeyEvent.VK_2:
						btn2.doClick();
						break;
					case KeyEvent.VK_3:
						btn3.doClick();
						break;
					case KeyEvent.VK_4:
						btn4.doClick();
						break;
					case KeyEvent.VK_5:
						btn5.doClick();
						break;
					case KeyEvent.VK_6:
						btn6.doClick();
						break;
					case KeyEvent.VK_7:
						btn7.doClick();
						break;
					case KeyEvent.VK_8:
						btn8.doClick();
						break;
					case KeyEvent.VK_9:
						btn9.doClick();
						break;
					case KeyEvent.VK_C:
						btnC.doClick();
						break;
					case KeyEvent.VK_F:
						btnF.doClick();
						break;
					case KeyEvent.VK_M:
						btnM.doClick();
						break;
					case KeyEvent.VK_BACK_SPACE: case KeyEvent.VK_B:
						btnB.doClick();
						break;
					case KeyEvent.VK_MINUS:
						btnMinus.doClick();
						break;
					case KeyEvent.VK_SLASH:
						btnDivide.doClick();
						break;
					case KeyEvent.VK_ENTER: case KeyEvent.VK_EQUALS:
						btnEqual.doClick();
						break;
					case KeyEvent.VK_SPACE:
						btnPlusOrMinus.doClick();
						break;
					case KeyEvent.VK_PERIOD:
						btnPoint.doClick();
						break;
					case KeyEvent.VK_F1:
						mntmViewUserManual.doClick();
						break;
					default:
						break;
					}
				}
				
				if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_8)
					btnTimes.doClick();
				
				if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_EQUALS)
					btnPlus.doClick();
				
			}

			//The methods have to be inplemented;
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
			
		});
		
	}
	
	//All key actions are handled in the key handler class
	private class KeyHandler implements ActionListener{
		private StringBuilder expression;
		private Queue expressionQueue;
		private Stack pointMem;//as in decimal
		private Stack negativeMem;
		private boolean expressionEvaluated;
		
		public KeyHandler(){
			expression = new StringBuilder();
			expressionQueue = new Queue();
			pointMem = new Stack();
			negativeMem = new Stack();
			expressionEvaluated = false;
		}
		
		public void actionPerformed(ActionEvent event) {
			for(Component comp : getContentPane().getComponents()){//Grab all components in frame
				if(comp instanceof JButton){//filter only buttons
					if(event.getSource() == ((JButton) comp)){//check source for buttons being added to the expression
						if(isNumeric(((JButton) comp).getText()) || isSign(((JButton) comp).getText()) || ((JButton) comp).getText() == "."){
							reset();
							addToExpression(expression, ((JButton) comp).getText());
							break;
						}
					}
				}
			}
/* 1. */	//PLUS OR MINUS BUTTON CODE
			if(event.getSource() == btnPlusOrMinus){
				negate();
			}
			
/* 2. */	//BACKSPACE BUTTON CODE
			if(event.getSource() == btnB){
				backspace();
			}
			
			
/* 3. */	//EQUAL BUTTON CODE
			if(event.getSource() == btnEqual){
				calculate();
			}
/* 4. */ 	//CLEAR BUTTON CODE
			if(event.getSource() == btnC){
				reset();
				expression = new StringBuilder("");
				postfixDisplayField.setText("");
				pointMem.destroy();
				negativeMem.destroy();
			}

/* 5. */	//FILE STORAGE BUTTON CODE
			if(event.getSource() == btnF){
				storeToFile(expression.toString());
			}
			
/* 6. */	//MEMORY BUTTON CODE
			if(event.getSource() == btnM){
				retrieveFromMemory();
			}
			
/* 7. */	//USER MANUAL
			if(event.getSource() == mntmViewUserManual){
				openUserManual();
			}
			
			displayField.setText(expression.toString());
			
		}
		
		public void reset(){
			if(expressionEvaluated){
				expression = new StringBuilder("");
				expressionQueue.destroy();
				postfixDisplayField.setText("");
				pointMem.destroy();
				negativeMem.destroy();
				expressionEvaluated = false;
			}
		}
		//Validating input to expression
		public void addToExpression(StringBuilder exp, String what){
			if(exp != null && exp.length() > 0){
				char lastAdded = exp.charAt(exp.length() - 1);
				boolean negative = !(negativeMem.getTop() == null || negativeMem.getTop().getData().getValue() == false);
				//if appending string is a sign and the last thing add to the expression is not a sign
				//and the appending string is not a dot
				if(isSign(what) && !isSign(String.format("%c", lastAdded)) && !what.equals(".")){//signs get added here
					if(lastAdded == '.')
						exp.append("0"+what);
					else
						exp.append(what);
					pointMem.push(new Flag(false));
					negativeMem.push(new Flag(false));
				}else if(!what.equals(".") && !isSign(what) && !negative && isNumeric(what)){//Numbers get added here
					exp.append(what);
				}
				
				if(what.equals(".") && (pointMem.getTop() == null || pointMem.getTop().getData().getValue() == false)){//Point gets added here
					if(!String.format("%c", lastAdded).equals(".")){//last char added is not a dot
						if(isNumeric(String.format("%c", lastAdded))){
							exp.append(what);
							pointMem.push(new Flag(true));
						}else if(isSign(String.format("%c", lastAdded))){
							exp.append("0"+what);
							pointMem.push(new Flag(true));
						}
					}
				}
			}else if(!isSign(what) && isNumeric(what)){
				exp.append(what);
			}else if(what.equals(".")){
				exp.append("0"+what);
				pointMem.push(new Flag(true));
			}
//			if(pointMem.getTop() != null && negativeMem.getTop() != null)
//				System.out.println("pointMem: " + pointMem.getTop().getData().getValue()+" negMem: "+ negativeMem.getTop().getData().getValue());
		}
		public void negate(){
			reset();	
			String regex1 = "([\\d\\.]+)*?$";//match number at the end of expression
			String regex2 = "\\(\\-([\\.0-9]+?)\\)$";//match brackets with minus sign
			Pattern pat1 = Pattern.compile(regex1); 
			Pattern pat2 = Pattern.compile(regex2);
			Matcher mat1 = pat1.matcher(expression.toString());
			Matcher mat2 = pat2.matcher(expression.toString());
			
			
			if((negativeMem.getTop() == null || negativeMem.getTop().getData().getValue() == false) && mat1.find()){
				if(!mat1.group(0).equals("")){
					char lastAdded = expression.charAt(expression.length() - 1);
					if(Double.parseDouble(mat1.group(0)) > 0){//no need to check if value is numeric
						if(lastAdded == '.')
							expression.replace(expression.length() - mat1.group(0).length(), expression.length(),
									"(-"+mat1.group(0)+"0)"); 
						else
							expression.replace(expression.length() - mat1.group(0).length(), expression.length(),
									"(-"+mat1.group(0)+")");
						negativeMem.push(new Flag(true));
					}
				}
			}else if((negativeMem.getTop() != null || negativeMem.getTop().getData().getValue() == true) && mat2.find()){
				expression.replace(expression.length() - mat2.group(0).length(), expression.length(),
						mat2.group(1));
				negativeMem.pop();
			}
		}
		public void backspace(){
			reset();
			String regex = "(\\(\\-[\\.0-9]+\\))*?$";//match brackets with minus sign
			Pattern pat = Pattern.compile(regex);
			Matcher mat = pat.matcher(expression.toString());
			char lastAdded = 0;
			if(expression.length() > 0)
				lastAdded = expression.charAt(expression.length() - 1);
			
			if(mat.find() && mat.group(0).length() > 0){
				expression.replace(expression.length() - mat.group(0).length(), expression.length(),
						"");
				if(negativeMem.getTop() != null || negativeMem.getTop().getData().getValue() == true)
					negativeMem.pop();
				
				if(pointMem.getTop() != null && pointMem.getTop().getData().getValue() == true)
					pointMem.pop();
			}
			else if(isSign(String.format("%c", lastAdded))){
				pointMem.pop();
				negativeMem.pop();
				expression.deleteCharAt(expression.length() - 1);
			}
			else if(lastAdded == '.'){
				pointMem.pop();
				expression.deleteCharAt(expression.length() - 1);
			}
			else if(expression != null && expression.length() > 0)
				expression.deleteCharAt(expression.length() - 1);
			
		}
		public void calculate(){
			if(expression.length() > 0){
				String regex = "(\\([\\-][\\d\\.]+\\))+?";
				Matcher mat = Pattern.compile(regex).matcher(expression.toString());
				//Convert negative numbers to (0 - num)
				while(mat.find() && mat.group(0).length() > 0){
					for(int i = 0; i < mat.groupCount(); i++){							
						expression.replace(	
							expression.indexOf(mat.group(i)),
							expression.indexOf(mat.group(i)) + mat.group(i).length(),
							mat.group(i).replaceAll("[\\(]", "(0")
						);
					}
				}
				//Remove the signs from the end of an expression.
				if(isSign(String.valueOf(expression.charAt(expression.length() - 1)))){
					expression.deleteCharAt(expression.length() - 1);
				}
				
				Convert cvtr = new Convert();
				ExpressionTree expt = new ExpressionTree();
				expressionQueue = cvtr.convertToPostfixQueue(expression);
				postfixDisplayField.setText(expressionQueue.display().toString());
				double ans = expt.calculateExpression(expressionQueue);
				
				expression = new StringBuilder(String.valueOf(ans));
				Matcher m = Pattern.compile("\\.0$").matcher(expression.toString());
				if(m.find() && m.group(0).length() > 0){
					expression.replace(expression.length() - 2, expression.length(), "");
				}
				expressionEvaluated = true;
				
			}
		}
		public String storeToFile(String info){
			FileWriter tofile = null;

			try{
				if(info.length() > 0){
					tofile = new FileWriter ("Storage.txt", true);
					tofile.append(info+"\r\n");
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				try{
					tofile.close();
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Please type an expression.");
				}
			}
				
			return info;

		}
		
		public void retrieveFromMemory(){
			if(expression.length() >= 1)
				addToExpression(expression, String.valueOf(expression.charAt(expression.length() - 1)));
		}
		public void openUserManual(){
			try{
				if((new File("User-Manual.chm")).exists()){
		            Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler User-Manual.chm");
		            p.waitFor();
		        }else
		            JOptionPane.showMessageDialog(null, "File does not exist");
		        
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "An error has occured while opening the user manual");
			}
		}
		public boolean isSign(String s){
			return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
		}
		
		public boolean isNumeric(String n){
			return Character.isDigit(n.toCharArray()[0]);
		}
		
	}
}
