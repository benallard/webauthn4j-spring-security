/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sharplab.springframework.security.webauthn.metadata;


import com.webauthn4j.converter.util.JsonConverter;
import org.junit.Test;

public class JsonFileResourceMetadataItemListProviderTest {

    private JsonConverter jsonConverter = new JsonConverter();

    private JsonFileResourceMetadataItemListProvider target = new JsonFileResourceMetadataItemListProvider(jsonConverter);

    @Test(expected = IllegalArgumentException.class)
    public void resources_not_configured_test(){
        target.provide();
    }

}