package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.ProductAddDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.TransactionDTO;
import com.amurfu.tienda.data.entity.FormPayment;
import com.amurfu.tienda.data.entity.Product;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.repository.IFormPaymentRepository;
import com.amurfu.tienda.repository.IProductRepository;
import com.amurfu.tienda.repository.ITransactionProductRepository;
import com.amurfu.tienda.repository.ITransactionRepository;
import com.amurfu.tienda.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    ITransactionRepository transactionRepository;

    @Mock
    ITransactionProductRepository transactionProductRepository;

    @Mock
    IUserRepository userRepository;

    @Mock
    IFormPaymentRepository formPaymentRepository;

    @Mock
    IProductRepository productRepository;


    private List<ProductAddDTO> productAddDTOList;

    private TransactionDTO transactionDTO;
    private ProductAddDTO productAddDTO;
   
    	
    private User user;
    private FormPayment formPayment;
    private Product product;
    private Product productEmpty;
    Optional<User> userOptional;
    Optional<FormPayment> formPaymentOptional;
    Optional<Product> productOptional;    
    Optional<Product> productOptionalEmpty;

    
    

    @BeforeEach
    void setUp(){
    	user = new User();
    	userOptional = Optional.of(user);
    	
    	formPayment = new FormPayment();
    	formPaymentOptional = Optional.of(formPayment);
    	
    	product = new Product();
      	product.setIdProduct(1);
      	product.setPrice(new BigDecimal("1"));
    	product.setStock(2);
    	product.setStatus("AVAILABLE");
    	productOptional = Optional.of(product);
    	
    	
    	productEmpty = new Product();
    	productEmpty.setStock(0);
    	productEmpty.setIdProduct(1);
    	productOptionalEmpty = Optional.of(productEmpty);
  
    	
    	productAddDTO = new ProductAddDTO();
        productAddDTO.setIdProduct(1);
        productAddDTO.setQuantityProducts(1);
        productAddDTO.setPrice(new BigDecimal("1"));
        productAddDTO.setTotal(new BigDecimal("1"));
        
        productAddDTOList = new ArrayList<>();
        productAddDTOList.add(productAddDTO);

        transactionDTO = new TransactionDTO();
        transactionDTO.setIdUser(1);
        transactionDTO.setIdFormPayment(1);
        transactionDTO.setIdTransaction(1);
        transactionDTO.setTotal(new BigDecimal("1"));
        transactionDTO.setDate(new Date());
        transactionDTO.setProducts(productAddDTOList);
    }

    @Test
    void generatePurchaseTest(){
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(userOptional);       
    	when(formPaymentRepository.findById(Mockito.anyInt())).thenReturn(formPaymentOptional);
    	when(productRepository.findById(Mockito.anyInt())).thenReturn(productOptional);
    	Response<TransactionDTO> generatePurchase = transactionService.generatePurchase(transactionDTO);
        assertNotNull(generatePurchase);
    }
    
    @Test
    void generatePurchaseNotFoundUserTest(){
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());       
    	assertThrows(BusinessException.class, ()->{
    		transactionService.generatePurchase(transactionDTO);
    	});
    }
    
    @Test
    void generatePurchaseNotFoundFormPaymentTest(){
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(userOptional);       
    	when(formPaymentRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());       
    	assertThrows(BusinessException.class, ()->{
    		transactionService.generatePurchase(transactionDTO);
    	});
    }
    
    @Test
    void generatePurchaseNotFoundStockTest(){           
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(userOptional);       
    	when(formPaymentRepository.findById(Mockito.anyInt())).thenReturn(formPaymentOptional);
    	when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
    	assertThrows(BusinessException.class, ()->{
    		transactionService.generatePurchase(transactionDTO);
    	});
    }
    
    @Test
    void generatePurchaseNotStockTest(){           
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(userOptional);       
    	when(formPaymentRepository.findById(Mockito.anyInt())).thenReturn(formPaymentOptional);
    	when(productRepository.findById(Mockito.anyInt())).thenReturn(productOptionalEmpty);
    	assertThrows(BusinessException.class, ()->{
    		transactionService.generatePurchase(transactionDTO);
    	});
    }

}
