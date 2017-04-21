package com.soso.persistance.exceptions;

/**
 * Created by Garik Kalashyan on 3/9/2017.
 */
public class ServiceNotFoundException extends EnumConstantNotPresentException {

    /**
     * Constructs an <tt>EnumConstantNotPresentException</tt> for the
     * specified constant.
     *
     * @param enumType     the type of the missing enum constant
     * @param constantName the name of the missing enum constant
     */
    public ServiceNotFoundException(Class<? extends Enum> enumType, String constantName) {
        super(enumType, constantName);
    }
}
