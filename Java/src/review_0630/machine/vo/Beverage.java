package review_0630.machine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Beverage {
	
	private String name;
	private int price;
	private int amount;
	
	/* @AllArgsConstructor 처리 해서 주석 한건가????
	 * 
	 public Beverage(String name, int price, int amount) {
	   this.nama = name;
	   this.price = price;
	   this.amount = amount;
	 }
	 */
	

}
