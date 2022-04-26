package szakdolgozat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

public class Successgui extends gui {

	public static void successgui() {
		
		node = new DefaultMutableTreeNode("SzakdolgozatDB");
		SuccessPanel = new JPanel();
		SuccessFrame = new JFrame();
		SuccessFrame.setSize(1500, 1000);
		SuccessFrame.setLocationRelativeTo(null);
		SuccessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SuccessFrame.add(SuccessPanel);

		Successgui instance = new Successgui();

		NewParentNode = new JButton("New Node");
		NewParentNode.setBounds(400, 50, 400, 200);
		NewParentNode.setBorder(new RoundBtn(15));
		NewParentNode.addActionListener(instance);
		SuccessPanel.add(NewParentNode);

		NewChildNode = new JButton("New Leaf");
		NewChildNode.setBounds(1000, 50, 400, 200);
		NewChildNode.setBorder(new RoundBtn(15));
		NewChildNode.addActionListener(instance);
		SuccessPanel.add(NewChildNode);

		RemoveParentNode = new JButton("Remove Node");
		RemoveParentNode.setBounds(400, 400, 400, 200);
		RemoveParentNode.setBorder(new RoundBtn(15));
		RemoveParentNode.addActionListener(instance);
		SuccessPanel.add(RemoveParentNode);

		RemoveChildNode = new JButton("Remove Leaf");
		RemoveChildNode.setBounds(1000, 400, 400, 200);
		RemoveChildNode.setBorder(new RoundBtn(15));
		RemoveChildNode.addActionListener(instance);
		SuccessPanel.add(RemoveChildNode);

		BackButton = new JButton("Back");
		BackButton.setBounds(1280, 0, 200, 100);
		BackButton.setBorder(new RoundBtn(15));
		BackButton.addActionListener(instance);
		SuccessPanel.add(BackButton);

		DeleteTextButton = new JButton("Reset text");
		DeleteTextButton.setBounds(1320, 700, 150, 132);
		DeleteTextButton.setBorder(new RoundBtn(15));
		DeleteTextButton.addActionListener(instance);
		SuccessPanel.add(DeleteTextButton);

		RunQueryButton = new JButton("Run Query");
		RunQueryButton.setBounds(1320, 830, 150, 132);
		RunQueryButton.setBorder(new RoundBtn(15));
		RunQueryButton.addActionListener(instance);
		SuccessPanel.add(RunQueryButton);

		GetInfo = new JButton("Get Information");
		GetInfo.setBounds(400, 500, 200, 100);
		GetInfo.setBorder(new RoundBtn(15));
		GetInfo.setVisible(false);
		GetInfo.addActionListener(instance);
		SuccessPanel.add(GetInfo);

		AddNode = new JButton("Add Node(s)");
		AddNode.setBounds(600, 500, 200, 100);
		AddNode.setBorder(new RoundBtn(15));
		AddNode.setVisible(false);
		AddNode.addActionListener(instance);
		SuccessPanel.add(AddNode);

		AddChildNode = new JButton("Add Leaf(s)");
		AddChildNode.setBounds(600, 500, 200, 100);
		AddChildNode.setBorder(new RoundBtn(15));
		AddChildNode.setVisible(false);
		AddChildNode.addActionListener(instance);
		SuccessPanel.add(AddChildNode);
		
		


		NodeLabel = new JLabel("New Node name");
		NodeLabel.setBounds(400, 50, 200, 25);
		NodeLabel.setVisible(false);
		SuccessPanel.add(NodeLabel);

		NodeLabel2 = new JLabel("Additional Node name");
		NodeLabel2.setBounds(400, 150, 200, 25);
		NodeLabel2.setVisible(false);

		SuccessPanel.add(NodeLabel2);

		NodeLabel3 = new JLabel("Additional Node name");
		NodeLabel3.setBounds(400, 230, 200, 25);
		NodeLabel3.setVisible(false);
		SuccessPanel.add(NodeLabel3);

		NodeLabel4 = new JLabel("Additional Node name");
		NodeLabel4.setBounds(400, 310, 200, 25);
		NodeLabel4.setVisible(false);
		SuccessPanel.add(NodeLabel4);

		NodeLabel5 = new JLabel("Additional Node name");
		NodeLabel5.setBounds(400, 390, 200, 25);
		NodeLabel5.setVisible(false);
		SuccessPanel.add(NodeLabel5);

		AdditionalNodeLabel = new JLabel("Do you want to add more nodes?");
		AdditionalNodeLabel.setBounds(400, 120, 200, 25);
		AdditionalNodeLabel.setVisible(false);
		SuccessPanel.add(AdditionalNodeLabel);

		Tnode = new JTextField(20);
		Tnode.setBounds(400, 80, 400, 40);
		Tnode.setVisible(false);
		SuccessPanel.add(Tnode);

		Tnode2 = new JTextField(20);
		Tnode2.setBounds(400, 175, 400, 40);
		Tnode2.setVisible(false);
		SuccessPanel.add(Tnode2);

		Tnode3 = new JTextField(20);
		Tnode3.setBounds(400, 255, 400, 40);
		Tnode3.setVisible(false);
		SuccessPanel.add(Tnode3);

		Tnode4 = new JTextField(20);
		Tnode4.setBounds(400, 335, 400, 40);
		Tnode4.setVisible(false);
		SuccessPanel.add(Tnode4);

		Tnode5 = new JTextField(20);
		Tnode5.setBounds(400, 415, 400, 40);
		Tnode5.setVisible(false);
		SuccessPanel.add(Tnode5);

		Checkbox = new JCheckBox();
		Checkbox.setBounds(600, 120, 25, 25);
		Checkbox.setVisible(false);
		Checkbox.setSelected(false);
		Checkbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JCheckBox cb = (JCheckBox) event.getSource();
				if (cb.isSelected()) {
					NodeLabel2.setVisible(true);
					NodeLabel3.setVisible(true);
					NodeLabel4.setVisible(true);
					NodeLabel5.setVisible(true);

					Tnode2.setVisible(true);
					Tnode3.setVisible(true);
					Tnode4.setVisible(true);
					Tnode5.setVisible(true);

				} else {
					NodeLabel2.setVisible(false);
					NodeLabel3.setVisible(false);
					NodeLabel4.setVisible(false);
					NodeLabel5.setVisible(false);

					Tnode2.setVisible(false);
					Tnode3.setVisible(false);
					Tnode4.setVisible(false);
					Tnode5.setVisible(false);

				}
			}
		});
		SuccessPanel.add(Checkbox);
		
		

		BackButton.setVisible(false);

		SuccessPanel.setLayout(null);

		T1 = new JTextField();
		T1.setBounds(0, 832, 1300, 132);
		SuccessPanel.add(T1);
		
		logArea = new JTextArea();
		logArea.setBounds(0,700,1300,133);
		SuccessPanel.add(logArea);
		
		scrollPane = new JScrollPane(logArea);
		scrollPane.setBounds(0,700,1300,133);
		SuccessPanel.add(scrollPane);
		
		

		szakdolgozat.Jtree.jtree();

		SuccessFrame.setVisible(true);

	}

	public void actionPerformed(ActionEvent evt) {
		parentNode = new DefaultMutableTreeNode("parent");
		childNode = new DefaultMutableTreeNode("child");
		
		if (evt.getSource() == NewParentNode) {
			NewParentNode.setVisible(false);
			NewChildNode.setVisible(false);
			RemoveParentNode.setVisible(false);
			RemoveChildNode.setVisible(false);
			BackButton.setVisible(true);
			GetInfo.setVisible(true);
			AddNode.setVisible(true);
			Checkbox.setVisible(true);
			NodeLabel.setVisible(true);
			Tnode.setVisible(true);
			AdditionalNodeLabel.setVisible(true);
			AdditionalNodeLabel.setText("Do you want to add child nodes? ");
			


		} else if (evt.getSource() == NewChildNode) {
			NewParentNode.setVisible(false);
			NewChildNode.setVisible(false);
			RemoveParentNode.setVisible(false);
			RemoveChildNode.setVisible(false);
			BackButton.setVisible(true);
			GetInfo.setVisible(true);
			AddChildNode.setVisible(true);
			AddChildNode.setBounds(600,500,200,100);
			Checkbox.setVisible(true);
			AdditionalNodeLabel.setVisible(true);
			AdditionalNodeLabel.setText("Do you want to add more nodes?");
			NodeLabel.setVisible(true);
			Tnode.setVisible(true);

		} else if (evt.getSource() == RemoveParentNode) {
			Jtree.removeNode();

		} else if (evt.getSource() == RemoveChildNode) {
			Jtree.removeChildNode();

		} else if (evt.getSource() == BackButton) {
			NewParentNode.setVisible(true);
			NewChildNode.setVisible(true);
			RemoveParentNode.setVisible(true);
			RemoveChildNode.setVisible(true);
			BackButton.setVisible(false);
			GetInfo.setVisible(false);
			AddNode.setVisible(false);
			AddChildNode.setVisible(false);
			resetLabel();

		} else if (evt.getSource() == RunQueryButton) {
			String querry = T1.getText();
			String comand = getFirstWord(querry);
			Jdbc.JdbcNodeCounter(querry, comand);

		} else if (evt.getSource() == DeleteTextButton) {
			nodecount = 0;
			T1.setText("");

		} else if (evt.getSource() == GetInfo) {
			Tnode.setEditable(true);
			Tnode2.setEditable(true);
			Tnode3.setEditable(true);
			Tnode4.setEditable(true);
			Tnode5.setEditable(true);

			temp = Tnode.getText();
			temp2 = Tnode2.getText();
			temp3 = Tnode3.getText();
			temp4 = Tnode4.getText();
			temp5 = Tnode5.getText();
			
			Tnode.setText("");
			Tnode2.setText("");
			Tnode3.setText("");
			Tnode4.setText("");
			Tnode5.setText("");

		} else if (evt.getSource() == AddNode) {
			if (temp.equals("")) {
				logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
			} else {
				AddChildNode.setVisible(true);
				AddChildNode.setBounds(800,500,200,100);
				NodeLabel.setText("New Child name");
				Jtree.newParentNode(temp);
				parentNode.setUserObject(temp);
				childNode.setUserObject(temp);
				parentNode.add(childNode);
			} 
				
		}	else if (evt.getSource() == AddChildNode) {
		
			
			if (Checkbox.isSelected()) {
				if (temp.equals("")) {
					logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
				} else
					Jtree.newChildNode(temp);
				if (temp2.equals("")) {
					logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
				} else
					Jtree.newChildNode(temp2);
				if (temp3.equals("")) {
					logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
				} else
					Jtree.newChildNode(temp3);
				if (temp4.equals("")) {
					logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
				} else
					Jtree.newChildNode(temp4);
				if (temp5.equals("")) {
					logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
				} else
					Jtree.newChildNode(temp5);

			} else if (temp.equals("")) {
				logArea.append("Empty name field, node won't be added" + formatter.format(date)+ "\n");
			} else
				Jtree.newChildNode(temp);

		}

	}

	public static void resetLabel() {

		NodeLabel2.setVisible(false);
		NodeLabel3.setVisible(false);
		NodeLabel4.setVisible(false);
		NodeLabel5.setVisible(false);

		Checkbox.setVisible(false);

		Tnode2.setVisible(false);
		Tnode3.setVisible(false);
		Tnode4.setVisible(false);
		Tnode5.setVisible(false);

		Tnode.setText("");
		Tnode2.setText("");
		Tnode3.setText("");
		Tnode4.setText("");
		Tnode5.setText("");

		Checkbox.setSelected(false);
		AddNode.setVisible(false);
		AddChildNode.setVisible(false);
		GetInfo.setVisible(false);
		
		NodeLabel.setText("New Node name");
	}

	public static class RoundBtn implements Border {
		private int r;

		RoundBtn(int r) {
			this.r = r;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
		}

		public boolean isBorderOpaque() {
			return true;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, r, r);
		}
	}

	private String getFirstWord(String text) {

		int index = text.indexOf(' ');

		if (index > -1) {

			return text.substring(0, index).trim();

		} else {

			return text;
		}
	}

}
