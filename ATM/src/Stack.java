
public class Stack {
	StackFile[] prevStack;
	StackFile[] nextStack;
	StackFile topPrev;
	StackFile topNext;
	int totalQueueSize;
	int prevStackSize;
	int nextStackSize;
	int skipItemRebound;
	
	public Stack() {
		skipItemRebound =0;
		totalQueueSize =0;
		prevStackSize =0;
		nextStackSize =0;
		
		prevStack = new StackFile[5];
		nextStack = new StackFile[5];
		for( int i=0; i<5; i++) prevStack[i] = new StackFile();
		for( int j=0; j<5; j++) nextStack[j] = new StackFile();
		
		topPrev = prevStack[4];
		topNext = nextStack[4];
	}
	
	public void popPrev() {
		for( int i=4; i>0; i--) prevStack[i].setValue(prevStack[i-1].getValue());
		prevStackSize--;
	}
	public void popNext() {
		for( int i=4; i>0; i--) nextStack[i].setValue(nextStack[i-1].getValue());
		nextStackSize--;
	}
	
	public void popPrevToNext() {
		pushNext();
		topNext.setValue(topPrev.getValue());
		popPrev();
	}
	public void popNextToPrev() {
		pushPrev();
		topPrev.setValue(topNext.getValue());
		popNext();
	}
	
	public void pushPrev() {
		for( int i=0; i<4; i++) prevStack[i].setValue(prevStack[i+1].getValue());
		if(prevStackSize != 5) prevStackSize++;
	}
	public void pushNext() {
		for( int i=0; i<4; i++) nextStack[i].setValue(nextStack[i+1].getValue());
		if(nextStackSize != 5) nextStackSize++;
	}
	
	public void addToQueue(String text) {
		resetTop();
		pushPrev();
		topPrev.setValue(text);
		if(totalQueueSize != 5) totalQueueSize++;
	}
	
	public String getPreviousInQueue() {
		if(prevStackSize == 0) { skipItemRebound =0; return null; }
		popPrevToNext();
		if(skipItemRebound == 1) {
			if(prevStackSize == 0) { skipItemRebound =0; return null; }
			popPrevToNext();
			skipItemRebound =-1;
			return topNext.getValue();
		}
		skipItemRebound =-1;
		return topNext.getValue();
	}
	
	public String getNextInQueue() {
		if(nextStackSize == 0) { skipItemRebound =0; return null; }
		popNextToPrev();
		if(skipItemRebound == -1) {
			if(nextStackSize == 0) { skipItemRebound =0; return null; }
			popNextToPrev();
			skipItemRebound =1;
			return topPrev.getValue();
		}
		skipItemRebound =1;
		return topPrev.getValue();
	}
	
	public void resetTop() {
		for(; nextStackSize>0; ) popNextToPrev();
		skipItemRebound =0;
	}
}
