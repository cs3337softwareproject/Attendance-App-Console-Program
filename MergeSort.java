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
