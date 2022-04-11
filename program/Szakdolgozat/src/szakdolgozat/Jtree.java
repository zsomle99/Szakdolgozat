package szakdolgozat;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jtree extends gui {
	
	static DefaultMutableTreeNode node;

	public static void jtree() {

		node = new DefaultMutableTreeNode("SzakdolgozatDB");
		DefaultMutableTreeNode Administrator = new DefaultMutableTreeNode("Administrator");
		DefaultMutableTreeNode Client = new DefaultMutableTreeNode("Client");
		DefaultMutableTreeNode Email = new DefaultMutableTreeNode("Email");
		DefaultMutableTreeNode EmailAM = new DefaultMutableTreeNode("EmailAM");
		DefaultMutableTreeNode Error = new DefaultMutableTreeNode("Error");
		DefaultMutableTreeNode Error_Messages = new DefaultMutableTreeNode("Error_Messages");
		DefaultMutableTreeNode Internet = new DefaultMutableTreeNode("Internet");
		DefaultMutableTreeNode Mail = new DefaultMutableTreeNode("Mail");
		DefaultMutableTreeNode Manager = new DefaultMutableTreeNode("Manager");
		DefaultMutableTreeNode PhoneAC = new DefaultMutableTreeNode("PhoneAC");
		DefaultMutableTreeNode PhoneAM = new DefaultMutableTreeNode("PhoneAM");
		DefaultMutableTreeNode PhoneCE = new DefaultMutableTreeNode("PhoneCE");
		DefaultMutableTreeNode TV = new DefaultMutableTreeNode("TV");

		node.add(Administrator);
		node.add(Client);
		node.add(Email);
		node.add(EmailAM);
		node.add(Error);
		node.add(Error_Messages);
		node.add(Internet);
		node.add(Mail);
		node.add(Manager);
		node.add(PhoneAC);
		node.add(PhoneAM);
		node.add(PhoneCE);
		node.add(TV);

		DefaultMutableTreeNode AdminID = new DefaultMutableTreeNode("ID");
		DefaultMutableTreeNode AdminName = new DefaultMutableTreeNode("Name");
		DefaultMutableTreeNode AdminLevelOfAdministrator = new DefaultMutableTreeNode("Level of Administrator");
		DefaultMutableTreeNode AdminPosition = new DefaultMutableTreeNode("Position");
		DefaultMutableTreeNode AdminEmail = new DefaultMutableTreeNode("Email");

		DefaultMutableTreeNode ClientID = new DefaultMutableTreeNode("ID");
		DefaultMutableTreeNode ClientName = new DefaultMutableTreeNode("Name");
		DefaultMutableTreeNode ClientPlaceOfBirth = new DefaultMutableTreeNode("Place of Birth");
		DefaultMutableTreeNode ClientDateOfBirth = new DefaultMutableTreeNode("Date of Birth");

		DefaultMutableTreeNode EmailCID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode EmailMID = new DefaultMutableTreeNode("Manager ID");

		DefaultMutableTreeNode EMAILAMAID = new DefaultMutableTreeNode("Administrator ID");
		DefaultMutableTreeNode EmailAMMID = new DefaultMutableTreeNode("Manager ID");

		DefaultMutableTreeNode ErrorID = new DefaultMutableTreeNode("ID");
		DefaultMutableTreeNode ErrorSince = new DefaultMutableTreeNode("Since");
		DefaultMutableTreeNode ErrorOccurence = new DefaultMutableTreeNode("Occurence");

		DefaultMutableTreeNode Message = new DefaultMutableTreeNode("Error Messages");
		DefaultMutableTreeNode ErrorMessageID = new DefaultMutableTreeNode("ID");

		DefaultMutableTreeNode InternetCID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode InternetEID = new DefaultMutableTreeNode("Error ID");

		DefaultMutableTreeNode MailCID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode MailMID = new DefaultMutableTreeNode("Manager ID");

		DefaultMutableTreeNode ManagerID = new DefaultMutableTreeNode("ID");
		DefaultMutableTreeNode ManagerName = new DefaultMutableTreeNode("Name");
		DefaultMutableTreeNode LevelOfManager = new DefaultMutableTreeNode("Level Of Manager");
		DefaultMutableTreeNode ManagerPosition = new DefaultMutableTreeNode("Position");

		DefaultMutableTreeNode PhoneACCID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode PhoneACAID = new DefaultMutableTreeNode("Administrator ID");
		DefaultMutableTreeNode PhoneACSince = new DefaultMutableTreeNode("Since");
		DefaultMutableTreeNode PhoneACUntil = new DefaultMutableTreeNode("Until");

		DefaultMutableTreeNode PhoneAMAID = new DefaultMutableTreeNode("Administrator ID");
		DefaultMutableTreeNode PhoneAMMID = new DefaultMutableTreeNode("Manager ID");
		DefaultMutableTreeNode PhoneAMSince = new DefaultMutableTreeNode("Since");
		DefaultMutableTreeNode PhoneAMUntil = new DefaultMutableTreeNode("Until");

		DefaultMutableTreeNode PhoneCECID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode PhoneCEEID = new DefaultMutableTreeNode("Error ID");

		DefaultMutableTreeNode TVCID = new DefaultMutableTreeNode("Client ID");
		DefaultMutableTreeNode TVEID = new DefaultMutableTreeNode("Error ID");

		TV.add(TVCID);
		TV.add(TVEID);
		PhoneCE.add(PhoneCECID);
		PhoneCE.add(PhoneCEEID);
		PhoneAM.add(PhoneAMAID);
		PhoneAM.add(PhoneAMMID);
		PhoneAM.add(PhoneAMUntil);
		PhoneAM.add(PhoneAMSince);
		PhoneAC.add(PhoneACCID);
		PhoneAC.add(PhoneACAID);
		PhoneAC.add(PhoneACSince);
		PhoneAC.add(PhoneACUntil);
		Manager.add(ManagerID);
		Manager.add(ManagerName);
		Manager.add(LevelOfManager);
		Manager.add(ManagerPosition);
		Mail.add(MailCID);
		Mail.add(MailMID);
		Internet.add(InternetCID);
		Internet.add(InternetEID);
		Error_Messages.add(Message);
		Error_Messages.add(ErrorMessageID);
		Error.add(ErrorID);
		Error.add(ErrorSince);
		Error.add(ErrorOccurence);
		EmailAM.add(EMAILAMAID);
		EmailAM.add(EmailAMMID);
		Email.add(EmailCID);
		Email.add(EmailMID);
		Client.add(ClientID);
		Client.add(ClientName);
		Client.add(ClientPlaceOfBirth);
		Client.add(ClientDateOfBirth);
		Administrator.add(AdminID);
		Administrator.add(AdminName);
		Administrator.add(AdminLevelOfAdministrator);
		Administrator.add(AdminPosition);
		Administrator.add(AdminEmail);
		
		tree = new JTree(node);
		tree.addTreeSelectionListener(listener());
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

		sp = new JScrollPane(tree);
		sp.setBounds(0, 0, 320, 600);
		SuccessPanel.add(sp);
	}

	public static void newParentNode(String name) {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(name);
		model.insertNodeInto(child, root, root.getChildCount());
		tree.scrollPathToVisible(new TreePath(child.getPath()));
		
		
	}
	
	public static void newChildNode(String name) {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(name);
		model.insertNodeInto(child, node, node.getChildCount());
		tree.scrollPathToVisible(new TreePath(child.getPath()));
	}
	
	public static void removeNode() {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		model.removeNodeFromParent(node);

	}
	
	public static void removeChildNode() {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode childnode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(childnode.isLeaf()) {
			model.removeNodeFromParent(childnode);
		}
		else
			T1.setText("Not a child node, please use Remove Node to delete this node!");
	}

	public static int ChildNodeCounter() {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		int nodecounter = 0;
		if (node == null)
			return 0;
		if (node.isNodeAncestor(node)) {
			nodecounter = node.getChildCount();
			return nodecounter;
		}
		if (node.isLeaf()) {
			nodecounter = node.getChildCount();
			return nodecounter;
		}
		return nodecounter;

	}

	static TreeSelectionListener listener() {
		TreeSelectionListener objTreeListener = new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if (node == null)
					// Nothing is selected.
					return;

				Object nodeInfo = node.getUserObject();
				if (node.isLeaf()) {
					System.out.println(node.toString());
					jdbc("select * from " + node.getParent().toString(), nodeInfo.toString());
				} else if (node.isNodeAncestor(node))
					Jdbc.JdbcNodeCounter("select * from " + node.toString(), "Select");
			}

		};
		return objTreeListener;
	}

	public static void jdbc(String sql, String column) {

		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;database=SzakdolgozatDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
			conn = DriverManager.getConnection(url);

			Statement stmt = null;
			String query = sql;

			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				String name = "";
				while (rs.next()) {
					name = name + rs.getString(column) + ",  ";
					T1.setText(name);

				}
			} catch (SQLException e) {
				throw new Error("Problem", e);
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}

		} catch (SQLException e) {
			throw new Error("Problem", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
