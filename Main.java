package cardReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;


public class Main {
	public static LinkedList<CardReader> readData()
	{
		try
		{
			LinkedList<CardReader> readData = new LinkedList<CardReader>();
			
			BufferedReader br = new BufferedReader(new FileReader(new File("cardTest.txt")));
			
				
			br.readLine();
			
			String line;
			
			
			while((line = br.readLine()) != null){	//read line by line
			
				if(line.length() == 0)	//ignore empty line
				
					continue;
				
				line.trim();
				
				String lastName = line.substring(line.indexOf('^') + 1, line.indexOf('/'));
				
				String firstName = line.substring(line.indexOf('/') + 1, line.indexOf('^', line.indexOf('/') +1));
				
				String CIN = line.substring(line.length() - 10, line.length() - 1);
			    
				Integer CIN1 = Integer.parseInt(CIN);
				
			    CardReader cardReader = new CardReader(lastName, firstName, CIN1); 
						
				System.out.println(cardReader.toString());
				
				readData.add(cardReader);	//add to list
			}
			br.close();
		
			return readData;
		
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	private static DoublyLinkedList<CardReader> mergeSort(DoublyLinkedList<CardReader> cardReader)
	{
		if(cardReader.size() <= 1)
			return cardReader;
		DoublyLinkedList<CardReader> left = new  DoublyLinkedList<CardReader>();
		
		DoublyLinkedList<CardReader> right = new  DoublyLinkedList<CardReader>();
		
		int middle = cardReader.size() / 2;
		
		for(int i = 0; i < middle; i++)
		
			left.add(cardReader.get(i));
		
		for(int i = middle; i < cardReader.size(); i++)
		
			right.add(cardReader.get(i));
		
		left = mergeSort(left);
		
		right = mergeSort(right);
		
		return merge(left, right);
			
	}
	/* called by mergeSort */
	private static DoublyLinkedList<CardReader> merge(DoublyLinkedList<CardReader> left, DoublyLinkedList<CardReader> right)
	{
		DoublyLinkedList<CardReader> readData = new DoublyLinkedList<CardReader>();
		while(left.size() > 0 || right.size() > 0) 		{
			if(left.size() > 0 && right.size() > 0)			{
				if(	left.get(0).getStudentNumber() < right.get(0).getStudentNumber() ||
					(left.get(0).getStudentNumber() == right.get(0).getStudentNumber())
											
					) 				{
					readData.add(left.get(0));
					left.remove(0);
				} 				else 				{
					readData.add(right.get(0));
					right.remove(0);
				}
			}
			else if(left.size() > 0) 			{
				readData.add(left.get(0));
				left.remove(0);
			} else if(right.size() > 0) 			{
				readData.add(right.get(0));
				right.remove(0);
			}
		}
		return readData;
	}
	
	
	
	
	
	public static void main(String args[])
	{
		//Read in data
		LinkedList<CardReader> cardReader = readData();
		DoublyLinkedList<CardReader> dCardReader = new DoublyLinkedList<CardReader>(); 
		//Put data into DoublyLinkedList in the original order
		
		long startTime = System.nanoTime();
		
		long endTime = System.nanoTime();
		
		
		System.out.println("\n\n===========Merge sort on Student CIN=================\n\n");
		
		startTime = System.nanoTime();
		DoublyLinkedList<CardReader> mergeResult = mergeSort(dCardReader);
		endTime = System.nanoTime();

		System.out.println("\n\nMerge sort takes " + (endTime - startTime) + " nano time.\n\n");
		
		System.out.println("\n\n===========After merge sort=================\n\n");
		for(int i = 0 ; i < mergeResult.size(); i++)
			
			System.out.println(mergeResult.get(i));
		
			}
}
