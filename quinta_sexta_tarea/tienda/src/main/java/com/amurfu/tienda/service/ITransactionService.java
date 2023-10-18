package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.TransactionDTO;
import jakarta.validation.Valid;

public interface ITransactionService {

    Response<TransactionDTO> generatePurchase(@Valid TransactionDTO transactionDTO);

}
