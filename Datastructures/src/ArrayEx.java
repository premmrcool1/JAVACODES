
public class ArrayEx {
	
	public static void main(String[] args)
	{
		int[] array=new int[7];
		array[0]=1;
		array[1]=2;
		array[2]=3;
		
	 int index=-1;
	 for(int i=0;i<array.length;i++)
	 {
		 if(array[i] == 3)
		 {
			 index = i;
		 }
	 }
	System.out.println(index);
	}

}
