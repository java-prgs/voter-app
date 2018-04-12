package com.javatech.core.api.beans;

public class Voter {
	private String name;
	private int noOfVotes;

	public Voter() {
	}

	public Voter(String name, int noOfVotes) {

		this.name = name;
		this.noOfVotes = noOfVotes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(int noOfVotes) {
		this.noOfVotes = noOfVotes;
	}

}
