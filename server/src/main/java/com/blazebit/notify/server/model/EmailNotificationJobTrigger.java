/*
 * Copyright 2018 - 2025 Blazebit.
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

package com.blazebit.notify.server.model;

import com.blazebit.notify.jpa.model.base.AbstractNotificationJobTrigger;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

/**
 * @author Christian Beikov
 * @since 1.0.0
 */
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "job_trigger_seq")
public class EmailNotificationJobTrigger extends AbstractNotificationJobTrigger<EmailNotificationJob> {

    public EmailNotificationJobTrigger() {
    }

    public EmailNotificationJobTrigger(Long id) {
        super(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @Override
    public Long getId() {
        return id();
    }
}
