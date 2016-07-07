/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2013 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.hermes.core.config;

/**
 * Determines the current runtime environment by reading a system property
 * (specified in environmentKey); if no system property is specified, a
 * (reasonable) default of "runtime.environment" is used.
 */
public class RuntimePropertyEnvironmentKeyResolver {

    protected String environmentKey = "runtime.environment";

    public RuntimePropertyEnvironmentKeyResolver() {
        // EMPTY
    }

    public String resolveRuntimeEnvironmentKey() {
        return System.getProperty(environmentKey);
    }

    public void setEnvironmentKey(String environmentKey) {
        this.environmentKey = environmentKey;
    }
}
