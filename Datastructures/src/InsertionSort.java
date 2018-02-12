
public class InsertionSort {

	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arraylist=new int[]{100,99,98,64,164,1,2,3,-7,10001};
		for(int i=0;i<arraylist.length-1;i++)
		{
			if(arraylist[i] > arraylist[i+1])
			{
				int element=arraylist[i+1];
				int pos=i+1;
				for(int j=0;j<i+1;j++)
				{
				  if(arraylist[j] > element)
				  {
				    int temp=arraylist[j];
				    arraylist[j]=arraylist[pos];
				    arraylist[pos]=temp;
				  }
				}
				  
			}
		}
		for(int i=0;i<arraylist.length;i++)
		{
			System.out.println(arraylist[i]);
		}
	}

}
