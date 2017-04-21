/**
 * 
 */
package com.onlineExamination.dao;

import com.onlineExamination.beans.Member;

/**
 * @author Anand
 *
 */
public interface MemberDao {
  public Member getMemberData(String username);
  public boolean validateMember(String username, String password);
  public int RegisterUser(String email, String name, String type, String password);
}
