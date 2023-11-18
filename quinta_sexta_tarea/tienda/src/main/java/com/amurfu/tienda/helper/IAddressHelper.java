package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.entity.Address;

public interface IAddressHelper {

    AddressDTO convertToDtoAddress(Address address);
}
