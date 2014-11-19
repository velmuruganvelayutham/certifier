package com.certifier.rest.service.test.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CertifierHttpClient {

	String uri = "http://localhost:8080/quiz-app/rest/users/add";
	String jsonEntity = "{\"emailid\":\"vel@gmail.com\",\"password\":\"velmurugan\"}";
	String contentType = "application/json";

	public CertifierHttpClient() {

	}

	public CertifierHttpClient(String uri) {
		this.uri = uri;
		this.jsonEntity = "";
	}

	public CertifierHttpClient(String uri, String json) {
		this.uri = uri;
		this.jsonEntity = json;
	}

	public CertifierHttpClient(String uri, String json, String contentType) {
		this.uri = uri;
		this.jsonEntity = json;
		this.contentType = contentType;
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public int post() {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(uri);
			StringEntity input = new StringEntity(jsonEntity);
			input.setContentType(contentType);
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			httpClient.getConnectionManager().shutdown();
			return statusCode;

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return 0;
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public int postForm(List<NameValuePair> urlParameters) {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			HttpPost postRequest = new HttpPost(uri);
			postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = httpClient.execute(postRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			httpClient.getConnectionManager().shutdown();

			return statusCode;

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return 0;
	}

	public int get() {
		return get(0);
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public int get(int id) {
		try {
			HttpGet getRequest = null;

			DefaultHttpClient httpClient = new DefaultHttpClient();
			if (id == 0) {
				getRequest = new HttpGet(uri);
			} else {
				getRequest = new HttpGet(uri + "/" + id);
			}

			getRequest.addHeader("accept", contentType);

			HttpResponse response = httpClient.execute(getRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			httpClient.getConnectionManager().shutdown();
			return statusCode;

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int submitUploadForm(String fileName) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		int statusCode = 0;
		try {
			HttpPost httppost = new HttpPost(uri);

			FileBody bin = new FileBody(new File(fileName));
			StringBody comment = new StringBody("A binary file of some kind",
					ContentType.TEXT_PLAIN);

			HttpEntity reqEntity = MultipartEntityBuilder.create()
					.addPart("file", bin).addPart("testname", comment).build();

			httppost.setEntity(reqEntity);

			System.out
					.println("executing request " + httppost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httppost);

			try {
				System.out.println("----------------------------------------");
				statusCode = response.getStatusLine().getStatusCode();
				System.out.println(statusCode);
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					System.out.println("Response content length: "
							+ resEntity.getContentLength());
				}
				EntityUtils.consume(resEntity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return statusCode;
	}
}