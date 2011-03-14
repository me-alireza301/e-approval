package com.fairfield.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairfield.dao.GenericDao;
import com.fairfield.dao.UserDao;
import com.fairfield.rules.models.Member;
import com.fairfield.rules.models.User;
import com.fairfield.rules.vo.UserProfile;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserDetailsService{
	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	UserDao userDao;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails userdetail = null;
		try{
			User  user = userDao.getUserByName(username);
			userdetail= new UserProfile(user.getName(), user.getPassword(),0, true, true, true, true, getAuthorities(user));
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return userdetail;
	}
	
	public Collection<GrantedAuthority> getAuthorities(User user) {		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		String roleCode = user.getMemberships().get(0).getRole();
		logger.debug(String.format("GRANT %s TO THIS USER",roleCode));
		authList.add(new GrantedAuthorityImpl(roleCode));
		return authList;
  }

}
