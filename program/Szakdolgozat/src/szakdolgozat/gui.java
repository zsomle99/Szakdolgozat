package szakdolgozat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class gui implements ActionListener {

	protected static JTextField loginusertext;
	protected static JTextField T1;
	protected static JTextField Tnode;
	protected static JTextField Tnode2;
	protected static JTextField Tnode3;
	protected static JTextField Tnode4;
	protected static JTextField Tnode5;
	
	protected static JTextArea logArea;
	
	protected static JPasswordField loginpasswordtext;
	
	protected static JCheckBox Checkbox;

	protected static JLabel LoginSuccessLabel;
	protected static JLabel SuccessGuiLabel;
	protected static JLabel loginPasswordlabel;
	protected static JLabel loginUserlabel;
	
	protected static JLabel NodeLabel;
	protected static JLabel NodeLabel2;
	protected static JLabel NodeLabel3;
	protected static JLabel NodeLabel4;
	protected static JLabel NodeLabel5;
	protected static JLabel AdditionalNodeLabel;
	
	static DefaultMutableTreeNode node;
	static DefaultMutableTreeNode parentNode;
	static DefaultMutableTreeNode childNode;
	

	protected static JPanel loginPanel;
	protected static JPanel SuccessPanel;

	protected static JButton loginButton;
	protected static JButton SuccessButton;

	protected static JButton NewParentNode;
	protected static JButton NewChildNode;
	protected static JButton RemoveParentNode;
	protected static JButton RemoveChildNode;
	protected static JButton BackButton;

	protected static JButton DeleteTextButton;
	protected static JButton RunQueryButton;
	
	protected static JButton GetInfo;
	protected static JButton AddChildNode;
	protected static JButton AddNode;


	protected static JFrame loginFrame;
	protected static JFrame SuccessFrame;

	protected static JFrame JtreeFrame;

	protected static JScrollPane sp;
	protected static JScrollPane scrollPane;

	protected static JTree tree;
	
	protected static String temp = "";
	protected static String temp2 = "";
	protected static String temp3 = "";
	protected static String temp4 = "";
	protected static String temp5 = "";
	
	protected static Date date = new Date();
	
	protected static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
	
	protected static int nodecount;


	public static void logingui() {

		loginPanel = new JPanel();
		loginFrame = new JFrame();
		loginFrame.setSize(350, 200);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.add(loginPanel);

		loginPanel.setLayout(null);

		loginUserlabel = new JLabel("User");
		loginUserlabel.setBounds(10, 20, 80, 25);
		loginPanel.add(loginUserlabel);

		loginusertext = new JTextField(20);
		loginusertext.setBounds(100, 20, 165, 25);
		loginPanel.add(loginusertext);

		loginPasswordlabel = new JLabel("Password");
		loginPasswordlabel.setBounds(10, 50, 80, 25);
		loginPanel.add(loginPasswordlabel);

		loginpasswordtext = new JPasswordField();
		loginpasswordtext.setBounds(100, 50, 165, 25);
		loginPanel.add(loginpasswordtext);

		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(new gui());
		loginPanel.add(loginButton);

		LoginSuccessLabel = new JLabel("");
		LoginSuccessLabel.setBounds(10, 110, 300, 25);
		loginPanel.add(LoginSuccessLabel);
		LoginSuccessLabel.setText(null);

		loginFrame.setVisible(true);

	}

	public static void main(String[] args) {

		logingui();



	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String user = loginusertext.getText();
		@SuppressWarnings("deprecation")
		String password = loginpasswordtext.getText();

		if (user.equals("test") && password.equals("test123")) {
			LoginSuccessLabel.setText("Login successful");
			loginFrame.setVisible(false);
			Successgui.successgui();
		} else
			LoginSuccessLabel.setText("Login failed");
	}
	

	
}
