package DPprac;

public class LootHouses {
	
	public static int getMaxMoney(int arr[], int n){

		return getmax(arr,0);

	}

	public static int getmax(int []arr,int i) {
		if(i>=arr.length)
			return 0;
		int op1 = arr[i]+getmax(arr,i+2);
		int op2 = getmax(arr,i+1);
		return Math.max(op1, op2);
	}
	public static int getMaxMoneyDP(int arr[],int n) {
		int storage[] = new int [arr.length];
		storage[0] = arr[0];
		storage[1]= Math.max(arr[0], arr[1]);
		for(int i = 2;i<storage.length;i++) {
			
			int op1 = arr[i]+storage[i-2];
			int op2 = storage[i-1];
			storage[i] = Math.max(op1, op2);
		}
		return storage[arr.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,5,10,100,10,5};
		System.out.println(getMaxMoneyDP(arr,6));
		System.out.println(getMaxMoney(arr, 6));
	}

}
