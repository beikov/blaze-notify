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

package com.blazebit.notify.domain.impl.runtime.model;

import com.blazebit.notify.domain.runtime.model.*;

import java.util.Map;

/**
 * @author Christian Beikov
 * @since 1.0.0
 */
public class StaticDomainFunctionTypeResolver implements DomainFunctionTypeResolver {

    public static final DomainFunctionTypeResolver INSTANCE = new StaticDomainFunctionTypeResolver();

    private StaticDomainFunctionTypeResolver() {
    }

    @Override
    public DomainType resolveType(DomainModel domainModel, DomainFunction function, Map<DomainFunctionArgument, DomainType> argumentTypes) {
        return function.getResultType();
    }
}
