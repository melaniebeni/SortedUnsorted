public abstract class CandleList {
	protected CandleNode head, tail, last, first;
	protected int length = 0;

	public CandleList() {
		this.head = new CandleNode(null);
		this.first = this.head;
		this.last = this.head;
	}// CandleList constructor

	public void append(Candle s) {
		CandleNode n = new CandleNode(s);
		last.next = n;
		last = n;
		length++;
	}// append

}// CandleList
