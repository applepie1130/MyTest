package com.applepie1130.encryption;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashingEncrypt {

	private static final Logger logger = LoggerFactory.getLogger(HashingEncrypt.class);
	private static final String PLAIN_TEXT = "tjdwns1130";

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

		/* ============ Bcrypt 알고리즘 ============ */
		encryptBcrypt();
		/* ============ Bcrypt 알고리즘 ============ */


		/* ============ PBKDF2 알고리즘 ============ */
		// PBKDF2 해쉬 암호화
		String encryptPBKDF2 = encryptPBKDF2();

		// PBKDF2 해쉬 암호화 결과 유효성검사
		boolean isValid = validatePassword(PLAIN_TEXT, "320bb632a3a5f796bab049aa5a876bdf:c55197e3bea1412f");
		logger.info("값은 유효한가 ?? {}", isValid);
		/* ============ PBKDF2 알고리즘 ============ */
	}

	private static void encryptSHA256() {
		logger.info("SHA256  {}", "");
	}

	private static void encryptBcrypt() {
		String hashpw = BCrypt.hashpw(PLAIN_TEXT, BCrypt.gensalt(12));

		logger.info("Bcrypt  {}", hashpw);
	}

	/**
	 * Start PBKDF2(Password-Based Key Derivation Function)
	 *
	 * @author sungjun.kim
	 *
	 *         {@link} http://d2.naver.com/helloworld/318732
	 *         {@link} http://howtodoinjava.com/security/how-to-generate-secure-
	 *         password-hash-md5-sha-pbkdf2-bcrypt-examples/
	 */
	/**
	 * 해쉬알고리즘 : PBKDF2(Password-Based Key Derivation Function)
	 *
	 * @param 평문
	 * @param 암호학
	 *            솔트
	 * @param interation
	 *            반복수
	 * @param 원하는
	 *            다이제스트 길이
	 *
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private static String encryptPBKDF2() throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iterations = 1000;
		char[] chars = PLAIN_TEXT.toCharArray();
		byte[] salt = getSalt();
		int length = 8;

		PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, length * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();

		String result = toHex(salt) + ":" + toHex(hash);

		logger.info("PBKDF2  {}", result);

		return result;
	}

	/**
	 *
	 * @param originalPassword
	 * @param storedPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] parts = storedPassword.split(":");
		int iterations = 1000;
		byte[] salt = fromHex(parts[0]);
		byte[] hash = fromHex(parts[1]);

		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] testHash = skf.generateSecret(spec).getEncoded();

		// 두 수가 서로 다르면 1 리턴, 같으면 0 (xor 연산)
		int diff = hash.length ^ testHash.length;
		for (int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}

		return diff == 0;
	}

	/**
	 * 다이제스트에 붙일 랜덤 salt 생성
	 *
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);

		logger.info(" salt값 : {}", salt);
		return salt;
	}

	/**
	 * byte 배열로 받은 값에 해당하는 16진수 구하기
	 *
	 * @param array
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();

		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	/**
	 * 16진수를 byte 배열로 변환
	 *
	 * @param hex
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}

		return bytes;
	}
}
