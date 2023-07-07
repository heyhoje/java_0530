package day28.bassballGame.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2267977640380174776L;
	
	private String name;
	private int count;
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
	
	
}
