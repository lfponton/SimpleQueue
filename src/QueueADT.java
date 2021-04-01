public interface QueueADT<T> {

	public void enqueue(T element);
	public T dequeue();
	public T first();
	public int size();
	public boolean isEmpty();
	public int indexOf(T element);
	public boolean contains(T element);
}
