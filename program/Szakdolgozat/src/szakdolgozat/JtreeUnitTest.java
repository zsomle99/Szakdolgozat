package szakdolgozat;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JtreeUnitTest extends gui {

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
	final void testNewParentNode() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		String name = "new";
		
		Jtree.tree = new JTree(Administrator);
		Jtree.newParentNode(name);
		assertEquals(3,Administrator.getChildCount());
	}

	@Test
	final void testNewChildNode() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		String name = "new";
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Client.getPath()));
		Jtree.newChildNode(name);
		
		assertEquals(1,Client.getChildCount());
		
	}

	@Test
	final void testRemoveNode() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Client.getPath()));
		Jtree.removeNode();
		assertEquals(1,Administrator.getChildCount());
	}

	@Test
	final void testRemoveChildNode() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		DefaultMutableTreeNode Email2 = new DefaultMutableTreeNode("Email");
		Email.add(Email2);
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Email2.getPath()));
		Jtree.removeChildNode();
		assertEquals(0,Email.getChildCount());
	}
	
	@Test
	final void testRemoveChildNodeElse() {
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		logArea = new JTextArea();
		
		Administrator.add(Email);
		Administrator.add(Client);
		DefaultMutableTreeNode Email2 = new DefaultMutableTreeNode("Email");
		Email.add(Email2);
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Email.getPath()));
		Jtree.removeChildNode();
		assertEquals("Not a child node, please use Remove Node to delete this node! " + formatter.format(date) + "\n",logArea.getText());
	}

	@Test
	final void testChildNodeCounter() {
		
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		
		Administrator.add(Email);
		Administrator.add(Client);
		
		Jtree.tree = new JTree(Administrator);
		Jtree.tree.setSelectionPath(new TreePath(Administrator.getPath()));
		Jtree.ChildNodeCounter();
		
		assertEquals(2,Administrator.getChildCount());
	}


	@Test
	final void testJdbc() {
		
		String sql = "Select * from Client";
		String column = "ID";

		logArea = new JTextArea("");
		
		Jtree.jdbc(sql, column);
		
		assertEquals("1,  2,  3,  4,  5,  " + formatter.format(date) + "\n",logArea.getText());
		
	}

}
