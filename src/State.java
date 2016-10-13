import java.util.HashMap;
import java.util.Map;

public class State {

public String name;
public Map<Integer, State>transitions = new HashMap<Integer, State>();
public State(String name)
{
	this.name = name;

}
public void addTransition(Integer i, State recoveryid) {
	this.transitions.put(i, recoveryid);
}
}
