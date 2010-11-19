/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ivy.osgi.obr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;

import org.apache.ivy.osgi.obr.xml.OBRXMLParser;
import org.apache.ivy.osgi.repo.BundleRepo;
import org.apache.ivy.util.Message;
import org.junit.Test;


public class OBRParserTest {

    @Test
    public void testParse() throws Exception {
        BundleRepo repo = OBRXMLParser.parse(new FileInputStream(new File("java/test-obr/obr.xml")));
        assertNotNull(repo);
        System.out.println(repo.getBundles().size() + " bundles successfully parsed, " +  Message.getProblems().size() + " errors");
        for (Object error : Message.getProblems()) {
            System.err.println(error);
        }
        assertEquals("OBR/Releases", repo.getName());
        assertEquals(new Long(1253581430652l), repo.getLastModified());
    }

}
