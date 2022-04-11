package szakdolgozat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc extends gui {
	
	public static void JdbcNodeCounter(String sql, String command) {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;database=SzakdolgozatDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
			conn = DriverManager.getConnection(url);

			Statement stmt = null;
			String query = sql;
			try {
				stmt = conn.createStatement();
				switch (command) {
				case ("Select"):
					ResultSet rs = stmt.executeQuery(query);
					String name = "";

					if (T1.getText() == sql)
						nodecount = 0;
					else
						nodecount = szakdolgozat.Jtree.ChildNodeCounter();

					if (nodecount >= 1) {
						while (rs.next()) {
							for (int i = 1; i < nodecount + 1; i++) {
								name = name + rs.getString(i) + " | ";
								T1.setText(name);
							}
						}
					} else {
						while (rs.next()) {
							for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
								name = name + rs.getString(i) + ", ";
								name = name + "\n";
								T1.setText(name);
							}
						}
					}

					break;
				case ("Update"):
					int rownumber;
					rownumber = stmt.executeUpdate(sql);
					if (rownumber > 0) {
						T1.setText(rownumber + "row(s) have been updated");
					} else
						T1.setText("No changes were made");
					break;

				case ("Remove"):
					int number;
					number = stmt.executeUpdate(sql);
					if (number > 0) {
						T1.setText(number + "row(s) have been updated");
					}
					break;
				case ("Alter"):
					int number2;
					number2 = stmt.executeUpdate(sql);
					if (number2 > 0) {
						T1.setText(number2 + "row(s) have been updated");
					} else
						T1.setText("No changes were made");
					break;
				case ("Insert"):
					int number3;
					number3 = stmt.executeUpdate(sql);
					if (number3 > 0) {
						T1.setText(number3 + "row(s) have been updated");
					} else
						T1.setText("No changes were made");
					break;

				case ("Create"):
					int number4;
					number4 = stmt.executeUpdate(sql);
					if (number4 == 0) {
						
						T1.setText("The table was created");
					}
					else
						T1.setText("Something is wrong");
					break;

				case ("Drop"):
					int number5;
					number5 = stmt.executeUpdate(sql);
					if (number5 == 0)
						T1.setText("The table was dropped");
					else
						T1.setText("Something is wrong");
					break;

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
			
		}
		
		finally {
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
