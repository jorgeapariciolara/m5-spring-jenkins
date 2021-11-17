package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartDeviceFactoryTest {

    @Test
    void createByType() {
        // SmartDeviceFactory.createByType("sfsrgddsgds");

        assertThrows(
                IllegalArgumentException.class,
                () -> SmartDeviceFactory.createByType("sfsrgddsgds")
        );

    }
}