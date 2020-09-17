package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogUtilityImpl implements LogUtility {

    private static final Logger log = LoggerFactory.getLogger(LogUtilityImpl.class);

    @Override
    public void showLog(String mensaje) {
        log.info(mensaje);
    }
}
