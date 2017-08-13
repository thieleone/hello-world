public class heap{
	public void insert(int a){
		A[k]=a;
		k++
		checkheap(k-1);	
	}
	public void checkheap(int n){
		if(n==0){return}
		int t;
		if(A[n]<A[(n-1)/2]){
			t=A[n];
			A[n]=A[(n-1)/2];
			A[(n-1)/2]=t;
			checkheap((n-1)/2)
		}






	}

	public static void main(String[] args){

	}
}