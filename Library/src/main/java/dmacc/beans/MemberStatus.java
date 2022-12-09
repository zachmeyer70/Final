package dmacc.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Class to sort members based on the status
public class MemberStatus {
	List<Member> members;
	
	//Constructor with list passed in
	public MemberStatus(List<Member> members) {
		this.members=members;
	}
	
	//method to sort members based on status
	//list of members is passed in
	public List<Member> findStatus(List<Member> members){
		//creating list to pass back
		List<Member> newList = new ArrayList<Member>();
		//creating priortyQueue to sort list based on status
		PriorityQueue<Member> pqm = new PriorityQueue<>();
		// adds member to priority queue
		pqm.addAll(members);
		//loop while priority queue isnt empty removes first member from queue
		// adds to list
		while(!pqm.isEmpty()) {
			newList.add(pqm.poll());
		}
		return newList;
	}
}
