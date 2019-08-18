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

package com.blazebit.notify.expression.persistence.function;

import com.blazebit.notify.domain.boot.model.DomainBuilder;
import com.blazebit.notify.domain.persistence.StaticDomainFunctionTypeResolvers;
import com.blazebit.notify.domain.runtime.model.DomainFunction;
import com.blazebit.notify.domain.runtime.model.DomainFunctionArgument;
import com.blazebit.notify.domain.runtime.model.DomainType;
import com.blazebit.notify.expression.ExpressionInterpreter;
import com.blazebit.notify.expression.spi.FunctionInvoker;
import com.blazebit.notify.expression.spi.FunctionRenderer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.function.Consumer;

public class AbsFunction implements FunctionRenderer, FunctionInvoker {

    private static final AbsFunction INSTANCE = new AbsFunction();

    private AbsFunction() {
    }

    public static void addFunction(DomainBuilder domainBuilder) {
        domainBuilder.createFunction("ABS")
                .withMetadata(new FunctionRendererMetadataDefinition(INSTANCE))
                .withMetadata(new FunctionInvokerMetadataDefinition(INSTANCE))
                .withExactArgumentCount(1)
                .build();
        domainBuilder.withFunctionTypeResolver("ABS", StaticDomainFunctionTypeResolvers.FIRST_ARGUMENT_TYPE);
    }

    @Override
    public Object invoke(ExpressionInterpreter.Context context, DomainFunction function, Map<DomainFunctionArgument, Object> arguments) {
        Object argument = arguments.get(function.getArgument(0));
        if (argument == null) {
            return null;
        }

        if (argument instanceof BigDecimal) {
            return ((BigDecimal) argument).abs();
        } else if (argument instanceof BigInteger) {
            return ((BigInteger) argument).abs();
        } else if (argument instanceof Long) {
            return Math.abs(((Long) argument).longValue());
        } else if (argument instanceof Integer) {
            return Math.abs(((Integer) argument).intValue());
        } else if (argument instanceof Double) {
            return Math.abs(((Double) argument).doubleValue());
        } else if (argument instanceof Float) {
            return Math.abs(((Float) argument).floatValue());
        } else if (argument instanceof Short) {
            return (short) Math.abs(((Short) argument).shortValue());
        } else if (argument instanceof Byte) {
            return (byte) Math.abs(((Byte) argument).byteValue());
        } else {
            throw new IllegalArgumentException("Illegal argument for ABS function: " + argument);
        }
    }

    @Override
    public void render(DomainFunction function, DomainType returnType, Map<DomainFunctionArgument, Consumer<StringBuilder>> argumentRenderers, StringBuilder sb) {
        sb.append("ABS(");
        argumentRenderers.values().iterator().next().accept(sb);
        sb.append(')');
    }
}
