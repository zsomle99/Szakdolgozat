package szakdolgozat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuiUnitTests extends gui {

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
	final void testLogingui() {

		gui.logingui();
		assertEquals(true,gui.loginPanel.isVisible());
		assertEquals(true,gui.loginUserlabel.isVisible());
		assertEquals(true,gui.loginPasswordlabel.isVisible());
		assertEquals(true,gui.loginButton.isVisible());
		assertEquals("User",gui.loginUserlabel.getText());
		assertEquals("Password",gui.loginPasswordlabel.getText());
		assertEquals("Login",gui.loginButton.getText());
		
		
	}

	@Test
	final void testActionPerformed() {
		gui.logingui();
		loginusertext.setText("test");
		loginpasswordtext.setText("test123");
		loginButton.doClick();
		
		assertEquals("Login successful", LoginSuccessLabel.getText());
	}
	
	@Test
	final void testActionPerformed_fail() {
		gui.logingui();
		loginusertext.setText("test");
		loginpasswordtext.setText("test1234");
		loginButton.doClick();
		
		assertEquals("Login failed. Wrong password", LoginSuccessLabel.getText());
	}

}
