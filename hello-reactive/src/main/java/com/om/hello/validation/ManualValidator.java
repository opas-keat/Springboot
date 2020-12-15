package com.om.hello.validation;

import java.util.List;

public interface ManualValidator {
    void validate(final Object object);

    void validate(final Object object, final List<Class<?>> groupClasses);
}
