package br.com.mgoficina.service.impl;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.OrderService;
import br.com.mgoficina.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	private List<OrderService> orderServices = new ArrayList<>();

	private List<String> isValid(OrderService orderService) {
		List<String> listErros = new ArrayList<String>();
		if (orderService.getServiceName() == null || orderService.getServiceName().isEmpty())
			listErros.add("Service Name");

		if (orderService.getServiceStartDate() == null)
			listErros.add("Start Date");

		if (orderService.getClient() == null)
			listErros.add("Client");

		return listErros;
	}

	private void SaveFile(String fileName, Integer id) throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		DataOutputStream dados = new DataOutputStream(file);
		try {
			OrderService orderService = this.findById(id);
			dados.writeBytes(orderService.toString());
			dados.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (dados != null)
				dados.close();
		}
	}

	public OrderService finishOrder(int id) {
		OrderService orderService = this.findById(id);
		orderService.setFinished(true);
		this.update(orderService);

		try {
			this.SaveFile("br/com/mgoficina/OrderSerive.txt", id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orderService;
	}

	@Override
	public OrderService create(OrderService object) throws DomainException, DataIntegrityException {
		List<String> listErros = isValid(object);

		if (!listErros.isEmpty()) {
			String fieldErros = null;
			for (String field : listErros) {
				fieldErros += field + " ";
			}
			throw new DataIntegrityException(fieldErros);
		}

		this.orderServices.add(object);
		return object;
	}

	@Override
	public OrderService findById(Integer id) throws DomainException, ObjectNotFoundException {
		return this.orderServices.stream().filter(orderService -> orderService.getId() == id).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("OrderService: " + id));
	}

	@Override
	public List<OrderService> findAll() throws ObjectNotFoundException {
		if (this.orderServices.isEmpty())
			throw new ObjectNotFoundException("OrderService");
		return Collections.unmodifiableList(this.orderServices);
	}

	@Override
	public OrderService update(OrderService object)
			throws DomainException, DataIntegrityException, ObjectNotFoundException {
		if (object == null)
			throw new DataIntegrityException("Order Service cannot be null");

		int index = this.orderServices.indexOf(this.findById(object.getId()));
		if (index <= -1)
			throw new ObjectNotFoundException("Order Service: " + object.getServiceName());

		this.orderServices.add(index, object);
		return this.orderServices.get(index);
	}

	@Override
	public boolean delete(Integer id) throws DomainException, ObjectNotFoundException {
		return this.orderServices.removeIf(orderService -> orderService.getId() == id);
	}

}
