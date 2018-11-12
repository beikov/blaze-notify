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

package com.blazebit.notify.domain.boot.model.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Christian Beikov
 * @since 1.0.0
 */
public class EntityDomainTypeDefinition {

    private final String name;
    private final Class<?> javaType;
    private final Map<String, EntityDomainTypeAttributeDefinition> attributes;

    public EntityDomainTypeDefinition(String name, Class<?> javaType) {
        this.name = name;
        this.javaType = javaType;
        this.attributes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public void addAttribute(EntityDomainTypeAttributeDefinition attribute) {
        attributes.put(attribute.getName(), attribute);
    }

    public EntityDomainTypeAttributeDefinition getAttribute(String name) {
        return attributes.get(name);
    }

    public Map<String, EntityDomainTypeAttributeDefinition> getAttributes() {
        return attributes;
    }
}
