package com.om.hello.validator;

import java.util.List;

public interface ManualValidator {

    void validate(final Object object);

    void validate(final Object object, final List<Class<?>> groupClasses);

}
