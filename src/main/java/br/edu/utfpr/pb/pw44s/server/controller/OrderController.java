package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController extends CrudController<Order, OrderDTO, Long> {

    private final IOrderService service;
    private final ModelMapper modelMapper;

    public OrderController(IOrderService service, ModelMapper modelMapper) {
        super(Order.class, OrderDTO.class);
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    protected IOrderService getService() {
        return this.service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
