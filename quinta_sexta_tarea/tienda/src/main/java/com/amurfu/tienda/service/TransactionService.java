package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.ProductAddDTO;
import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.TransactionDTO;
import com.amurfu.tienda.data.entity.*;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.repository.*;
import com.amurfu.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    ITransactionRepository transactionRepository;

    @Autowired
    ITransactionProductRepository transactionProductRepository;
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IFormPaymentRepository formPaymentRepository;

    @Autowired
    IProductRepository productRepository;


    @Override
    public Response<TransactionDTO> generatePurchase(TransactionDTO transactionDTO) {
        Response<TransactionDTO> response = new Response<>();
        Transaction transaction = new Transaction();

        transaction.setAmountProducts(transactionDTO.getProducts().size());
        Optional<User> userOptional = userRepository.findById(transactionDTO.getIdUser());
        if(userOptional.isEmpty()){
            throw  new BusinessException(HttpStatus.NOT_FOUND, Constants.USER_NOT_FOUND);
        }
        Optional<FormPayment> formPaymentOptional = formPaymentRepository.findById(transactionDTO.getIdFormPayment());

        if(formPaymentOptional.isEmpty()){
            throw  new BusinessException(HttpStatus.NOT_FOUND,Constants.FORM_PAYMENTE_NOT_FOUND);
        }
        transaction.setFormPayment(formPaymentOptional.get());

        BigDecimal totalTransaction = new BigDecimal(0.0);

        List<Product> productList = new ArrayList<>();

        for(ProductAddDTO productAddDTO: transactionDTO.getProducts()){
            Optional<Product> product =  productRepository.findById(productAddDTO.getIdProduct());
            if(product.isEmpty()){
                throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_AVAILABLE);
            }
            if (product.get().getStock() < 1 || product.get().getStatus().equals(Constants.PRODUCT_NOT_AVAILABLE)){
                throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_AVAILABLE);
            }
            productList.add(product.get());
            product.get().setStock(product.get().getStock() - productAddDTO.getQuantityProducts());
            //            checkProduct(productAddDTO.getIdProduct());
            BigDecimal quantityProduct = new BigDecimal(productAddDTO.getQuantityProducts());
            totalTransaction = totalTransaction.add(productAddDTO.getPrice().multiply(quantityProduct));

        }

//       Actualizamos la informacion de los productos pra quitar la cantidad disponible
//        Anteriormente se podia pero, si un objeto pueda fallar ahi habria probleamas
        for (Product product: productList){
            Optional<ProductAddDTO> optionalProduct = transactionDTO.getProducts().stream().filter(productAddDTO -> product.getIdProduct().equals(productAddDTO.getIdProduct())).findFirst();
            product.setStock(product.getStock() - optionalProduct.get().getQuantityProducts());
            if (product.getStock()< 1){
                product.setStatus(Constants.PRODUCT_AVAILABLE);
            }
            productRepository.save(product);
        }

        transaction.setTotal(totalTransaction);
        transactionRepository.save(transaction);

        for (ProductAddDTO productAddDTO: transactionDTO.getProducts()){
            Optional<Product> product = productRepository.findById(productAddDTO.getIdProduct());
            TransactionProduct transactionProduct = new TransactionProduct();
            TransactionProductId transactionProductId = new TransactionProductId();
            transactionProductId.setIdTransaction(transaction.getIdTransaction());
            transactionProductId.setIdProduct(product.get().getIdProduct());

            transactionProduct.setIdTransactionProductId(transactionProductId);
            transactionProduct.setTransaction(transaction);
            transactionProduct.setQuantity(productAddDTO.getQuantityProducts());
            transactionProduct.setTotal(product.get().getPrice().multiply(productAddDTO.getPrice()));
            transactionProductRepository.save(transactionProduct);
        }

        transactionDTO.setIdTransaction(transaction.getIdTransaction());
        transactionDTO.setTotal(transaction.getTotal());
        transactionDTO.setDate(transaction.getDateTransaction());

        response.setMessage(Constants.TRANSACTION_COMPLETE);
        response.setData(transactionDTO);

        return response;
    }

}
