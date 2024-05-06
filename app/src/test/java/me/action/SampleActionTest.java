package me.action;

import static org.junit.jupiter.api.Assertions.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SampleActionTest {

	public static void main(String[] args) {}

	@Test
    @DisplayName("名字と名前を入力した場合")
	public void testCheckNormal() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn("lastName");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(true, result);
	}

	@Test
    @DisplayName("名字がNULLの場合")
	public void testCheckError1() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}

	@Test
    @DisplayName("名字は正常、名前がNULLの場合")
	public void testCheckError2() {
		HttpServletRequest request = createMock(HttpServletRequest.class);
		SampleAction action = new SampleAction();

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}
	
	@Test
    @DisplayName("空の名前のみの場合")
	public void testCheckError3() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}

	@Test
    @DisplayName("SampleActionが名字と名前を受け取る場合")
	public void testExecuteNormal() {
		SampleAction action = new SampleAction("firstName", "lastName");
		HttpServletRequest request = createMock(HttpServletRequest.class);
		HttpSession session = createMock(HttpSession.class);

		expect(request.getSession(true)).andReturn(session);

		replay(request);
		String result = action.execute(request);
		verify(request);

		assertTrue("./WEB-INF/result.jsp".equals(result));
	}
}
