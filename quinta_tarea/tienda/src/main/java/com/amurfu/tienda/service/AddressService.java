package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Address;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IAddressHelper;
import com.amurfu.tienda.repository.IAddressRepository;
import com.amurfu.tienda.repository.IUserRepository;
import com.amurfu.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService{

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAddressHelper addressHelper;

    @Override
    public Response<AddressDTO> addAddressUser(AddressDTO addressDTO) {
        Response<AddressDTO> response = new Response<>();
        Optional<User> userOptional = userRepository.findById(addressDTO.getIdUser());
        if(userOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.USER_NOT_FOUND);
        }

        Address address = new Address();
        address.setFullName(addressDTO.getFullName());
        address.setPhone(addressDTO.getPhone());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCountry(addressDTO.getCountry());
        address.setEstate(addressDTO.getEstate());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setOuterNumber(addressDTO.getOuterNumber());
        address.setInnerNumber(addressDTO.getInnerNumber());
        address.setAddressReferences(addressDTO.getAddressReferences());
        address.setUser(userOptional.get());

        address = addressRepository.save(address);
        addressDTO.setIdAddress(address.getIdAddress());

        response.setData(addressDTO);
        response.setMessage(Constants.ADD_ADDRESS);
        return response;
    }

    @Override
    public Response<AddressDTO> updateAddressUser(AddressDTO addressDTO, Integer idAddress) {
        Response<AddressDTO> response = new Response<>();


        Optional<User> userOptional = userRepository.findById(addressDTO.getIdUser());
        if(userOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.USER_NOT_FOUND);
        }
        Optional<Address> addressOptional = addressRepository.findById(idAddress);
        if(addressOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.ADDRESS_NOT_FOUND);
        }

        Address address = addressOptional.get();
        address.setFullName(addressDTO.getFullName());
        address.setPhone(addressDTO.getPhone());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCountry(addressDTO.getCountry());
        address.setEstate(addressDTO.getEstate());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setOuterNumber(addressDTO.getOuterNumber());
        address.setInnerNumber(addressDTO.getInnerNumber());
        address.setAddressReferences(addressDTO.getAddressReferences());
        address.setUser(userOptional.get());
        address = addressRepository.save(address);

        addressDTO = addressHelper.convertToDtoAddress(address);
        response.setData(addressDTO);
        response.setMessage(Constants.UPDATE_ADDRESS);
        return response;
    }

    @Override
    public Response<AddressDTO> getAddressByUser(Integer idUser) {
        Response<AddressDTO> response = new Response<>();
        Optional<User> userOptional = userRepository.findById(idUser);
        if(userOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.USER_NOT_FOUND);
        }

        List<Address> addressList = addressRepository.findByUserIdUser(idUser);
        List<AddressDTO> addressDTOList = new ArrayList<>();

        if(addressList.isEmpty()){
            response.setMessage(Constants.ADDRESS_FOUND_USER);
            response.setList(addressDTOList);
            return response;
        }
        for(Address address: addressList){
            AddressDTO addressDTO = addressHelper.convertToDtoAddress(address);
            addressDTOList.add(addressDTO);
        }
        response.setMessage(Constants.ADDRESS_FOUND_USER);
        response.setList(addressDTOList);
        return response;
    }

    @Override
    public Response<AddressDTO> deleteAddressByUser(Integer idUser,Integer idAddress) {
        Response<AddressDTO> response = new Response<>();
        Optional<User> userOptional = userRepository.findById(idUser);
        if(userOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.USER_NOT_FOUND);
        }
        Optional<Address> addressOptional = addressRepository.findById(idAddress);
        if(addressOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.ADDRESS_NOT_FOUND);
        }
        addressRepository.deleteById(idAddress);
        List<Address> addressList = addressRepository.findByUserIdUser(idUser);

        List<AddressDTO> addressDTOList = new ArrayList<>();

        if(addressList.isEmpty()){
            response.setMessage(Constants.DELETE_ADDRESS);
            response.setList(addressDTOList);
            return response;
        }

        for (Address address: addressList){
            AddressDTO addressDTO = addressHelper.convertToDtoAddress(address);
            addressDTOList.add(addressDTO);
        }
        response.setMessage(Constants.DELETE_ADDRESS);
        response.setList(addressDTOList);
        return response;
    }
}
