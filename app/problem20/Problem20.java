package com.webroothackathon.app.problem20;

/*
 * Implement decrypt(String filePath) 
 * decrypt() takes in a UTF-16 encoded file and returns all unique domains (only domains, meaning no scheme or path) that are encrypted in the file
 * All valid domains have extensions com, co.uk, or to.
 *
 * The urls are encrypted by this method:
 *
 * public static char[] encrypt(String url, int encryptKey)
 * {
 * 	char[] encrypted = url.toCharArray();
 *
 * 	for(int i=0;i<encrypted.length;i++)
 * 		encrypted[i] ^= (encryptKey & 0x00FF);
 *
 * 	return encrypted; 
 * }
 *
 * The file does not only contain encrypted urls but is also filled with random characters. 
 * Encrypted urls can span over more than 1 line in the file. 
 * Each file can contain more than one encrypted url, with each url encrypted with a differnt encryptKey.
 *
 * A sample encrypted file (EncryptedStudentSample.txt) is provided. It has three encrypted urls in it:
 * 1. webroot.com
 * 2. brightcloud.com
 * 3. thisisnotafakeurl.co.uk
 *
 * Also add a routing call in for this call with extension /problem20?filePath=
 * The result (String[]) should be stored into a variable named decrytpedUrls.
 * The whole response should be a json string.
 *
 * Hint: Look at how previous problems did their routing.
 */
public class Problem20
{
	/*
	 * Parses an encrypted file and returns unique valid decrypted domains
	 * Valid domains are urls containing extension com, co.uk, or to
	 *
	 * @param (filePath) (filePath of encrypted file)
	 * @return (String[]) (unique valid decryped domains)
	 *
	 */
	public static String[] decrypt(String filePath)
	{
		return new String[0];
	}
}
