/**
 * Program Name: GUICalculator.java
 * Purpose: A simple GUI calculator supporting add, subtract, multiply, divide, and mod
 * Coder: Htoo Tay Zar Aung
 * Date: Jul 10, 2026
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GUICalculator extends JFrame implements ActionListener
{

	JButton addBtn, subtractBtn, multiplyBtn, divideBtn, modBtn, clearBtn;
	JTextField firstValueFld, secondValueFld, resultFld;


	//constructor
	public GUICalculator()
	{
		super("GUI Calculator");
		this.setSize(600,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(createTopPanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);
		this.add(bottomPanel(), BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);

	}

	public JPanel createTopPanel()
	{
		JPanel topPnl = new JPanel();

		JLabel topLbl = new JLabel("Using multiple JPanels here to hold components....");
		topPnl.add(topLbl);

		return topPnl;
	}
	public JPanel centerPanel()
	{
		JPanel centerPnl = new JPanel();
		centerPnl.setLayout(new GridLayout(3,2,30,30));
		centerPnl.setBackground(new Color(255,255,0));

		JLabel firstLbl = new JLabel("Enter first value");
		firstLbl.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel secondLbl = new JLabel("Enter second value");
		secondLbl.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel resultLbl = new JLabel("your result is: ");
		resultLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		firstValueFld = new JTextField();
		secondValueFld = new JTextField();
		resultFld = new JTextField();
		resultFld.setEditable(false);
		centerPnl.add(firstLbl);
		centerPnl.add(firstValueFld);
		centerPnl.add(secondLbl);
		centerPnl.add(secondValueFld);
		centerPnl.add(resultLbl);
		centerPnl.add(resultFld);
		return centerPnl;

	}
	public JPanel bottomPanel()
	{
		JPanel bottomPnl = new JPanel();
		bottomPnl.setBackground(new Color(0,255,0));

		addBtn = new JButton("Add");
		subtractBtn = new JButton("Subtract");
		multiplyBtn = new JButton("Multiply");
		divideBtn = new JButton("Divide");
		modBtn = new JButton("Mod");
		clearBtn = new JButton("Clear");

		bottomPnl.add(addBtn);
		bottomPnl.add(subtractBtn);
		bottomPnl.add(multiplyBtn);
		bottomPnl.add(divideBtn);
		bottomPnl.add(modBtn);
		bottomPnl.add(clearBtn);

		// register this frame as the listener for every button
		addBtn.addActionListener(this);
		subtractBtn.addActionListener(this);
		multiplyBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		modBtn.addActionListener(this);
		clearBtn.addActionListener(this);

		return bottomPnl;


	}




	public static void main(String[] args)
	{
		new GUICalculator();

	}
	//end main

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Clear doesn't need the text fields to have valid numbers,
		// so handle it first and return before any parsing happens
		if (e.getSource() == clearBtn)
		{
			firstValueFld.setText("");
			secondValueFld.setText("");
			resultFld.setText("");
			return;
		}

		double firstValue, secondValue, resultValue;

		try
		{
			firstValue = Double.parseDouble(firstValueFld.getText());
			secondValue = Double.parseDouble(secondValueFld.getText());
		}
		catch (NumberFormatException ex)
		{
			resultFld.setText("Enter valid numbers");
			return;
		}

		if (e.getSource() == addBtn)
		{
			resultValue = firstValue + secondValue;
		}
		else if (e.getSource() == subtractBtn)
		{
			resultValue = firstValue - secondValue;
		}
		else if (e.getSource() == multiplyBtn)
		{
			resultValue = firstValue * secondValue;
		}
		else if (e.getSource() == divideBtn)
		{
			if (secondValue == 0)
			{
				resultFld.setText("Cannot divide by 0");
				return;
			}
			resultValue = firstValue / secondValue;
		}
		else if (e.getSource() == modBtn)
		{
			if (secondValue == 0)
			{
				resultFld.setText("Cannot mod by 0");
				return;
			}
			resultValue = firstValue % secondValue;
		}
		else
		{
			return;
		}

		resultFld.setText(String.valueOf(resultValue));
	}
}
//end class