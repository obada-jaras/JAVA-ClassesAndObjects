import java.util.Comparator;


class SortBy100Cost implements Comparator<Vehicle>{		//SortBy100Cost Class to sort based on cost for 100km 
	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return (int)(o1.costFor100Km()-o2.costFor100Km());
	}
	
}



class SortByOwnerName implements Comparator<Vehicle>{		//SortByOwnerName Class to sort based on owner name
	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o1.getOwner().getName().compareTo(o2.getOwner().getName());
	}
	
}



class SortByBrand implements Comparator<Vehicle>{		//SortByOwnerName Class to sort based on brand name
	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o2.getBrand().compareTo(o1.getBrand());
	}
	
}
