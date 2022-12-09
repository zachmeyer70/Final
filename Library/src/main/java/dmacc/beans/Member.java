package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//creates no argument constructor using lombok
@NoArgsConstructor
// creates getters and setters using lombok
@Data
public class Member implements Comparable<Member>{
	//sets id as primary key
	@Id
	//sets id based of sequence created by database
	@GeneratedValue
	private long id;
	private String name;
	private String address;
	private String city;
	//variable used to compare for priority queue
	//should only be 1 or 0
	private int status;
	
	public Member(int id, String name, String address) {
		this.id = id;
		this.name=name;
		this.address=address;
	}
	
	// method to compare members based off status
	@Override
	public int compareTo(Member m) {
		if(this.getStatus()> m.getStatus()) {
			return 1;
		} else if(this.getStatus() < m.getStatus()) {
			return -1;
		} else {
			return 0;
		}
	}	
	
	// check status method
	public void checkStatus() {
		// if the status is 1 or greater set status to 1
		if(this.status >= 1) {
			status = 1;
		//if status is less than 1 set to 0
		}else if(status >1) {
			status = 0;
		}
	}
	// custom setter for status that calls set status when method is called
	public void setStatus(int status) {
		this.status = status;
		checkStatus();
	}
	
}
