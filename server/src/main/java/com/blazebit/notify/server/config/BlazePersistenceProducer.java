/*
 * Copyright 2018 - 2020 Blazebit.
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

package com.blazebit.notify.server.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

/**
 * @author Christian Beikov
 * @since 1.0.0
 */
@ApplicationScoped
public class BlazePersistenceProducer {

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Produces
    @ApplicationScoped
    CriteriaBuilderFactory createCriteriaBuilderFactory() {
        return Criteria.getDefault()
                .createCriteriaBuilderFactory(entityManagerFactory);
    }
}
