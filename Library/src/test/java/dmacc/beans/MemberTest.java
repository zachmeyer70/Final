package dmacc.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {

	

	@Test
	void testMemberName() {
		Member m = new Member();
		m.setName("Zach");
		assertEquals(m.getName(), "Zach");
	}
	
	@Test
	void TestMemberAddress() {
		Member m = new Member();
		m.setAddress("123 Main St");
		assertEquals(m.getAddress(), "123 Main St");
	}
	
	@Test
	void TestMemberStatus() {
		Member m = new Member();
		m.setStatus(0);
		assertEquals(m.getStatus(), 0);
	}
	@Test
	void TestMemberBelowStatusLimit() {
		Member m = new Member();
		m.setStatus(-1);
		assertEquals(m.getStatus(), 0);
	}
	@Test
	void TestMemberAboveStatusLimity() {
		Member m = new Member();
		m.setStatus(2);
		assertEquals(m.getStatus(), 1);
	}
	@Test
	void TestMemberId() {
		Member m = new Member();
		m.setId(1);
		assertEquals(m.getId(), 1);
	}
	@Test 
	void TestStatusCheck(){
		Member m = new Member();
		Member m1 = new Member();
		m.setStatus(1);
		m1.setStatus(0);
		List<Member> member = new ArrayList<>();
		member.add(m);
		member.add(m1);
		MemberStatus ms = new MemberStatus(member);
		member=ms.findStatus(member);
		assertEquals(member.get(0).getStatus(), 0);	
	}

}
