package Q1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JPanel panel;
	JButton[] numbers=new JButton[10];
	JButton[] operations=new JButton[5];
	JButton pointButton, addButton, subButton,prodButton,divButton,equalButton,clearButton,delButton;
	JButton zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton,sixButton,sevenButton,eightButton,nineButton;
	
	
	double num1 =0;
	double num2 =0;
	double result =0;
	char arithmeticOperator;
	
	public Calculator(){
		frame = new JFrame("CALCULATOR");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 50,300, 550);
		
		frame.setLayout(null);
		textfield=new JTextField();
		textfield.setBounds(45, 30, 200, 50);
		
		
		pointButton= new JButton(".");
		addButton = new JButton("+");
		operations[0] = addButton;
		subButton= new JButton("-");
		operations[1] = subButton;
		prodButton= new JButton("*");
		operations[2] = prodButton;
		divButton= new JButton("/");
		operations[3] = divButton;
		equalButton= new JButton("=");
		operations[4] = equalButton;
		
		for (int i=0;i<5;i++) {
			operations[i].addActionListener(this);
		}
		
		zeroButton= new JButton("0");
		numbers[0] = zeroButton;
		oneButton= new JButton("1");
		numbers[1] = oneButton;
		twoButton= new JButton("2");
		numbers[2] = twoButton;
		threeButton= new JButton("3");
		numbers[3] = threeButton;
		fourButton= new JButton("4");
		numbers[4] = fourButton;
		fiveButton= new JButton("5");
		numbers[5] = fiveButton;
		sixButton= new JButton("6");
		numbers[6] = sixButton;
		sevenButton= new JButton("7");
		numbers[7] = sevenButton;
		eightButton= new JButton("8");
		numbers[8] = eightButton;
		nineButton= new JButton("9");
		numbers[9] = nineButton;
		
		for (int i=0;i<10;i++) {
			numbers[i].addActionListener(this);
		}
		
		clearButton= new JButton("CLEAR");
		clearButton.setBounds(50, 120,80,50);
		clearButton.addActionListener(this);
		delButton = new JButton("DEL");
		delButton.setBounds(150, 120,80,50);
		delButton.addActionListener(this);
		pointButton.addActionListener(this);
		

		
		panel=new JPanel();
		panel.setBounds(10, 180, 260, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numbers[1]);
		panel.add(numbers[2]);		
		panel.add(numbers[3]);
		panel.add(operations[0]);
		panel.add(numbers[4]);		
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(operations[1]);
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);	
		panel.add(operations[2]);
		panel.add(pointButton);
		panel.add(numbers[0]);
		panel.add(equalButton);
		panel.add(operations[3]);
	
		
		frame.add(textfield);
		frame.add(delButton);
		frame.add(clearButton);
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i =0;i<10;i++) {
			if(e.getSource()==numbers[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
			
		}
		if(e.getSource()==pointButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1=Double.parseDouble(textfield.getText());
			arithmeticOperator= '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1=Double.parseDouble(textfield.getText());
			arithmeticOperator= '-';
			textfield.setText("");
		}
		if(e.getSource()==prodButton) {
			num1=Double.parseDouble(textfield.getText());
			arithmeticOperator= '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1=Double.parseDouble(textfield.getText());
			arithmeticOperator= '/';
			textfield.setText("");
		}
		if(e.getSource()==clearButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String newInput="";
			String input = textfield.getText();
			if (input.contains("+")||input.contains("*")||input.contains("-")||input.contains("-")) {
				for(int i=0;i<input.length();i++) {
					if (input.charAt(i) == '+' || input.charAt(i) == '*' ||input.charAt(i) == '-' ||input.charAt(i) == '/')
						break;
					else 
						newInput+=input.charAt(i);
					
				}	
				textfield.setText(newInput);
			}
			else 
				textfield.setText("");
		
		
		}
		
		if(e.getSource()==equalButton) {
			int op_status=0;
			num2=Double.parseDouble(textfield.getText());
			switch(arithmeticOperator) {
			case'+':
				result= num1+num2;
				break;
			case'-':
				result= num1-num2;
				break;
			case'*':
				result= num1*num2;
				break;
			case'/':
				if(num2==0) 
					op_status+=1;
				
				else 
					result= num1/num2;
				
				break;
			}
			if(op_status==1) 
				textfield.setText(String.valueOf("Cannot divide by 0"));			
			else 
				textfield.setText(String.valueOf(result));
			
			num1=result;
		}
		
		
		
	}
}
