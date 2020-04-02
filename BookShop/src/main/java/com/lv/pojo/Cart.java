package com.lv.pojo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Cart {

	private HashMap<Book,Integer> goods;
	
	private double totalPrice;


	//构造方法
	public Cart()
	{
		goods = new HashMap<Book,Integer>();
		totalPrice = 0.0;
	}

	public Cart(HashMap<Book, Integer> goods, double totalPrice) {
		super();
		this.goods = goods;
		this.totalPrice = totalPrice;
	}

	public HashMap<Book, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Book, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * 添加商品进购物车的方法
	 * @param item
	 * @param number
	 * @return
	 */
	public boolean addGoodsInCart(Book item ,int number)
	{
		if(goods.containsKey(item))
		{
			goods.put(item, goods.get(item)+number);
		}
		else
		{
			goods.put(item, number);	
		}
		//重新计算购物车的总金额
		calTotalPrice();
		return true;
	}

	/**
	 * 删除商品的方法
	 * @param item
	 * @return
	 */
	public boolean removeGoodsFromCart(Book item)
	{
		goods.remove(item);
		//重新计算购物车的总金额
		calTotalPrice();
		return true;
	}

	/**
	 * 统计购物车的总金额
	 * @return
	 */
	public double calTotalPrice()
	{
		double sum = 0.0;
		//获得键的集合
		Set<Book> keys = goods.keySet();
		//获得迭代器对象
		Iterator<Book> it = keys.iterator();
	    while(it.hasNext())
	    {
	    	Book i = it.next();
	    	sum += Double.parseDouble(i.getPrice())* goods.get(i);
	    }
	    //设置购物车的总金额
	    this.setTotalPrice(sum);
	    return this.getTotalPrice();
	}

}
