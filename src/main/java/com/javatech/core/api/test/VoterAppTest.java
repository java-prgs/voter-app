package com.javatech.core.api.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.javatech.core.api.beans.Voter;

public class VoterAppTest {
	public static List<Voter> createVoter() {
		List<Voter> voters = new ArrayList<>();
		voters.add(new Voter("John", 2000));
		voters.add(new Voter("Mathew", 2000));
		voters.add(new Voter("Smith", 1400));
		voters.add(new Voter("Sreya", 2000));
		voters.add(new Voter("Kartik", 1400));
		voters.add(new Voter("Resma", 2000));
		voters.add(new Voter("Nitin", 3000));
		voters.add(new Voter("Misti", 3000));
		return voters;
	}

	public static void showWinner() {
		List<Voter> voters = createVoter();

		// Converting voter List into Map
		Map<String, Integer> voterMap = voters.stream().collect(Collectors.toMap(Voter::getName, Voter::getNoOfVotes));
		System.out.println("List of voters participate in election with there no of votes:" + voterMap);
		Set<Entry<String, Integer>> set = voterMap.entrySet();
		List<Entry<String, Integer>> voterList = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort(voterList, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		//To get the voters who have same number of votes.

		List<Entry<String, Integer>> winnerList = new ArrayList<>();
		Entry<String, Integer> prev = voterList.get(0);

		Entry<String, Integer> next = voterList.get(1);

		winnerList.add(prev);

		for (int i = 2; i < voterList.size(); i++) {

			if (prev.getValue().equals(next.getValue())) {

				winnerList.add(next);

				next = voterList.get(i);

			} else {
				break;
			}

		}
		//To get the winner from voters who has same number of votes

		Collections.sort(winnerList, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		Entry<String, Integer> winnerName = winnerList.get(winnerList.size() - 1);
		System.out.println("Winner Name is:"+winnerName.getKey());
	}

	public static void main(String[] args) {
		showWinner();

	}
}
