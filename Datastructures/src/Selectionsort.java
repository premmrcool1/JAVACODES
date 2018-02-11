
public class Selectionsort {

	public static void main(String[] args) {
		
		int[] sel={100,88,77,504,96,-103,-543};
		int Large_pos=0;
		int decrement=sel.length-1;
		while(decrement!=-1)
		{
			for(int i=0;i<decrement;i++)
		    {
			System.out.println(Large_pos);
			   if(sel[Large_pos] < sel[i+1])
			   {
				 Large_pos=i+1;   
			   }
		    }
			System.out.println(Large_pos);
			swap(sel,Large_pos,decrement);
			Large_pos=0;
			decrement--;
		}
		for(int j=0;j<sel.length;j++)
		{
			System.out.println(sel[j]);
		}
		
		// TODO Auto-generated method stub

	}
	public static void swap(int[] sel,int i,int j)
	{
		int temp=sel[i];
		sel[i]=sel[j];
		sel[j]=temp;
	}

}
