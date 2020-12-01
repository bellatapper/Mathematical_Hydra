import java.util.HashMap;

public class NodeHashMap {
	private HashMap<Integer, Node> hashMap;
	
	public NodeHashMap() {
		hashMap = new HashMap<Integer, Node>();
	}
	
	public void add(Integer key, Node node) {
		this.hashMap.put(key, node);
	}
	
	public Node get(Integer key) {
		return this.hashMap.get(key);
	}
	
	public void remove(Integer value) {
		hashMap.remove(value);
	}
}
