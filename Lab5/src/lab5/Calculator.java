package lab5;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculator {

	protected Shell Calculator;
	private Text text;
	private Button btn8;
	private Button btn9;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn0;
	private Button btnadd;
	private Button btnsub;
	private Button btnmul;
	private Button btndiv;
	private Button btneq;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Calculator.open();
		Calculator.layout();
		while (!Calculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	public ArrayList<Character> arr = new ArrayList<Character>();
	public String str;
	public int opA, opB;
	public char operator;
	public int ans;
	public int pointer;
	public boolean eq = false;
	private Text text1;
	public void cal(char num) {
		if(eq == true) {
			arr.clear();
			text.setText("");
			text1.setText("");
			eq = false;
		}
		arr.add(num);
		text.append(Character.toString(num));
		System.out.println(arr);
	}//end num
	
	public void summary() {
		str = arr.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
		int pointer = str.indexOf(operator);
        int opA , opB;
        opA = Integer.valueOf(str.substring(0, pointer));
        opB = Integer.valueOf(str.substring(pointer + 1, str.length()));
        switch(operator){
        case '+' :
        	ans = opA + opB;
        	break;
        case '-' :
        	ans = opA - opB;
        	break;
        case '*' :
        	ans = opA * opB;
        	break;
        case '/' :
        	if(opB != 0) {
        		text1.append(String.valueOf((float)opA / (float)opB));
        	} else {
        		text1.append("Syntax Error");
        		
        	}
        	break;
        }
        if(operator != '/') {
        	text1.append(String.valueOf(ans));
        }
	}
	
	protected void createContents() {
		Calculator = new Shell();
		Calculator.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		Calculator.setSize(354, 451);
		Calculator.setText("Calculator");
		
		text = new Text(Calculator, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		text.setBounds(10, 10, 316, 69);
		
		text1 = new Text(Calculator, SWT.BORDER);
		text1.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		text1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		text1.setBounds(10, 79, 316, 77);
		
		btn0 = new Button(Calculator, SWT.NONE);
		btn0.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty()) {
					cal('0');
				}
			}//end 0
		});
		btn0.setText("0");
		btn0.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn0.setBounds(10, 344, 189, 50);
		
		btn1 = new Button(Calculator, SWT.NONE);
		btn1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('1');
			}
		});
		btn1.setText("1");
		btn1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn1.setBounds(10, 281, 59, 57);
		
		btn2 = new Button(Calculator, SWT.NONE);
		btn2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('2');
			}
		});
		btn2.setText("2");
		btn2.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn2.setBounds(75, 281, 59, 57);
		
		btn3 = new Button(Calculator, SWT.NONE);
		btn3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('3');
			}
		});
		btn3.setText("3");
		btn3.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn3.setBounds(140, 281, 59, 57);
		
		btn4 = new Button(Calculator, SWT.NONE);
		btn4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('4');
			}
		});
		btn4.setText("4");
		btn4.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn4.setBounds(10, 225, 59, 50);
		
		btn5 = new Button(Calculator, SWT.NONE);
		btn5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('5');
			}
		});
		btn5.setText("5");
		btn5.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn5.setBounds(75, 225, 59, 50);
		
		btn6 = new Button(Calculator, SWT.NONE);
		btn6.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('6');
			}
		});
		btn6.setText("6");
		btn6.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn6.setBounds(140, 225, 59, 50);
		
		Button btn7 = new Button(Calculator, SWT.NONE);
		btn7.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn7.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('7');
			}
		});
		btn7.setBounds(10, 162, 59, 57);
		btn7.setText("7");
		
		btn8 = new Button(Calculator, SWT.NONE);
		btn8.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('8');
			}
		});
		btn8.setText("8");
		btn8.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn8.setBounds(75, 162, 59, 57);
		
		btn9 = new Button(Calculator, SWT.NONE);
		btn9.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btn9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('9');
			}
		});
		btn9.setText("9");
		btn9.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btn9.setBounds(140, 162, 59, 57);
		
		btnadd = new Button(Calculator, SWT.NONE);
		btnadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		btnadd.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('+');
					operator = '+' ;
				}
			}//end +
		});
		btnadd.setText("+");
		btnadd.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btnadd.setBounds(205, 162, 59, 57);
		
		btnsub = new Button(Calculator, SWT.NONE);
		btnsub.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		btnsub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('-');
					operator = '-' ;
				}
			}//end -
		});
		btnsub.setText("-");
		btnsub.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btnsub.setBounds(270, 162, 56, 57);
		
		btnmul = new Button(Calculator, SWT.NONE);
		btnmul.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		btnmul.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('*');
					operator = '*' ;
				}
			}//end *
		});
		btnmul.setText("*");
		btnmul.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btnmul.setBounds(205, 225, 59, 50);
		
		btndiv = new Button(Calculator, SWT.NONE);
		btndiv.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		btndiv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('/');
					operator = '/' ;
				}
			}//end /
		});
		btndiv.setText("/");
		btndiv.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btndiv.setBounds(270, 225, 56, 50);
		
		btneq = new Button(Calculator, SWT.NONE);
		btneq.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btneq.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					eq = true;
					summary();
				}
			}//end =
		});
		btneq.setText("=");
		btneq.setFont(SWTResourceManager.getFont("Tahoma", 15, SWT.NORMAL));
		btneq.setBounds(205, 281, 121, 113);
		

	}
}