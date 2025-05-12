package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addresses")
public class AddressController extends CrudController<Address, AddressDTO, Long> {

    private final IAddressService service;
    private final ModelMapper modelMapper;

    public AddressController(IAddressService service, ModelMapper modelMapper) {
        super(Address.class, AddressDTO.class);
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    protected IAddressService getService() {
        return this.service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
