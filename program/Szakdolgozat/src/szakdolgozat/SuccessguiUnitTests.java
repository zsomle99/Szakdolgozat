package szakdolgozat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SuccessguiUnitTests {

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
	final void testActionPerformed() {
		Successgui.successgui();
		Successgui.NewParentNode.doClick();
		assertEquals(false,Successgui.NewParentNode.isVisible());
		assertEquals(false,Successgui.NewChildNode.isVisible());
		assertEquals(false,Successgui.RemoveParentNode.isVisible());
		assertEquals(false,Successgui.RemoveChildNode.isVisible());
		assertEquals(true,Successgui.BackButton.isVisible());
		assertEquals(true,Successgui.GetInfo.isVisible());
		assertEquals(true,Successgui.AddNode.isVisible());
		assertEquals(true,Successgui.Checkbox.isVisible());
		assertEquals(true,Successgui.NodeLabel.isVisible());
		assertEquals(true,Successgui.Tnode.isVisible());
		assertEquals(true,Successgui.AdditionalNodeLabel.isVisible());
		assertEquals("Do you want to add child nodes? ", Successgui.AdditionalNodeLabel.getText());
		
		Successgui.NewChildNode.doClick();
		assertEquals(false,Successgui.NewParentNode.isVisible());
		assertEquals(false,Successgui.NewChildNode.isVisible());
		assertEquals(false,Successgui.RemoveParentNode.isVisible());
		assertEquals(false,Successgui.RemoveChildNode.isVisible());
		assertEquals(true,Successgui.BackButton.isVisible());
		assertEquals(true,Successgui.GetInfo.isVisible());
		assertEquals(true,Successgui.AddChildNode.isVisible());
		assertEquals(true,Successgui.Checkbox.isVisible());
		assertEquals(true,Successgui.NodeLabel.isVisible());
		assertEquals(true,Successgui.Tnode.isVisible());
		assertEquals(true,Successgui.AdditionalNodeLabel.isVisible());
		assertEquals("Do you want to add more nodes?", Successgui.AdditionalNodeLabel.getText());
		
		
		Successgui.BackButton.doClick();
		assertEquals(true,Successgui.NewParentNode.isVisible());
		assertEquals(true,Successgui.NewChildNode.isVisible());
		assertEquals(true,Successgui.RemoveParentNode.isVisible());
		assertEquals(true,Successgui.RemoveChildNode.isVisible());
		assertEquals(false,Successgui.BackButton.isVisible());
		assertEquals(false,Successgui.GetInfo.isVisible());
		assertEquals(false,Successgui.AddNode.isVisible());
		assertEquals(false,Successgui.AddChildNode.isVisible());
		testResetLabel();
		
	}

	@Test
	final void testSuccessgui() {
		Successgui.successgui();
		assertEquals(true,Successgui.SuccessPanel.isVisible());
		assertEquals(true,Successgui.SuccessFrame.isVisible());
		assertEquals(true,Successgui.NewParentNode.isVisible());
		assertEquals(true,Successgui.NewChildNode.isVisible());
		assertEquals(true,Successgui.RemoveParentNode.isVisible());
		assertEquals(true,Successgui.RemoveChildNode.isVisible());
		assertEquals(false,Successgui.BackButton.isVisible());
		assertEquals(true,Successgui.DeleteTextButton.isVisible());
		assertEquals(true,Successgui.RunQueryButton.isVisible());
		assertEquals(false,Successgui.GetInfo.isVisible());
		assertEquals(false,Successgui.AddNode.isVisible());
		assertEquals(false,Successgui.AddChildNode.isVisible());
		assertEquals(false,Successgui.NodeLabel.isVisible());
		assertEquals(false,Successgui.NodeLabel2.isVisible());
		assertEquals(false,Successgui.NodeLabel3.isVisible());
		assertEquals(false,Successgui.NodeLabel4.isVisible());
		assertEquals(false,Successgui.NodeLabel5.isVisible());
		assertEquals(false,Successgui.AdditionalNodeLabel.isVisible());
		assertEquals(false,Successgui.Tnode.isVisible());
		assertEquals(false,Successgui.Tnode2.isVisible());
		assertEquals(false,Successgui.Tnode3.isVisible());
		assertEquals(false,Successgui.Tnode4.isVisible());
		assertEquals(false,Successgui.Tnode5.isVisible());
		assertEquals(false,Successgui.Checkbox.isVisible());
		assertEquals(true,Successgui.T1.isVisible());
		assertEquals(true,Successgui.logArea.isVisible());
		
	}
	
	@Test
	final void testcheckboxclicked() {
		Successgui.successgui();
		Successgui.NewParentNode.doClick();
		Successgui.Checkbox.doClick();
		
		assertEquals(true,Successgui.AdditionalNodeLabel.isVisible());
		assertEquals(true,Successgui.NodeLabel.isVisible());
		assertEquals(true,Successgui.NodeLabel2.isVisible());
		assertEquals(true,Successgui.NodeLabel3.isVisible());
		assertEquals(true,Successgui.NodeLabel4.isVisible());
		assertEquals(true,Successgui.NodeLabel5.isVisible());
		
		assertEquals(true,Successgui.Tnode.isVisible());
		assertEquals(true,Successgui.Tnode2.isVisible());
		assertEquals(true,Successgui.Tnode3.isVisible());
		assertEquals(true,Successgui.Tnode4.isVisible());
		assertEquals(true,Successgui.Tnode5.isVisible());
		
		Successgui.Checkbox.doClick();
		
		assertEquals(true,Successgui.AdditionalNodeLabel.isVisible());
		assertEquals(true,Successgui.NodeLabel.isVisible());
		assertEquals(false,Successgui.NodeLabel2.isVisible());
		assertEquals(false,Successgui.NodeLabel3.isVisible());
		assertEquals(false,Successgui.NodeLabel4.isVisible());
		assertEquals(false,Successgui.NodeLabel5.isVisible());
		
		assertEquals(true,Successgui.Tnode.isVisible());
		assertEquals(false,Successgui.Tnode2.isVisible());
		assertEquals(false,Successgui.Tnode3.isVisible());
		assertEquals(false,Successgui.Tnode4.isVisible());
		assertEquals(false,Successgui.Tnode5.isVisible());
	}

	@Test
	final void testResetLabel() {
		Successgui.resetLabel();
		assertEquals(false,Successgui.NodeLabel3.isVisible());
		assertEquals(false,Successgui.NodeLabel2.isVisible());
		assertEquals(false,Successgui.NodeLabel4.isVisible());
		assertEquals(false,Successgui.NodeLabel5.isVisible());
		assertEquals(false,Successgui.Checkbox.isVisible());
		assertEquals(false,Successgui.Tnode2.isVisible());
		assertEquals(false,Successgui.Tnode3.isVisible());
		assertEquals(false,Successgui.Tnode4.isVisible());
		assertEquals(false,Successgui.Tnode5.isVisible());
		assertEquals(false,Successgui.Checkbox.isSelected());
		assertEquals(false,Successgui.AddNode.isVisible());
		assertEquals(false,Successgui.AddChildNode.isVisible());
		assertEquals(false,Successgui.GetInfo.isVisible());
		assertEquals("New Node name",Successgui.NodeLabel.getText());
		assertEquals("",Successgui.Tnode.getText());
		assertEquals("",Successgui.Tnode2.getText());
		assertEquals("",Successgui.Tnode3.getText());
		assertEquals("",Successgui.Tnode4.getText());
		assertEquals("",Successgui.Tnode5.getText());
		
	}

}
