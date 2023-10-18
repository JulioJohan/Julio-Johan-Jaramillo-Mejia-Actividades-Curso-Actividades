package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressHelper implements IAddressHelper{

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AddressDTO convertToDtoAddress(Address address) {
        return modelMapper.map(address,AddressDTO.class);
    }
}
