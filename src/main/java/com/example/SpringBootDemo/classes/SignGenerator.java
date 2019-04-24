package com.example.SpringBootDemo.classes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class SignGenerator {

	/**
	 * Generates HMAC-SHA256 signature and returns it as hexadecimal string
	 *
	 * @param aliasCC    - aliasCC or 'noAlias' if aliasCC is not available
	 * @param hexaKey    - merchant's hmac key obtained from web admin tool
	 * @param merchantId - merchant's id
	 * @param amount     - amount in cents
	 * @param currency   - three-letter currency code
	 * @param refno      - reference number
	 * @return hexa HMAC-SHA256 signature (lowercase)
	 *
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String getHexaSHA256Signature(String aliasCC, String hexaKey, String merchantId, String amount,
			String currency, String refno)
			throws IllegalArgumentException, NoSuchAlgorithmException, InvalidKeyException {

		if (hexaKey == null)
			throw new IllegalArgumentException("null key");

		byte[] key = DatatypeConverter.parseHexBinary(hexaKey);
		SecretKeySpec macKey = new SecretKeySpec(key, "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(macKey);
		String valueToSign = aliasCC.trim() + merchantId.trim() + amount.trim() + currency.trim() + refno.trim();
		byte[] result = mac.doFinal(valueToSign.getBytes());
		return DatatypeConverter.printHexBinary(result).toLowerCase();
	}
}
