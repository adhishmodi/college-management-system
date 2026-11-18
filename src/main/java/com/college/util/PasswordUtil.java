package com.college.util;
import java.security.MessageDigest; import java.security.SecureRandom; import java.util.Base64;
import javax.crypto.SecretKeyFactory; import javax.crypto.spec.PBEKeySpec;
public final class PasswordUtil {
 private static final int ITERATIONS=120000,KEY_LENGTH=256; private PasswordUtil(){}
 public static String hash(String password){byte[] salt=new byte[16];new SecureRandom().nextBytes(salt);
  return Base64.getEncoder().encodeToString(salt)+":"+Base64.getEncoder().encodeToString(derive(password.toCharArray(),salt));}
 public static boolean verify(String password,String stored){try{String[] p=stored.split(":",2);
  return MessageDigest.isEqual(Base64.getDecoder().decode(p[1]),derive(password.toCharArray(),Base64.getDecoder().decode(p[0])));
 }catch(RuntimeException ex){return false;}}
 private static byte[] derive(char[] password,byte[] salt){PBEKeySpec spec=new PBEKeySpec(password,salt,ITERATIONS,KEY_LENGTH);
  try{return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();}
  catch(Exception ex){throw new IllegalStateException("Password hashing unavailable",ex);}finally{spec.clearPassword();}}
}