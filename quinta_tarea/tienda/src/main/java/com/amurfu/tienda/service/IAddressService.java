package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.dto.Response;

public interface IAddressService {

    Response<AddressDTO> addAddressUser(AddressDTO addressDTO);

    Response<AddressDTO> updateAddressUser(AddressDTO addressDTO,Integer idAddress);

    Response<AddressDTO> getAddressByUser(Integer idUser);

    Response<AddressDTO> deleteAddressByUser(Integer idUser, Integer idAddress);
}
