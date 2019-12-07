package dynamic_array;

public class GList<T> {
	private T[] data;
	private int index;
	private int max;
	
	public GList()
	{
		max = 100;
		data = (T[]) new Object[max];
		index = 0;
	}

	public int size() {
		
		return index;
	}

	public void add(T nextInt) {
		
		if(index >= max)
		{
			T[] tmp = (T[]) new Object[max];			
			
			tmp = data.clone();
			max *= 2;
			data = (T[]) new Object[max];
			
			for(int i=0; i<tmp.length; i++)
			{
				data[i] = tmp[i];
			}
		}
		
		data[index] = nextInt;
		index++;
		
	}

	public T get(int index) {
		
		return data[index];
	}
}
