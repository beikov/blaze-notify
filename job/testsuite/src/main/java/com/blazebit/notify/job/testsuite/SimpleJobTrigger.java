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

package com.blazebit.notify.job.testsuite;

import com.blazebit.notify.job.JobContext;
import com.blazebit.notify.job.Schedule;
import com.blazebit.notify.job.memory.model.AbstractJobTrigger;

import java.io.Serializable;
import java.util.Map;

public class SimpleJobTrigger extends AbstractJobTrigger<SimpleJob> {

    private final Schedule schedule;

    public SimpleJobTrigger(Schedule schedule, Map<String, Serializable> jobParameters) {
        setJob(new SimpleJob());
        this.schedule = schedule;
        getJobConfiguration().setParameters(jobParameters);
    }

    @Override
    public Schedule getSchedule(JobContext jobContext) {
        return schedule;
    }

}
