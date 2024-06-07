package it.pagopa.swclient.mil;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;

@Path("/perf")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.WILDCARD)
public class PerfResource {
	private static final String GET_ACCESS_TOKEN_RESP = "{\"access_token\":\"eyJraWQiOiJhdXRoNGFkZDY1OGI4YTEzNDVmZWIyZTAwZTc1YzEyYjYxY2YvNWIzODVlNGY0YjQ1NDgzYmE0MDJjZmY4MTIwOWE4MDUiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI4M2MwYjEwZi1iMzk4LTRjYzgtYjM1Ni1hM2UwZjAyOTE2NzkiLCJhdWQiOiJtaWwucGFnb3BhLml0IiwiY2xpZW50SWQiOiI4M2MwYjEwZi1iMzk4LTRjYzgtYjM1Ni1hM2UwZjAyOTE2NzkiLCJjaGFubmVsIjoiQVRNIiwiaXNzIjoiaHR0cHM6Ly9taWwtZC1hcGltLmF6dXJlLWFwaS5uZXQvbWlsLWF1dGgiLCJncm91cHMiOlsiTm90aWNlUGF5ZXIiLCJFbnJvbGxUb0lEUGF5Il0sInRlcm1pbmFsSWQiOiI2NDg3NDQxMiIsImV4cCI6MTcxNzc1ODI1MSwiYWNxdWlyZXJJZCI6IjA2Nzg5IiwiaWF0IjoxNzE3NzU3MzUxfQ.UeFXE0yieBzHCfv2Ju8cUucDUDNWU9zY3uht5nXDutsi46INRL8sd9o9jfPR1MdbXQsrFLW3NTrJaVNYiC9YVuuBuhKGc3MbiOsp3SfjmZEyeesoElwMnfmTCwLvny_W9-VgNCQ097GRA9xc2mD1Q7q6HerJnhPRJ30JllKOuxVXfVXssDbOP-k7_HrUs5Mh-8AXTx11BhA9EBniPn5PtzIv0zYkDVTo_cPBYoFrkubuQPTWTLWds0wPpswg0Vi3LCENdZBbtcQQCp8A65lQKfHQi7BPeV3rlLKfK9zjtSqOG0Poy-EZReU1AVqYQygUEijYEQ2CDmWQpXiI7CZ19QUXMJyeKrBanpH6ASG_MlveQ6RM9EuyMxIyguy6ebqkIMZipwCK4ZHNGrHDVqI0jUudpu1xKNwZ7JQ3E4sMRDN9Q8umviBGkP5cZdlU86dcnRUlSPqyu3xJzia7ywvia651VlywcvyuW7BafMJKcsUiUL9hl1ypobetywa-DPLXV02nECJQnIfQ7IiucyuxCjetSxHEyW2pRnFd2mDjk1J5gL9w7vli2zBQY7XKmAVHzVBz4uBrHhY62qbl47l7YPiugmg9UGG-seoLJzkNlik06OouQUer7wyHVKRI859rNaG92wk2sj_353dLH6eFUiVSkENBWgUJLYW46IhXPYQ\",\"token_type\":\"Bearer\",\"expires_in\":900}";
	private static final String VERIFY_RESPONSE = "{\"outcome\":\"OK\",\"amount\":10000,\"dueDate\":\"2021-07-31\",\"note\":\"pagamentoTest\",\"description\":\"Pagamento di Test\",\"company\":\"companyName\",\"office\":\"officeName\",\"paTaxCode\":\"00000000201\",\"noticeNumber\":\"012345678901234567\"}";
	private static final String ACTIVATE_RESPONSE = "{\"outcome\":\"OK\",\"amount\":10000,\"paTaxCode\":\"00000000201\",\"paymentToken\":\"37b0bb69ce774bc2bfeb485e107ae335\",\"transfers\":[{\"paTaxCode\":\"00000000201\",\"category\":\"\"}]}";
	private static final String GET_FEES_RESPONSE = "{\"fee\":50}";
	private static final String PRECLOSE_RESP = "{\"outcome\":\"OK\"}";
	private static final String PRECLOSE_LOCATION = "3a4d848c6b3db5379b8067cc4a297290";
	private static final String GET_STATUS_RESP = "{\"transactionId\":\"3a4d848c6b3db5379b8067cc4a297290\",\"acquirerId\":\"06789\",\"channel\":\"ATM\",\"merchantId\":null,\"terminalId\":\"64874412\",\"insertTimestamp\":\"2024-06-07T10:51:34\",\"notices\":[{\"paymentToken\":\"37b0bb69ce774bc2bfeb485e107ae335\",\"paTaxCode\":\"00000000201\",\"noticeNumber\":\"012345678901234567\",\"amount\":10000,\"description\":\"TARI 2021\",\"company\":\"companyName\",\"office\":\"officeName\",\"creditorReferenceId\":null,\"debtor\":null}],\"totalAmount\":10000,\"fee\":50,\"status\":\"CLOSED\",\"paymentMethod\":\"PAGOBANCOMAT\",\"paymentTimestamp\":\"2024-06-07T12:52:25\",\"closeTimestamp\":\"2024-06-07T10:52:07\",\"paymentDate\":null,\"callbackTimestamp\":null,\"preset\":null}";

	@Path("/mil-auth/token")
	@POST
	public Response getAccessToken() {
		return Response.ok(GET_ACCESS_TOKEN_RESP).build();
	}

	@Path("/mil-payment-notice/paymentNotices/{pa_tax_code}/{notice_number}")
	@GET
	public Response verify() {
		return Response.ok(VERIFY_RESPONSE).build();
	}

	@Path("/mil-payment-notice/paymentNotices/{qr_code}")
	@GET
	public Response verifyQr() {
		return Response.ok(VERIFY_RESPONSE).build();
	}

	@Path("/mil-payment-notice/paymentNotices/{pa_tax_code}/{notice_number}")
	@PATCH
	public Response activate() {
		return Response.ok(ACTIVATE_RESPONSE).build();
	}

	@Path("/mil-payment-notice/paymentNotices/{qr_code}")
	@PATCH
	public Response activateQr() {
		return Response.ok(ACTIVATE_RESPONSE).build();
	}

	@Path("/mil-fee-calculator/fees")
	@POST
	public Response getFees() {
		return Response.ok(GET_FEES_RESPONSE).build();
	}

	@Path("/mil-payment-notice/payments")
	@POST
	public Response preClose(@Context UriInfo uriInfo) {
		return Response.status(Status.CREATED)
			.location(uriInfo.getAbsolutePathBuilder().path(PRECLOSE_LOCATION).build())
			.entity(PRECLOSE_RESP)
            .build();
	}
	
	@Path("/mil-payment-notice/payments/{transaction_id}/sendPaymentOutcome")
	@PATCH
	public Response sendPaymentOutcome() {
		return Response.noContent().build();
	}
	
	@Path("/mil-payment-notice/payments/{transaction_id}")
	@GET
	public Response getStatus() {
		return Response.ok(GET_STATUS_RESP).build();
	}
}
