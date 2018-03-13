
public class BubbleSort {
	
	public static void main(String[] args)
	{
		int[] arr={100,99,98,97,10,9,8,7,6,1,-1,10000};	
		int j=arr.length;
	while(j != -1)
	{
    for(int i=0;i<arr.length;i++)
	{
		if(i != arr.length-1 &&arr[i] > arr[i+1])
		{
			int temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
		}
	 }
     j--;
	}
	for(int i=0;i<arr.length;i++)
	{
	  System.out.println(arr[i]);
	}  
	}

}
