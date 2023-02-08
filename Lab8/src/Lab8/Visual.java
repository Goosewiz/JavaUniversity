package Lab8;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Visual extends JFrame{
	private JTextArea output;
	private JOptionPane error;
	private Calculator calc;
	private boolean longTerm = false;
	private boolean inOperation = false;
	/*public JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b0;
	private JButton bplus;
	private JButton bminus;
	private JButton bmulti;
	private JButton bdiv;
	private JButton bpow;
	private JButton broot;
	private JButton bc;
	private JButton bchange;
	private JButton bequ;
	private JButton bdot;
	private JFrame f;*/
	Visual() {		
		JFrame f = new JFrame("calculator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		output = new JTextArea(1,20);
		output.setFont(new Font("Arial", Font.PLAIN, 24));
		output.setPreferredSize(new Dimension(100, 50));
		output.setEditable(false);
		calc = new Calculator();
		calc.setValue1(0);
		calc.setValue2(0);
		calc.setOperator('+');
		JPanel p = new JPanel();
		JButton bplus = new JButton("+");
		bplus.setPreferredSize(new Dimension(100, 50));
		bplus.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonPlusPressed(e);
	        }
	    });
		JButton b1 = new JButton("1");
		b1.setPreferredSize(new Dimension(100, 50));
		b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button1Pressed(e);
	        }
	    });
		JButton b2 = new JButton("2");
		b2.setPreferredSize(new Dimension(100, 50));
		b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button2Pressed(e);
	        }
	    });
		JButton b3 = new JButton("3");
		b3.setPreferredSize(new Dimension(100, 50));
		b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button3Pressed(e);
	        }
	    });
		JButton bminus = new JButton("-");
		bminus.setPreferredSize(new Dimension(100, 50));
		bminus.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonMinusPressed(e);
	        }
	    });
		JButton b4 = new JButton("4");
		b4.setPreferredSize(new Dimension(100, 50));
		b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button4Pressed(e);
	        }
	    });
		JButton b5 = new JButton("5");
		b5.setPreferredSize(new Dimension(100, 50));
		b5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button5Pressed(e);
	        }
	    });
		JButton b6 = new JButton("6");
		b6.setPreferredSize(new Dimension(100, 50));
		b6.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button6Pressed(e);
	        }
	    });
		JButton bmulti = new JButton("*");
		bmulti.setPreferredSize(new Dimension(100, 50));
		bmulti.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonMultiPressed(e);
	        }
	    });
		JButton b7 = new JButton("7");
		b7.setPreferredSize(new Dimension(100, 50));
		b7.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button7Pressed(e);
	        }
	    });
		JButton b8 = new JButton("8");
		b8.setPreferredSize(new Dimension(100, 50));
		b8.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button8Pressed(e);
	        }
	    });
		JButton b9 = new JButton("9");
		b9.setPreferredSize(new Dimension(100, 50));
		b9.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button9Pressed(e);
	        }
	    });
		JButton bdiv = new JButton("/");
		bdiv.setPreferredSize(new Dimension(100, 50));
		bdiv.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonDivPressed(e);
	        }
	    });
		JButton bc = new JButton("C");
		bc.setPreferredSize(new Dimension(100, 50));
		bc.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonCPressed(e);
	        }
	    });
		JButton b0 = new JButton("0");
		b0.setPreferredSize(new Dimension(100, 50));
		b0.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            button0Pressed(e);
	        }
	    });
		JButton bequ = new JButton("=");
		bequ.setPreferredSize(new Dimension(100, 50));
		bequ.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonEqualPressed(e);
	        }
	    });
		JButton broot = new JButton("√");
		broot.setPreferredSize(new Dimension(100, 50));
		broot.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonRootPressed(e);
	        }
	    });
		JButton bpow = new JButton("^");
		bpow.setPreferredSize(new Dimension(100, 50));
		bpow.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonPowPressed(e);
	        }
	    });
		JButton bdot = new JButton(".");
		bdot.setPreferredSize(new Dimension(100, 50));
		bdot.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonDotPressed(e);
	        }
	    });
		JButton bchange = new JButton("+/-");
		bchange.setPreferredSize(new Dimension(100, 50));
		bchange.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            buttonChangePressed(e);
	        }
	    });
		//f.addKeyListener(new MyKeyListener(b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmulti,bdiv,bpow,broot,bequ,bc,bchange,bdot,this));
		output.addKeyListener((KeyListener) new KeyListener(){
			public void keyPressed(KeyEvent e) {
		        if (e.getKeyChar() == '1') {
		            b1.doClick();
		        } 
		        if (e.getKeyChar() == '2') {
		            b2.doClick();
		        } 
		        else if (e.getKeyChar() == '3') {
		            b3.doClick();
		        } 
		        else if (e.getKeyChar() == '4') {
		            b4.doClick();
		        } 
		        else if (e.getKeyChar() == '5') {
		            b5.doClick();
		        } 
		        else if (e.getKeyChar() == '6') {
		            b6.doClick();
		        } 
		        else if (e.getKeyChar() == '7') {
		            b7.doClick();
		        } 
		        else if (e.getKeyChar() == '8') {
		            b8.doClick();
		        } 
		        else if (e.getKeyChar() == '9') {
		            b9.doClick();
		        } 
		        else if (e.getKeyChar() == '0') {
		            b0.doClick();
		        } 
		        else if (e.getKeyChar() == '-') {
		            bminus.doClick();
		        } 
		        else if (e.getKeyChar() == '+') {
		            bplus.doClick();
		        } 
		        else if (e.getKeyChar() == '*') {
		            bmulti.doClick();
		        } 
		        else if (e.getKeyChar() == '/') {
		            bdiv.doClick();
		        } 
		        else if (e.getKeyChar() == '=') {
		            bequ.doClick();
		        } 
		        else if (e.getKeyChar() == '^') {
		            bpow.doClick();
		        } 
		        else if (e.getKeyChar() == '.') {
		            bdot.doClick();
		        } 
		        else if (e.getKeyChar() == '^') {
		            bpow.doClick();
		        } 
		        else if (e.getKeyChar() == 'r') {
		            broot.doClick();
		        } 
		        else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
		            bc.doClick();
		        }
		    }

			@Override
			public void keyTyped(KeyEvent e) {			
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		output.setText("0");
		p.add(output);
		p.add(bplus);
		p.add(bpow);
		p.add(broot);
		p.add(bc);
		p.add(bminus);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bmulti);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bdiv);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bchange);
		p.add(bdot);
		p.add(b0);
		p.add(bequ);
		f.add(p);
		f.setSize(500, 400);
		f.setResizable(false);
		f.setVisible(true);//f.show();
	}
	public void button1Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("1");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "1");
	}
	public void button2Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("2");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "2");
	}
	public void button3Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("3");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "3");
	}
	public void button4Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("4");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "4");
	}
	public void button5Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("5");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "5");
	}
	public void button6Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("6");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "6");
	}
	public void button7Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("7");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "7");
	}
	public void button8Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("8");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "8");
	}
	public void button9Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("9");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "9");
	}
	public void button0Pressed(ActionEvent e) {
		if (inOperation) {
			output.setText("0");
			inOperation = false;
		}
		else
			output.setText(output.getText() + "0");
	}
	public void buttonPlusPressed(ActionEvent e) {
		if (inOperation) {
			calc.setOperator('+');
			output.setText("+");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (!longTerm) {
					calc.setValue1(Double.parseDouble(output.getText()));
					calc.setOperator('+');
					output.setText("+");
					inOperation = true;
					longTerm = true;
				}
				else {
					calc.setValue2(Double.parseDouble(output.getText()));
					if (calc.getValue2() == 0 && calc.getOperator() == '/') {
						output.setText("0");
						error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
					}
					else {
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else {
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('+');
							inOperation = true;
						}
					}
				}
			}
		}
	}
	public void buttonMinusPressed(ActionEvent e) {
		if (inOperation) {
			calc.setOperator('-');
			output.setText("-");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (!longTerm) {
					calc.setValue1(Double.parseDouble(output.getText()));
					calc.setOperator('-');
					output.setText("-");
					inOperation = true;
					longTerm = true;
				}
				else {
					calc.setValue2(Double.parseDouble(output.getText()));
					if (calc.getValue2() == 0 && calc.getOperator() == '/') {
						output.setText("0");
						error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
					}
					else {
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else {
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('-');
							inOperation = true;
						}
					}
				}
			}
		}
	}
	public void buttonMultiPressed(ActionEvent e) {
		if (inOperation) {
			calc.setOperator('*');
			output.setText("*");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (!longTerm) {
					calc.setValue1(Double.parseDouble(output.getText()));
					calc.setOperator('*');
					output.setText("*");
					inOperation = true;
					longTerm = true;
				}
				else {
					calc.setValue2(Double.parseDouble(output.getText()));
					if (calc.getValue2() == 0 && calc.getOperator() == '/') {
						output.setText("0");
						error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
					}
					else {
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else {
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('*');
							inOperation = true;
						}
					}
				}
			}
		}
	}
	public void buttonDivPressed(ActionEvent e) {
		if (inOperation) {
			calc.setOperator('/');
			output.setText("/");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (!longTerm) {
					calc.setValue1(Double.parseDouble(output.getText()));
					calc.setOperator('/');
					output.setText("/");
					inOperation = true;
					longTerm = true;
				}
				else {
					calc.setValue2(Double.parseDouble(output.getText()));
					if (calc.getValue2() == 0 && calc.getOperator() == '/') {
						output.setText("0");
						error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
					}
					else {
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else {
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('/');
							inOperation = true;
						}
					}
				}
			}
		}
	}
	public void buttonPowPressed(ActionEvent e) {
		if (inOperation) {
			calc.setOperator('^');
			output.setText("^");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (!longTerm) {
					calc.setValue1(Double.parseDouble(output.getText()));
					calc.setOperator('^');
					output.setText("^");
					inOperation = true;
					longTerm = true;
				}
				else {
					calc.setValue2(Double.parseDouble(output.getText()));
					if (calc.getValue2() == 0 && calc.getOperator() == '/') {
						output.setText("0");
						error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
					}
					else {
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else {
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('^');
							inOperation = true;
						}
					}
				}
			}
		}
	}
	public void buttonRootPressed(ActionEvent e) {
		if (inOperation) {
			if (calc.getValue2() == 0)
				error.showMessageDialog(null, "Нельзя выбрать операцию извлечения корня после любой другой операции, завершите выполнение другой операции");
			else {
				calc.setOperator('r');
				output.setText(calc.calculate());
				if (output.getText().equals("NaN")){
					output.setText("0");
					calc.setValue1(0);
					calc.setValue2(0);
					calc.setOperator('+');
					longTerm = false;
					inOperation = false;
					error.showMessageDialog(null, "Нельзя возвести в такую степень");
				}
			}
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				if (Double.parseDouble(output.getText()) < 0) {
					output.setText("0");
					calc.setValue1(0);
					calc.setValue2(0);
					calc.setOperator('+');
					calc.setResult(0);
					longTerm = false;
					inOperation = false;
					error.showMessageDialog(null, "нельзя извлечь корень из отрицательного числа");
				}
				else {
					if (!longTerm) {
						calc.setValue1(Double.parseDouble(output.getText()));
						calc.setOperator('r');
						output.setText(calc.calculate());
						if (output.getText().equals("NaN")){
							output.setText("0");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
							error.showMessageDialog(null, "Нельзя возвести в такую степень");
						}
						else
							longTerm = false;
					}
					else {
						calc.setValue2(Double.parseDouble(output.getText()));
						if (calc.getValue2() == 0 && calc.getOperator() == '/') {
							output.setText("");
							error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
							calc.setValue1(0);
							calc.setValue2(0);
							calc.setOperator('+');
							calc.setResult(0);
							longTerm = false;
							inOperation = false;
						}
						else {
							output.setText(calc.calculate());
							calc.setValue1(Double.parseDouble(output.getText()));
							calc.setOperator('r');
							output.setText(calc.calculate());
							if (output.getText().equals("NaN")){
								output.setText("0");
								calc.setValue1(0);
								calc.setValue2(0);
								calc.setOperator('+');
								longTerm = false;
								inOperation = false;
								error.showMessageDialog(null, "Нельзя возвести в такую степень");
							}
							else
								longTerm = false;
						}
					}
				}
			}
		}
	}
	public void buttonCPressed(ActionEvent e) {
		output.setText("");
	}
	public void buttonEqualPressed(ActionEvent e) {
		if (inOperation) {
			error.showMessageDialog(null, "Вы нажали = после нажатия кнопки операции");
		}
		else {
			if (output.getText().equals(".")) {
				output.setText("");
				error.showMessageDialog(null, "В целой части должно быть число");
			}
			else {
				calc.setValue2(Double.parseDouble(output.getText()));
				if (calc.getValue2() == 0 && calc.getOperator() == '/') {
					output.setText("0");
					error.showMessageDialog(null, "Нельзя делить на ноль, все значения сброшены");
					calc.setValue1(0);
					calc.setValue2(0);
					calc.setOperator('+');
					calc.setResult(0);
					longTerm = false;
					inOperation = false;
				}
				else {
					output.setText(calc.calculate());
					if (output.getText().equals("NaN")){
						output.setText("0");
						calc.setValue1(0);
						calc.setValue2(0);
						calc.setOperator('+');
						calc.setResult(0);
						longTerm = false;
						inOperation = false;
						error.showMessageDialog(null, "Нельзя возвести в такую степень");
					}
					else
						longTerm = false;
				}
			}
		}
	}
	public void buttonDotPressed(ActionEvent e) {
		if (!output.getText().contains(".") && !inOperation) {
			output.setText(output.getText() + ".");
		}
	}
	public void buttonChangePressed(ActionEvent e) {
		if (inOperation)
			error.showMessageDialog(null, "Нельзя изменить знак числа");
		else {
			String temp = output.getText();
			if (temp.charAt(0) == '-')
				output.setText(temp.substring(1,temp.length()));
			else
				output.setText("-" + output.getText());
		}
	}
}
