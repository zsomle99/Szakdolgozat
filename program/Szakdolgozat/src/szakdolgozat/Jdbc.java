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
								
							}
						}
						logArea.append(name + formatter.format(date) + "\n");
					} else {
						while (rs.next()) {
							for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
								name = name + rs.getString(i) + ", ";
								name = name + "\n";
								
							}
						} logArea.append(name + formatter.format(date) + "\n");
					}

					break;
				case ("Update"):
					int rownumber;
					rownumber = stmt.executeUpdate(sql);
					if (rownumber > 0) {
						logArea.append(rownumber + "row(s) have been updated" + formatter.format(date) + "\n");
					} else
						logArea.append("No changes were made" + formatter.format(date) + "\n");
					break;

				case ("Delete"):
					int number;
					number = stmt.executeUpdate(sql);
					if (number > 0) {
						logArea.append(number + "row(s) have been updated" + formatter.format(date) + "\n");
					} else
						logArea.append("No changes were made" + formatter.format(date) + "\n");
					break;
				case ("Alter"):
					int number2;
					number2 = stmt.executeUpdate(sql);
					if (number2 == 0) {
						logArea.append("The table was altered" + formatter.format(date) + "\n");
					} else
						logArea.append("No changes were made" + formatter.format(date) + "\n");
					break;
				case ("Insert"):
					int number3;
					number3 = stmt.executeUpdate(sql);
					if (number3 > 0) {
						logArea.append(number3 + "row(s) have been updated" + formatter.format(date) + "\n");
					} else
						logArea.append("No changes were made" + formatter.format(date) + "\n");
					break;

				case ("Create"):
					int number4;
					number4 = stmt.executeUpdate(sql);
					if (number4 == 0) {
						
						logArea.append("The table was created" + formatter.format(date) + "\n");
					}
					else
						logArea.append("Something is wrong" + formatter.format(date) + "\n");
					break;

				case ("Drop"):
					int number5;
					number5 = stmt.executeUpdate(sql);
					if (number5 == 0)
						logArea.append("The table was dropped" + formatter.format(date) + "\n");
					else
						logArea.append("Something is wrong" + formatter.format(date) + "\n");
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
