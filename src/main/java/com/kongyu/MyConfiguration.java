package com.kongyu;

import com.kongyu.kytils.bean.IBeanUtils;
import com.kongyu.kytils.bean.MyBeanUtils;
import com.kongyu.kytils.log.ILogger;
import com.kongyu.kytils.log.loggerFactory.MyLoggerFactory;
import com.kongyu.kytils.map.MapUtils;
import com.kongyu.kytils.numerical.INumericalConverter;
import com.kongyu.kytils.numerical.basedMapping.NumericalConverter;
import com.kongyu.kytils.numerical.basedMapping.mapper.INumericalDecimalMapper;
import com.kongyu.kytils.numerical.basedMapping.mapper.NumericalDecimalMapper;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/4/28
 */
@Configuration
public class MyConfiguration {

    static {
        MyLoggerFactory.putLoggerFactory(Logger.class, l -> new ILogger() {
            @Override
            public void debug(String format, Object... arguments) {
                l.debug(format, arguments);
            }

            @Override
            public void info(String format, Object... arguments) {
                l.info(format, arguments);
            }

            @Override
            public void warn(String format, Object... arguments) {
                l.warn(format, arguments);
            }

            @Override
            public void error(String format, Object... arguments) {
                l.error(format, arguments);
            }
        });
    }

    @Bean()
    public IBeanUtils getBeanUtils() {
        return new MyBeanUtils() {
            @Override
            public PropertyDescriptor[] getPropertyDescriptors(Class<?> aClass) {
                return org.springframework.beans.BeanUtils.getPropertyDescriptors(aClass);
            }

            @Override
            public PropertyDescriptor getPropertyDescriptor(Class<?> aClass, String s) {
                return org.springframework.beans.BeanUtils.getPropertyDescriptor(aClass, s);
            }
        };
    }

    @Bean()
    public INumericalDecimalMapper getNumericalDecimalMapper() {
        return new NumericalDecimalMapper();
    }

    @Bean()
    public INumericalConverter getNumericalConverter(INumericalDecimalMapper mapper) {
        NumericalConverter converter = new NumericalConverter();
        converter.setNumericalDecimalMapper(mapper);
        converter.setCardinalityOffset(MapUtils.getMapInstance(28, 1));
        return converter;
    }

}
