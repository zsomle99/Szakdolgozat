package szakdolgozat;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class JdbcUnitTests extends gui {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1)
	final void testJdbcNodeCounterSelect() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		
		Jtree.tree = new JTree(Administrator);
		String sql = "Select * from Client";
		String command = "Select";
		
		logArea = new JTextArea();
		T1 = new JTextField();
		
		T1.setText(sql);
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("1, \n"
				+ "Kiss János, \n"
				+ "Miskolc, \n"
				+ "1992-04-10, \n"
				+ "2, \n"
				+ "Szende Pál, \n"
				+ "Nyiregyháza, \n"
				+ "1988-02-10, \n"
				+ "3, \n"
				+ "Nagy Benedek, \n"
				+ "Eger, \n"
				+ "1967-11-10, \n"
				+ "4, \n"
				+ "Sipos Petra, \n"
				+ "Miskolc, \n"
				+ "1994-03-12, \n"
				+ "5, \n"
				+ "Kovács Tamás, \n"
				+ "Debrecen, \n"
				+ "1999-06-16, \n"
				+ formatter.format(date) + "\n",logArea.getText());
		
	}
	
	@Test
	@Order(2)
	final void testJdbcNodeCounterSelect_v2() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Client.getPath()));
		String sql = "Select * from Client";
		String command = "Select";
		
		logArea = new JTextArea();
		T1 = new JTextField();
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("1, \n"
				+ "Kiss János, \n"
				+ "Miskolc, \n"
				+ "1992-04-10, \n"
				+ "2, \n"
				+ "Szende Pál, \n"
				+ "Nyiregyháza, \n"
				+ "1988-02-10, \n"
				+ "3, \n"
				+ "Nagy Benedek, \n"
				+ "Eger, \n"
				+ "1967-11-10, \n"
				+ "4, \n"
				+ "Sipos Petra, \n"
				+ "Miskolc, \n"
				+ "1994-03-12, \n"
				+ "5, \n"
				+ "Kovács Tamás, \n"
				+ "Debrecen, \n"
				+ "1999-06-16, \n"
				+ formatter.format(date) + "\n",logArea.getText());
		
	}
	@Test
	@Order(3)
	final void testJdbcNodeCounterUpdate() {
		String sql = "Update Client set name= 'Kiss János' where ID=1;";
		String command = "Update";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("1row(s) have been updated"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	@Test
	@Order(4)
	final void testJdbcNodeCounterUpdate_v2() {
		String sql = "Update Client set name= 'Kiss János' where name = 'Kisss János';";
		String command = "Update";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("No changes were made"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	@Test
	@Order(5)
	final void testJdbcNodeCounterCreate() {
		String sql = "Create table B (id int, id2 int);";
		String command = "Create";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("The table was created"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	
	@Test
	@Order(6)
	final void testJdbcNodeCounterAlter() {
		String sql = "Alter table B add id3 int";
		String command = "Alter";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("The table was altered"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	
	@Test
	@Order(7)
	final void testJdbcNodeCounterInsert() {
		String sql = "Insert into B (id, id2, id3) values (1,2,3);";
		String command = "Insert";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("1row(s) have been updated"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	
	
	@Test
	@Order(8)
	final void testJdbcNodeCounterDelete() {
		String sql = "Delete from B where id = 1";
		String command = "Delete";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("1row(s) have been updated"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	
	@Test
	@Order(9)
	final void testJdbcNodeCounterDrop() {
		String sql = "Drop table B";
		String command = "Drop";
		
		logArea = new JTextArea();
		
		
		Jdbc.JdbcNodeCounter(sql, command);
		
		assertEquals("The table was dropped"+ formatter.format(date) + "\n",logArea.getText());
		
	}
	

}
