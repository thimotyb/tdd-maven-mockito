package it.corso.order.bo;

import it.corso.order.bo.exception.BOException;
import it.corso.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
