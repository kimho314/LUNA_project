package dynamic_array;

public class ObjectList {
	private Object[] data;
	private int index;
	private int max;
	
	public ObjectList()
	{
		max = 100;
		data = new Object[max];
		index = 0;
	}

	public int size() {
		
		return index;
	}

	public void add(Object nextInt) {
		
		if(index >= max)
		{
			Object[] tmp = new Object[max];			
			
			tmp = data.clone();
			max *= 2;
			data = new Object[max];
			
			for(int i=0; i<tmp.length; i++)
			{
				data[i] = tmp[i];
			}
		}
		
		data[index] = nextInt;
		index++;
		
	}

	public Object get(int index) {
		
		return data[index];
	}
}
