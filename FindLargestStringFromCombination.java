class FindLargestStringFromCombination {

	public static void main(String a[]) {
		String input[] = { "ab", "cda", "fghi", "lcdmno" };
		// You can avoid duplicates within input array
		Set<String> mySet = new HashSet<>(Arrays.asList(input));
		// Create Input Array from filtered set
		input = createStringArrayFromSet(mySet);
		// get string combinations
		ArrayList<String> listValue = getStringCombination(input);
		// remove string from string array with duplicate character
		listValue = removeDupChar(listValue);
		// print largest string based on combination
		printLargestString(listValue);
		
	}

	private static void printLargestString(ArrayList<String> listValue) {
		String longestString = listValue.get(0);
	    for (String element : listValue) {
	        if (element.length() > longestString.length()) {
	            longestString = element;
	        }
	    }
	    System.out.println(longestString);
		
	}

	static String[] createStringArrayFromSet(Set<String> mySet) {
		int n = mySet.size();
		String arr[] = new String[n];
		int i = 0;
		for (String x : mySet)
			arr[i++] = x;
		return arr;
	}

	static ArrayList<String> getStringCombination(String set[]) {
		ArrayList<String> listValue = new ArrayList<String>();
		int n = set.length;
		for (int i = 0; i < (1 << n); i++) {
			String value = "";
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					value += set[j];
				}
			}
			listValue.add(value);
		}
		return listValue;
		
	}

	private static ArrayList<String> removeDupChar(ArrayList<String> test) {
		Iterator<String> i = test.iterator();
		while (i.hasNext()) {
			Map<Character, Integer> baseMap = new HashMap<Character, Integer>();
			String str = (String) i.next();
			char[] charArray = str.toCharArray();
			for (Character ch : charArray) {
				if (baseMap.containsKey(ch)) {
					i.remove();
					break;
				} else {
					baseMap.put(ch, 1);
				}
			}
		}
		return test;	
	}
}
