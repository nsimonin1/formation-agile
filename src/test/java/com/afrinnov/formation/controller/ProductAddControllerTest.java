package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.ProductAddService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductAddControllerTest {
    @InjectMocks
    private ProductAddController controller;
    @Mock
    private ProductAddService productAddService;

    @Test
    @DisplayName("should increment given product when user add quantity")
    void incrementProduct() {
        //Act
        controller.increment("1222", 10);

        //Assert
        verify(productAddService).increment("1222", 10);
    }
}