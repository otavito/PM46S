package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import br.edu.utfpr.pb.pw44s.server.service.UserService;
import br.edu.utfpr.pb.pw44s.server.shared.GenericResponse;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("addresses")
public class AddressController extends CrudController<Address, AddressDTO, Long> {

    private final IAddressService service;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public AddressController(IAddressService service, ModelMapper modelMapper, UserService userService) {
        super(Address.class, AddressDTO.class);
        this.service = service;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    protected IAddressService getService() {
        return this.service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @PostMapping
    public GenericResponse create(Principal principal, @RequestBody @Valid AddressDTO addressDTO) {

        String username = principal.getName();
        User user = userService.findByUsername(username);

        Address address = modelMapper.map(addressDTO, Address.class);
        address.setUser(user);
        service.save(address);

        return new GenericResponse("Endereço salvo com sucesso para o usuário autenticado.");
    }

}
