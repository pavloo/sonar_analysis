// //////////////////////////////////////
// BMC Software, Inc.
// Confidential and Proprietary
// Copyright (c) BMC Software, Inc. 2013
// All Rights Reserved.
// //////////////////////////////////////
package com.example_osadchyi;

import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;


import java.io.IOException;

/**
 * Author: pavlo.osadchyi
 * Date: 4/26/13
 * Time: 1:06 PM
 */
public class HelloWorldRestIT {

    @Test
    public void shouldTestHelloMessage() throws IOException {
        String url = "http://localhost:8080/helloapp/restapi/sayhello/paul";
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader("accept", "application/json");
        HttpResponse response = client.execute(getRequest);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }
        String resultJson = IOUtils.toString(response.getEntity().getContent());
        Assert.assertEquals("{\"Reply\":\"Hello, paul\"}", resultJson);
    }

}
