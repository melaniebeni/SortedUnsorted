public class SortedCandleList extends CandleList {
	private CandleNode current;

	public SortedCandleList() {
		super();
	}// SortedcandleList constructor

	public void add(Candle c) {
		CandleNode node = new CandleNode(c);
		current = first;
		while (current.next != null && current.next.data.compareTo(c) == false) {
			current = current.next;
		}
		node.next = current.next;
		current.next = node;
	} // add

}// SortedCandleList
