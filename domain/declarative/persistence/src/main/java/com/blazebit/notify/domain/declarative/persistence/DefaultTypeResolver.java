/*
 * Copyright 2018 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.notify.domain.declarative.persistence;

import com.blazebit.notify.domain.declarative.spi.TypeResolver;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DefaultTypeResolver implements TypeResolver {

    private static final Map<Class<?>, Class<?>> TYPE_MAPPINGS;
    private static final Class<?> INTEGER = Integer.class;
    private static final Class<?> NUMERIC = BigDecimal.class;

    static {
        Map<Class<?>, Class<?>> typeMapping = new HashMap<>();
        typeMapping.put(boolean.class, Boolean.class);
        typeMapping.put(char.class, String.class);
        typeMapping.put(byte.class, INTEGER);
        typeMapping.put(short.class, INTEGER);
        typeMapping.put(int.class, INTEGER);
        typeMapping.put(long.class, INTEGER);
        typeMapping.put(BigInteger.class, INTEGER);
        typeMapping.put(float.class, NUMERIC);
        typeMapping.put(double.class, NUMERIC);
        TYPE_MAPPINGS = typeMapping;
    }

    @Override
    public Object resolve(Type type) {
        if (type instanceof Class<?>) {
            return TYPE_MAPPINGS.get(type);
        }
        return null;
    }
}
