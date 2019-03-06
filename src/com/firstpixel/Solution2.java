package com.firstpixel;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

public class Solution2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("as2 aab bcc de3");
		list.add("as1 aab bcc de3");
		list.add("as1 zab bcc de3");
		list.add("as2 3vb bcc de3");
		list.add("zz2 a3w bcc de3");
		
		List<Line> listLine = new ArrayList<Line>();
		for(String str : list ) {
			String ident = str.split(" ")[0];
			listLine.add(new Line(ident,str.substring(ident.length(), str.length())));
		}
		

		List<String> listResult = Solution2.orderLogs(listLine);
		System.out.println(listResult);
		
		
		
		System.out.println("---Natural Sorting by Name---");
		List<Line> slist = listLine.stream().sorted().collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getIdentifier()+", Name: "+e.getLogline()));
		
		System.out.println("---Natural Sorting by Name in reverse order---");
		slist = listLine.stream().sorted(Comparator.<Line>reverseOrder()).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getIdentifier()+", Name: "+e.getLogline()));		
		
		System.out.println("---Sorting using Comparator by Age---");
		slist = listLine.stream().sorted(Comparator.comparing(Line::getLogline)).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getIdentifier()+", Name: "+e.getLogline()+", Age:"+e.getLogline()));
		
		System.out.println("---Sorting using Comparator by Age with reverse order---");
		slist = listLine.stream().sorted(Comparator.comparing(Line::getLogline).reversed()).collect(Collectors.toList());
		slist.forEach(e -> System.out.println("Id:"+ e.getIdentifier()+", Name: "+e.getLogline()+", Age:"+e.getLogline()));

		
		
		
	}
	
	public static List<String> orderLogs(List<Line> list) {
		
		list = list.stream().sorted(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
            		if(((Line)o1).getLogline().equals(((Line)o2).getLogline())) {
            			return ((Line)o2).getIdentifier()
                                .compareTo(((Line)o1).getIdentifier());
            		}
                return ((Line)o1).getLogline()
                        .compareTo(((Line)o2).getLogline());
            }
        }.reversed()).collect(Collectors.toList());	
		
		List<String> stList = new ArrayList<>();
		
		for(Line line : list ) {
			stList.add(line.getIdentifier() + line.getLogline());
		}
		
		return stList;
	}
	
	
	static class Line implements Comparable{
		String identifier;
		String logline;
		public Line(String ident, String log) {
			identifier = ident;
			logline = log;
		}
		
		public String getLogline() {
			return logline;
		}
		public String getIdentifier() {
			return identifier;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			if(getLogline().equals(((Line)o).getLogline())) {
    			return ((Line)o).getIdentifier()
                        .compareTo(getIdentifier());
    		}
        return getLogline()
                .compareTo(((Line)o).getLogline());
		}

		
	
	}
	
}
